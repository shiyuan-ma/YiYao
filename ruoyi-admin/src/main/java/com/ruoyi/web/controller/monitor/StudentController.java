package com.ruoyi.web.controller.monitor;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.system.domain.Comment;
import com.ruoyi.system.domain.Daylog;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.mapper.CommentMapper;
import com.ruoyi.system.mapper.TopicMapper;
import com.ruoyi.system.mapper.UserMapper;
import com.ruoyi.system.service.IStudentLogService;
import com.ruoyi.system.service.impl.DaylogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static com.ruoyi.common.enums.DataSourceType.SLAVE;

@Controller
@Component
public class StudentController {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userSetMapper;
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private DaylogServiceImpl daylogService;
    @Autowired // 【关键】注入我们刚刚创建的Service
    private IStudentLogService studentLogService;


    /**
     * 查询所有用户信息，无传入参数
     * @return
     */
    @GetMapping("/1")
    @ResponseBody
    @DataSource(SLAVE) // 指定使用从数据源
    public String selectAllUser()
    {
        StringBuffer stringBuffer = new StringBuffer();
        List<User> userSets = userSetMapper.selectByExample();

        for(int i=0;i<userSets.size();i++) {
            String userName = userSets.get(i).getNickname();
            String userID = userSets.get(i).getUsername();
            List userList = new ArrayList();
            userList.add("E04XUBMZmuPG0vdiiD2");
            userList.add("WowxLEU4hBH1urbpXBJ");
            userList.add("pPyI3pYDFUtmkjQ4Sdr");
            userList.add("TxfE0OXIcDZuH0dUQOf");
            userList.add("ToyC9cilEP3rSk4o1HM");
            if(userList.contains(userID)) {
                stringBuffer.append(userName+"-----"+userID+"<br>");
            }
        }
        return stringBuffer.toString();
    }



    @GetMapping("/2/{userName}")
    @ResponseBody
    @DataSource(SLAVE) // 指定使用从数据源
    public String selectAll(@PathVariable("userName") String userName)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        StringBuffer stringBuffer = new StringBuffer();
//        System.out.println(userName);
//        userName = "WowxLEU4hBH1urbpXBJ";
        List<Comment> students = commentMapper.selectAll(userName);

        for(int i=0;i<students.size();i++) {
            Date data = students.get(i).getPostTime();
            String fromateDate = simpleDateFormat.format(data);
            String content = students.get(i).getContent();
            String newContent = content.replaceAll("<p><span style=\"background-color: #FFFFFF; color: #272E3B; \">","")
                    .replaceAll("<strong>","").
                            replaceAll("</span>","").
                            replaceAll("<div>","").
                            replaceAll("<br>","").
                            replaceAll("</div>","");
            stringBuffer.append("《"+fromateDate+"！！！！！！！"+newContent+"》"+"\n");
        }
        return stringBuffer.toString();
    }

    @GetMapping("/show-add-page")
    public String showAddLogPage() {
        // 返回的 "add-log" 会被视图解析器处理成 "/WEB-INF/jsp/add-log.jsp"
        return "add-log";
    }


//    @PostMapping("/submit-log")
//    @ResponseBody
//    @DataSource(SLAVE) // 指定使用从数据源
//    public String handleLogSubmission(
//            @RequestParam("logContent") String logContent,
//            @RequestParam("topicId") String topicIDataSourcetr,
//            @RequestParam("postTime") String postTimeStr, // 1. 接收时间字符串
//            @RequestParam("logPerson") String logPersonUsername,
//            HttpServletRequest request) { // 3. 注入 HttpServletRequest 以获取IP
//
//        // --- 参数校验 ---
//        if (StringUtils.isNullOrEmpty(topicIDataSourcetr)) {
//            return "日志主题ID不能为空！";
//        }
//        if (StringUtils.isNullOrEmpty(logPersonUsername)) { // ★★★ 校验提交人
//            return "请选择提交人！";
//        }
//        if (StringUtils.isNullOrEmpty(postTimeStr)) {
//            return "发布时间不能为空！";
//        }
//
//        long topicId;
//        try {
//            topicId = Long.parseLong(topicIDataSourcetr);
//        } catch (NumberFormatException e) {
//            return "日志主题ID必须是数字！";
//        }
//
//        // 2. 解析时间字符串
//        Date postTime;
//        // 定义与前端 flatpickr 中 dateFormat 一致的格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            postTime = sdf.parse(postTimeStr);
//        } catch (ParseException e) {
//            return "提交的日期时间格式不正确，请使用 '年-月-日 时:分:秒' 格式。";
//        }
//
//        // --- 动态获取 IP 地址 ---
//        String ipAddress = getClientIpAddr(request);
//
//        // --- 构建业务对象 ---
//        String[] lines = logContent.split("\r?\n");
//        StringBuilder contentHtml = new StringBuilder();
//        contentHtml.append("<p><strong>完成工作：</strong></p>");
//        for (String line : lines) {
//            if (!line.trim().isEmpty()) {
//                contentHtml.append("<p>").append(line.trim()).append("<br></p>");
//            }
//        }
//        contentHtml.append("<p><strong>需重点说明，协调与帮助：</strong></p><p><span>无</span></p>");
//        contentHtml.append("<p><strong>明日工作计划：</strong></p><p><span>无</span></p>");
//
//        Comment commentToInsert = new Comment();
//        commentToInsert.setContent(contentHtml.toString());
//        commentToInsert.setIp(ipAddress); // ★★★ 使用动态获取的IP
//        commentToInsert.setIsStaff(0);
//        commentToInsert.setPostTime(postTime); // ★★★ 使用从前端选择的时间
//        commentToInsert.setQuoteIdGroup(",");
//        commentToInsert.setQuoteUpdateId(",");
//        commentToInsert.setStatus(20L);
//        commentToInsert.setTopicId(topicId);
//        commentToInsert.setUserName(logPersonUsername);
//
//        System.out.println(topicId+""+logPersonUsername+""+postTime+""+contentHtml.toString()+ipAddress);
//
////        // --- 执行数据库操作 ---
//        try {
//            int result = commentMapper.insertComment(commentToInsert);
//            if (result > 0) {
//                return "日志提交成功！IP: " + ipAddress + ", 时间: " + sdf.format(postTime);
//            } else {
//                return "日志提交失败，数据库未受影响。";
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); // 打印错误到后台日志
//            return "日志提交失败，发生服务器内部错误。";
//        }
//    }


//    @GetMapping("add")
//    @ResponseBody
//    @DataSource(SLAVE) // 指定使用从数据源
//    public int addComment() {
//        return studentLogService.addComment();
//    }
}
