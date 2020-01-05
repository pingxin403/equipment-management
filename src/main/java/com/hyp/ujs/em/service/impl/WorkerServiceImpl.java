package com.hyp.ujs.em.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyp.ujs.em.entity.Worker;
import com.hyp.ujs.em.mapper.WorkerMapper;
import com.hyp.ujs.em.service.IWorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工 服务实现类
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
@Service
@Slf4j
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements IWorkerService {

    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public void sendMsg(Integer serviceId, String msg) {
        Worker worker = new Worker();
        worker.setServiceId(serviceId);
        List<Worker> workers = workerMapper.selectList(Wrappers.query(worker));
        workers.forEach((item) -> {
            sendMsg(item, msg);
        });

    }

    private void sendMsg(Worker worker, String msg) {
        log.warn("已经向{}发送通知，消息内容:{}\n", worker.getRealName(), msg);
    }
}
