package com.hyp.ujs.em.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyp.ujs.em.commons.constant.CommonCode;
import com.hyp.ujs.em.commons.data.ServiceException;
import com.hyp.ujs.em.config.listener.DeviceDataListener;
import com.hyp.ujs.em.dto.DeviceDetailStatusDto;
import com.hyp.ujs.em.dto.DeviceDto;
import com.hyp.ujs.em.entity.DeviceDetail;
import com.hyp.ujs.em.service.IDeviceDetailService;
import com.hyp.ujs.em.utils.QRCodeUtil;
import com.hyp.ujs.em.vo.DeviceDetailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 设备 前端控制器
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Api(tags = "设备")
@RestController
@RequestMapping("/device-details")
@Slf4j
public class DeviceDetailController {

    @Autowired
    private IDeviceDetailService detailService;


    @GetMapping("/status")
    public List<DeviceDetailStatusDto> listDeviceStatus() {
        return detailService.listDeviceStatus();
    }


    @PostMapping("/")
    public DeviceDetail add(@RequestBody DeviceDetail deviceDetail) {
        if (detailService.save(deviceDetail)) {
            return deviceDetail;
        } else {
            return null;
        }
    }

    @PutMapping("/")
    public DeviceDetail update(@RequestBody DeviceDetail deviceDetail) {
        if (detailService.updateById(deviceDetail)) {
            return deviceDetail;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return detailService.removeById(id);
    }

    @GetMapping("/{id}")
    public DeviceDetail get(@PathVariable("id") Integer id) {
        return detailService.getById(id);
    }

    @GetMapping("/")
    public Page<DeviceDetail> list(DeviceDetailVo vo) {
        DeviceDetail detail = new DeviceDetail();
        BeanUtils.copyProperties(vo, detail);
        Page<DeviceDetail> page = new Page<>((vo.getPn() - 1) * vo.getPs(), vo.getPs());
        return detailService.page(page, Wrappers.query(detail));
    }


    /**
     * 模板文件放在static文件夹下doc/Device_upload_sample_file.xlsx
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping(path = "/template")
    @ApiOperation("模板下载")
    public String getTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String serviceRoot = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        return serviceRoot + "doc/Device_upload_sample_file.xlsx";
    }

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>1. 创建excel对应的实体对象
     * <p>2. 设置返回的 参数
     * <p>3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("/export")
    @ApiOperation("导出")
    public void download(HttpServletResponse response,
                         @RequestParam(defaultValue = "2010-01-01") String from,
                         @RequestParam(defaultValue = "2030-01-01") String to) throws IOException {
        try {
            LocalDate fromDate = LocalDate.parse(from);
            LocalDate toDate = LocalDate.parse(to);

            DeviceDetail deviceDetail = new DeviceDetail();
            List<DeviceDetail> details = detailService.list(Wrappers.query(deviceDetail).between("create_time", fromDate, toDate));

            List<DeviceDto> dtos = details.stream().map(
                    (item) -> {
                        DeviceDto dto = new DeviceDto();
                        BeanUtils.copyProperties(item, dto);
                        if (Objects.nonNull(item.getEndDate())) {
                            dto.setEndDate(item.getEndDate().toString());
                        }
                        if (Objects.nonNull(item.getInstallDate())) {
                            dto.setInstallDate(item.getInstallDate().toString());
                        }


                        return dto;
                    }
            ).collect(Collectors.toList());
            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("设备信息" + from.toString() + "to" + to.toString(), "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");


            EasyExcel.write(response.getOutputStream(), DeviceDto.class).sheet(from.toString() + "to" + to.toString()).doWrite(dtos);

        } catch (Exception e) {
            throw new ServiceException("下载文件失败" + e.getMessage(), CommonCode.MISSING_REQUEST_PARAM_ERROR);

        }
    }

    /**
     * 文件上传
     * <p>
     * 1. 创建excel对应的实体对象
     * <p>
     * 2. 由于默认异步读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DeviceDataListener}
     * <p>
     * 3. 直接读即可
     */
    @PostMapping("/import")
    @ResponseBody
    @ApiOperation("导入")
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), DeviceDto.class, new DeviceDataListener(detailService)).sheet().doRead();
        return "success";
    }

    /**
     * 根据 url 生成 普通二维码
     */
    @GetMapping(value = "/{id}/qrcode")
    @ApiOperation("根据id生成 普通二维码")
    public void createQRCode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
        ServletOutputStream stream = null;
        try {
            DeviceDetail detail = detailService.getById(id);
            if (detail != null) {
                stream = response.getOutputStream();
                String s = JSONObject.toJSONString(detail);
                log.warn("生成二维码,信息：\n{}\n", s);
                //使用工具类生成二维码
                QRCodeUtil.encode(s, stream);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }


//    /**
//     * 根据 url 生成 带有logo二维码
//     */
//    @RequestMapping(value = "/createLogoQRCode")
//    public void createLogoQRCode(HttpServletResponse response, String url) throws Exception {
//        ServletOutputStream stream = null;
//        try {
//            stream = response.getOutputStream();
//            String logoPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()
//                    + "templates" + File.separator + "logo.jpg";
//            //使用工具类生成二维码
//            QRCodeUtil.encode(url, logoPath, stream, true);
//        } catch (Exception e) {
//            e.getStackTrace();
//        } finally {
//            if (stream != null) {
//                stream.flush();
//                stream.close();
//            }
//        }
//    }

}
