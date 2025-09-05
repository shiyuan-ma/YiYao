// 模块: ruoyi-system
// 包: com.ruoyi.system.service.impl
package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.BusinessDayClassifier;
import com.ruoyi.common.utils.PublicIpFetcher;
import com.ruoyi.system.domain.Comment;
import com.ruoyi.system.domain.Daylog;
import com.ruoyi.system.mapper.CommentMapper;
import com.ruoyi.system.mapper.TopicMapper;
import com.ruoyi.system.mapper.UserMapper;
import com.ruoyi.system.service.IStudentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service // 【关键】标记为Spring的服务组件
public class StudentLogServiceImpl implements IStudentLogService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private DaylogServiceImpl daylogService;
    @Autowired
    private BusinessDayClassifier businessDayClassifier;
    @Autowired
    private PublicIpFetcher publicIpFetcherl;

    @Override
    public int addComment(String userId) {
        List<Daylog> daylogs = daylogService.selectDaylogAll(); // 获取所有日志
        int syr = 0;

        for (Daylog daylog : daylogs) {
            Date checkDate = daylog.getTime();
            LocalDateTime checkTime = checkDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            System.out.println("--- 开始处理时间戳: " + checkTime + " ---");
            // 步骤1: 获取当前业务日的时间窗口
            Map.Entry<LocalDateTime, LocalDateTime> window =
                    businessDayClassifier.getBusinessDayWindow();
            LocalDateTime windowStart = window.getKey();
            LocalDateTime windowEnd = window.getValue();
            System.out.println("当前业务日窗口为: [" + windowStart + ", " + windowEnd + ")");
            // 步骤2: 根据 checkTime 与窗口的位置关系进行分类判断
            if (checkTime.isBefore(windowStart)) {
                System.out.println("判断: 时间戳在业务日窗口开始之前，分类为【过去时间】。");
                //processDayAgolog(daylog);
            } else if (checkTime.isBefore(windowEnd)) {
                System.out.println("判断: 时间戳在业务日窗口之内，分类为【当前时间】。");
                syr = processDaylog(daylog,userId);
            } else {
                System.out.println("判断: 时间戳在业务日窗口结束之后，分类为【将来时间】，不执行任何操作。");
            }
            System.out.println("--- 处理结束 ---\n");
        }
        return syr;
    }

    // 处理当天的日志
    private int processDaylog(Daylog daylog,String userId) {
        Comment Comment = buildComment(daylog,userId);  // 构建评论对象
        if (commentMapper.selectIsInsert(userId, Comment.getTopicId()).isEmpty()) {
            return insertComment(Comment);  // 如果日志不存在，插入
            //return 1;
        } else {
            System.out.println("已经存在此日志，无需插入。");
            return 0;  // 如果日志已存在，则不插入
        }
    }

    // 构建评论内容
    private Comment buildComment(Daylog daylog,String userId) {
        Comment Comment = new Comment();
        String[] lines = daylog.getText().split("\r?\n");
        StringBuilder contentHtml = new StringBuilder();
        String ip = publicIpFetcherl.getPublicIp();
        contentHtml.append("<p><strong>完成工作：</strong></p>");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                contentHtml.append("<p>").append(line.trim()).append("<br></p>");
            }
        }
        contentHtml.append("<p><strong>需重点说明，协调与帮助：</strong></p><p><span>无</span></p>");
        contentHtml.append("<p><strong>明日工作计划：</strong></p><p><span>无</span></p>");

        Comment.setContent(contentHtml.toString());
        Comment.setIp(ip);
        Comment.setIsStaff(0);

        Random random = new Random();
        // 生成0到30分钟内的随机毫秒数 (30 * 60 * 1000 = 1,800,000)
        long randomMillis = random.nextInt(20 * 60 * 1000);
        Date now = new Date();
        Date randomPostTime = new Date(now.getTime() + randomMillis);
        Comment.setPostTime(randomPostTime); // 将新生成的随机时间设置到对象中

        Comment.setQuoteIdGroup(",");
        Comment.setQuoteUpdateId(",");
        Comment.setStatus(20L);
        Comment.setTopicId(topicMapper.selectTopicId().getId());
        Comment.setUserName(userId);
        System.out.println(Comment.toString() + "++++" + Comment.getTopicId());
        return Comment;
    }

    // 插入评论
    private int insertComment(Comment Comment) {
        try {
            int syr = commentMapper.insertComment(Comment);
            if (syr <= 0) {
                System.out.println("日志提交失败，数据库未受影响。");
            }
            return syr;
        } catch (Exception e) {
            System.out.println("日志提交失败，发生服务器内部错误。");
            e.printStackTrace();  // 打印错误栈
            return 0;
        }
    }


    /**
     * 此方法已停用
     * @param daylog
     * @return
     */
    // 处理前几天的日志
    private int processDayAgolog(Daylog daylog) {
        Comment Comment = buildCommentDayAgo(daylog);  // 构建评论对象
        if (commentMapper.selectIsInsert("YNaBK6rFfC2yduLkzYI", Comment.getTopicId()).isEmpty()) {
            //return insertComment(Comment);  // 如果日志不存在，插入
            return 1;
        } else {
            System.out.println("已经存在此日志，无需插入。");
            return 0;  // 如果日志已存在，则不插入
        }
    }

    private Comment buildCommentDayAgo(Daylog daylog) {
        Comment Comment = new Comment();
        String[] lines = daylog.getText().split("\r?\n");
        StringBuilder contentHtml = new StringBuilder();
        String ip = publicIpFetcherl.getPublicIp();
        contentHtml.append("<p><strong>完成工作：</strong></p>");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                contentHtml.append("<p>").append(line.trim()).append("<br></p>");
            }
        }
        contentHtml.append("<p><strong>需重点说明，协调与帮助：</strong></p><p><span>无</span></p>");
        contentHtml.append("<p><strong>明日工作计划：</strong></p><p><span>无</span></p>");

        Comment.setContent(contentHtml.toString());
        Comment.setIp(ip);
        Comment.setIsStaff(0);
        Comment.setPostTime(daylog.getTime());
        Comment.setQuoteIdGroup(",");
        Comment.setQuoteUpdateId(",");
        Comment.setStatus(20L);
        Comment.setTopicId(daylog.getTopicid());
        Comment.setUserName("YNaBK6rFfC2yduLkzYI");

        System.out.println(Comment.toString() + "++++" + Comment.getTopicId());

        return Comment;
    }
}
