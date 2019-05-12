package com.ccut.xyd.dubboRef;

import com.ccut.xyd.ParsePage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 你能用吗？
 */
public class consumer {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-dubbo-provider");
        ((ClassPathXmlApplicationContext) applicationContext).start();

        ParsePage p = applicationContext.getBean("parsePage", ParsePage.class);
        p.getUrlAndParsePage(null,null);
    }
}
