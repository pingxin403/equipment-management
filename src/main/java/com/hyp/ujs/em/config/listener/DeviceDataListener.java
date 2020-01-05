package com.hyp.ujs.em.config.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hyp.ujs.em.dto.DeviceDto;
import com.hyp.ujs.em.entity.DeviceDetail;
import com.hyp.ujs.em.service.IDeviceDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hyp
 * Project name is equipment-management
 * Include in com.hyp.ujs.em.config.listener
 * hyp create at 20-1-4
 **/
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class DeviceDataListener extends AnalysisEventListener<DeviceDto> {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DeviceDataListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<DeviceDto> list = new ArrayList<DeviceDto>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */

    private IDeviceDetailService deviceDetailService;


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public DeviceDataListener(IDeviceDetailService deviceDetailService) {
        this.deviceDetailService = deviceDetailService;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(DeviceDto data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        List<DeviceDetail> details = list.stream().map(
                (item) -> {
                    DeviceDetail detail = new DeviceDetail();
                    BeanUtils.copyProperties(item, detail);
                    if (StringUtils.isNotBlank(item.getEndDate())) {
                        detail.setEndDate(LocalDate.parse(item.getEndDate()));
                    }
                    if (StringUtils.isNotBlank(item.getInstallDate())) {
                        detail.setInstallDate(LocalDate.parse(item.getInstallDate()));
                    }
                    return detail;
                }
        ).collect(Collectors.toList());

        //有id则更新否则新增
        deviceDetailService.saveOrUpdateBatch(details);
        LOGGER.info("存储数据库成功！");
    }
}