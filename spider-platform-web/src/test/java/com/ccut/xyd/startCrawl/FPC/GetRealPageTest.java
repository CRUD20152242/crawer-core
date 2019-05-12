package com.ccut.xyd.startCrawl.FPC;

import com.ccut.xyd.VO.InitVo;
import com.ccut.xyd.crawer.StartCrawl;
import com.ccut.xyd.crawl.DemoWebcollector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//测试针对百度百科的反爬虫措施
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class GetRealPageTest {

    @Autowired
    StartCrawl startCrawl;

    DemoWebcollector demoWebcollector;

    private InitVo initVo;

    @Before
    public void init(){
        demoWebcollector = new DemoWebcollector("baidubaike",false);
        demoWebcollector.addSeed("https://baike.baidu.com/item/习近平/515617?fr=aladdin");
        demoWebcollector.setThreads(1);
//        initVo = new InitVo();
////        添加种子
//        initVo.setSeed("");
    }

    @Test
    public void fpc(){
        try {
            demoWebcollector.start(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
