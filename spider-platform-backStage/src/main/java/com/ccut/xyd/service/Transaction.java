package com.ccut.xyd.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *事务管理
 */
@Slf4j
@Service("transactionManage")
public class Transaction {
    @Autowired
    protected PlatformTransactionManager transactionManager;

    /**
     * 开启事务
     */
    protected TransactionStatus init(){
        log.info("准备开启事务");
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
        log.info("事务已开启");
        return status;
    }

    /**
     * 提交事务
     * @param status
     */
    protected void commit(TransactionStatus status){
        if (status != null)
        {
            transactionManager.commit(status);
            log.info("事务提交");
        }
        else
            log.info("TransactionStatus is null");
    }

    /**
     * 事务回滚
     *
     * @param status
     */
    protected void rollBack(TransactionStatus status){
        if (status!=null){
            transactionManager.rollback(status);
            log.info("事务已回滚");
        } else
            log.info("TransactionStatus is null");

    }

}
