package com.ccut.xyd.crawl;

import com.ccut.xyd.VO.InitVo;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class StartCrawlImplTest {

    StartCrawlImpl startCrawl = new StartCrawlImpl();
    InitVo initVo = new InitVo();
    @Before
    public void init(){
        initVo.setSeed("https://www.csdn.net/");
        initVo.setDeep("2");
        initVo.setThreads("10");
        initVo.setFileName("test1");
    }


    @Test
    public void testDefault(){
        InitVo initVo1 = new InitVo();
        System.out.println(initVo1);
    }
    @Test
    public void startCrawl() {
//        startCrawl.startCrawl();
//        System.out.println("init = "+initVo.getDeep());
    }

//测试加载js
    @Test
    public void testJs(){
        final WebClient mWebClient = new WebClient();
        final HtmlPage mHtmlPage;
        try {
            mHtmlPage = mWebClient.getPage("http://www.baidu.com");
            System.out.println(mHtmlPage.asText());
            mWebClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}