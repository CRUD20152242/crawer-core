package com.ccut.xyd.service.Impl;

import com.ccut.xyd.Po.TaskStatePo;
import com.ccut.xyd.crawl.TaskDao;
import com.ccut.xyd.service.TaskStateService;
import com.ccut.xyd.service.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

import java.util.List;

@Slf4j
@Service
public class TaskStateImpl extends Transaction implements TaskStateService {

    @Autowired
    private  TaskDao taskDao;
    private  TransactionStatus transactionStatus;

    /**
     * 添加任务 先查taskId是否重复
    * @param po
     */
    public boolean addTaskState(TaskStatePo po) {
        log.info("正在添加任务状态 taskId is {}",po.getTaskId());
        transactionStatus = init();
        try {
            if (null!=taskDao.checkTaskId(po.getTaskId())){
                rollBack(transactionStatus);
                return false;
            }
            taskDao.addTaskState(po);
            commit(transactionStatus);
        } catch (Exception e) {
            e.printStackTrace();
            rollBack(transactionStatus);
            return false;
        }
        return true;
    }

    public List<TaskStatePo> searchTaskState(String taskName) {
        log.info("根据任务名称查询任务 taskName is {}",taskName);
        return taskDao.searchTaskState(taskName);
    }

    public void updateState(TaskStatePo po) {
        log.info("正在修改任务状态 taskid is {}",po.getTaskId());
        transactionStatus = init();
        try {
        taskDao.updateState(po);
            commit(transactionStatus);
        } catch (Exception e) {
            e.printStackTrace();
            transactionStatus.setRollbackOnly();
            rollBack(transactionStatus);
        }

    }
}
