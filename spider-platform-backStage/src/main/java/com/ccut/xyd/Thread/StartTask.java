package com.ccut.xyd.Thread;

import com.ccut.xyd.ParsePage;
import com.ccut.xyd.Po.TaskStatePo;
import com.ccut.xyd.Utils.ParameterTransferUtil;
import com.ccut.xyd.VO.InitVo;
import com.ccut.xyd.VO.MessageVo;
import com.ccut.xyd.crawer.StartCrawl;
import com.ccut.xyd.crawl.TaskDao;
import com.ccut.xyd.service.TaskStateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StartTask {

    @Autowired
    private StartCrawl startCrawl;
    @Autowired
    private ThreadExecutor threadExecutor;
    @Autowired
    private ParsePage parsePage;//波浪线不影响
    @Autowired
    private TaskStateService taskStateService;

    public MessageVo setCrawl(InitVo initVo){
        MessageVo messageVo = new MessageVo();
        try {
            TaskStatePo task = ParameterTransferUtil.buildTaskState(initVo);
            taskStateService.addTaskState(task);
            log.info("任务初始化进入数据库成功");
            CrawlTask crawlTask = new CrawlTask(startCrawl,initVo,parsePage,taskStateService);
            threadExecutor.submit(crawlTask);
            messageVo.setMessage("success");
        } catch (Exception e) {
            e.printStackTrace();
            messageVo.setMessage("error");
        }
        return  messageVo;
    }

}
