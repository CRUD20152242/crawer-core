package com.ccut.xyd.service.Impl;

import com.ccut.xyd.Po.TaskRulePo;
import com.ccut.xyd.crawl.RuleDao;
import com.ccut.xyd.service.RuleService;
import com.ccut.xyd.service.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

@Slf4j
@Service
public class RuleServiceImpl extends Transaction implements RuleService {

    @Autowired
    RuleDao ruleDao;

    TransactionStatus transactionStatus;
    public void addRule(TaskRulePo po) {
        log.info("正在准备增加规则入库 {}",po.toString());
        try {
            transactionStatus = init();
            ruleDao.addRule(po);
            commit(transactionStatus);
        } catch (Exception e) {
            e.printStackTrace();
            rollBack(transactionStatus);
        }
    }

    public TaskRulePo searchRule(TaskRulePo po) {
        log.info("正在查询规则库 {}",po.toString());
        return  ruleDao.searchRule(po);
    }
}
