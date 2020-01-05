package com.hyp.ujs.em.service;

import com.hyp.ujs.em.entity.Worker;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工 服务类
 * </p>
 *
 * @author pingxin
 * @since 2020-01-04
 */
public interface IWorkerService extends IService<Worker> {

    public void sendMsg(Integer serviceId,String msg);

}
