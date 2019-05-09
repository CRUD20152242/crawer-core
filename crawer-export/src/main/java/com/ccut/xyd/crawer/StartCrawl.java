package com.ccut.xyd.crawer;

import com.ccut.xyd.Model.Page;
import com.ccut.xyd.VO.InitVo;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 爬虫的抓取设置
 */
public interface StartCrawl {
    /**
     * 获取源码的方法
     * @return
     */
    Page getPage();

    void setPage(Page page);
    /**
     * 获取连接
     * @param url
     * @return
     */
    String getConnection(String url);

    /**
     * 设置连接过滤规则
     * @return
     */
    HashMap<String,String> setRules();

    /**
     * 启动爬虫
     */
    void startCrawl(InitVo initVo);

}
