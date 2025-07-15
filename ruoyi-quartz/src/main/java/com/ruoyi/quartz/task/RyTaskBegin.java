package com.ruoyi.quartz.task;

import com.ruoyi.system.enumn.AccountEnum;
import com.ruoyi.system.service.IStudentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("ryTaskBegin")
public class RyTaskBegin
{
    @Autowired // 【关键】同样注入这个Service
    private IStudentLogService studentLogService;
    public void myTask(String userName) {
        String userId = AccountEnum.getIdByRemark(userName);
        System.out.println("___定时任务开始执行...___");
        // 直接调用Service层的方法
        studentLogService.addComment(userId);
        System.out.println("___定时任务执行完毕...___");
    }
}
