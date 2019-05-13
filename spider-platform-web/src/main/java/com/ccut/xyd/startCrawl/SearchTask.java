package com.ccut.xyd.startCrawl;

import com.ccut.xyd.Vo.TaskInfoVo;
import com.ccut.xyd.Vo.TaskVo;
import com.ccut.xyd.service.TaskServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class SearchTask {

    @Autowired
    private TaskServices taskServices;

    @RequestMapping("/searchTask")
    @ResponseBody
    public List<TaskInfoVo> searchTaskDetail(TaskVo taskVo){
        log.info("准备开始根据任务名字查询任务 vo = {}",taskVo);
        List<TaskInfoVo> res;
        try {
            res =  taskServices.getTaskDetail(taskVo.getTaskName());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }

}
