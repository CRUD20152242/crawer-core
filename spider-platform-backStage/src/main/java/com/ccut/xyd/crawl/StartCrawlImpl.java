package com.ccut.xyd.crawl;

import com.ccut.xyd.FetchPages;
import com.ccut.xyd.FetchPagesUseJs;
import com.ccut.xyd.Model.Page;
import com.ccut.xyd.ParsePage;
import com.ccut.xyd.VO.InitVo;
import com.ccut.xyd.crawer.StartCrawl;
import com.mchange.lang.IntegerUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class StartCrawlImpl implements StartCrawl {

    public String getConnection(String url) {
        return null;
    }

    public HashMap<String, String> setRules() {
        return null;
    }

    /**
     * 启动爬虫
     * @param initVo
     */
    public void startCrawl(InitVo initVo,ParsePage parsePage) {
//        是否启动抓取JS的数据  暂时禁用因为有bug
        if(initVo.isTurbo()){
            FetchPagesUseJs fetchPagesUseJs = new FetchPagesUseJs();
            fetchPagesUseJs.parsePage(initVo);
            return;
        }
        log.info("准备开始启动爬虫 initVo = {}",initVo.toString());
        //参数校验开始

//            以下if  else较多 可以用责任链模式
        if(StringUtils.isEmpty(initVo.getSeed())){
            log.info("seed is null");
                return;
        }

        if (StringUtils.isEmpty(initVo.getFileName())){
            log.info("the file name is null");
            return;
        }

        if (StringUtils.isEmpty(initVo.getThreads())){
            initVo.setThreads("10");
        }

        if (StringUtils.isEmpty(initVo.getDeep())){
            initVo.setDeep("1");
        }
        try {
        FetchPages fetchPages = new FetchPages(initVo.getFileName(),initVo.isAutoParse(),initVo,parsePage);
        fetchPages.addSeed(initVo.getSeed());
        if (StringUtils.isNotEmpty(initVo.getRegex1())){
            log.info("准备添加过滤规则1：{}",initVo.getRegex1());
            fetchPages.addRegex(initVo.getRegex1());
        }
        if (StringUtils.isNotEmpty(initVo.getRegex2())){
            log.info("准备添加过滤规则2：{}",initVo.getRegex2());
            fetchPages.addRegex(initVo.getRegex2());
        }
        if (StringUtils.isNotEmpty(initVo.getRegex3())){
            log.info("准备添加过滤规则3：{}",initVo.getRegex3());
            fetchPages.addRegex(initVo.getRegex3());
        }
        if (StringUtils.isNotEmpty(initVo.getRegex4())){
            log.info("准备添加过滤规则4：{}",initVo.getRegex4());
            fetchPages.addRegex(initVo.getRegex4());
        }

            fetchPages.setThreads(Integer.valueOf(initVo.getThreads()));
            fetchPages.start(Integer.valueOf(initVo.getDeep()));
            log.info("启动爬虫成功");
        } catch (Exception e) {
            log.error("启动爬虫失败：initVo={}",initVo.toString());
            e.printStackTrace();
        }

    }
}
