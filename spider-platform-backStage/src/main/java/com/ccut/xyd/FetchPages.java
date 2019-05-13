package com.ccut.xyd;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.ccut.xyd.Utils.ParameterTransferUtil;
import com.ccut.xyd.VO.InitVo;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
 * 将获取到的html源代码，交给解析系统来处理，返回该页面的所有链接
 */
@Slf4j
public class FetchPages extends BreadthCrawler {

    private InitVo initVo;
    private  ParsePage parsePage;
    public FetchPages(String crawlPath, boolean autoParse,InitVo initVo,ParsePage parsePage){
        super(crawlPath,autoParse);
        this.initVo = initVo;
        this.parsePage = parsePage;
    }
    public void visit(Page page, CrawlDatums crawlDatums) {
        int sum = initVo.getUrls();
        initVo.setUrls(sum++);
        log.info("--------准备封装页面解析任务，异步交给解析模块进行处理 任务名字：{}  -------------------------",page.url());
        List<String> links  = parsePage.getUrlAndParsePage(page.html(), ParameterTransferUtil.buildTaskModel(this.initVo));
        log.info("---------提交page成功！！！！-------------------------------------------------------------------");

        if(links.size()>0){
            log.info("------------------------------解析链接成功，提交至种子库----------------------------");
            for (String url:links) {
                crawlDatums.add(url);
            }
        }else {
            log.error("----------------    {} 未提取到合格链接，请注意验证-----------------",page.url());
        }

    }
}
