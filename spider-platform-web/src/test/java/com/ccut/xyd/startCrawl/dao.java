package com.ccut.xyd.startCrawl;


import com.ccut.xyd.Po.TaskStatePo;
import com.ccut.xyd.crawl.TaskDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class dao {

//    @Autowired
//    com.ccut.xyd.Test test;

    @Autowired
    TaskDao taskDao;
    TaskStatePo taskStatePo;

    @Before
    public void init(){
        taskStatePo = new TaskStatePo();
        taskStatePo.setDeep(1);
        taskStatePo.setState(0);
        taskStatePo.setUrl("www.test.com");
        taskStatePo.setTaskId("hello".hashCode());
        taskStatePo.setTaskName("测试数据");
        Long time = System.currentTimeMillis();
        taskStatePo.setCreateTime(String.valueOf(time));
    }

    @Test
    public void test(){
//        Assert.assertEquals("sucess",test.getName());
//        taskDao.addTaskState(taskStatePo);
//        List<TaskStatePo> po = taskDao.searchTaskState("测试数据");;
//        System.out.println(po.get(0).toString());
//        taskDao.updateState(2);


    }

}
