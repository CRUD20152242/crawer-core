package com.ccut.xyd.startCrawl;

import com.ccut.xyd.ParsePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dubbo-consumer")
public class StartControllerTest {

    @Autowired
    ParsePage parsePage;
    @Test
    public void startCrawl() {
        parsePage.getUrlAndParsePage(null,null);
    }
}