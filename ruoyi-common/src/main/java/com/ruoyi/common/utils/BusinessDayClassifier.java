package com.ruoyi.common.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

/**
 * 业务日分类处理器
 * 根据传入的时间戳与【当前业务日】窗口的位置关系，
 * 将其分类为“过去”、“当前”或“将来”，并执行相应操作。
 */
@Component
public class BusinessDayClassifier {

    // 定义业务日的切点时间 (常量)
    private static final LocalTime CUTOFF_TIME = LocalTime.of(8, 30);

    /**
     * 主处理方法：根据时间戳相对于业务日的位置进行分类和处理。
     *
     * @param checkTime 需要处理的数据时间戳。
     */
    public static void classifyAndProcessLog(LocalDateTime checkTime) {
        System.out.println("--- 开始处理时间戳: " + checkTime + " ---");

        // 步骤1: 获取当前业务日的时间窗口
        Entry<LocalDateTime, LocalDateTime> window = getBusinessDayWindow();
        LocalDateTime windowStart = window.getKey();
        LocalDateTime windowEnd = window.getValue();
        System.out.println("当前业务日窗口为: [" + windowStart + ", " + windowEnd + ")");

        // 步骤2: 根据 checkTime 与窗口的位置关系进行分类判断
        if (checkTime.isBefore(windowStart)) {
            // 分类: 过去 (Past) - 时间戳在当前业务日开始之前
            System.out.println("判断: 时间戳在业务日窗口开始之前，分类为【过去时间】。");
            processDayAgoLog(checkTime);

        } else if (checkTime.isBefore(windowEnd)) {
            // 分类: 当前 (Present) - 时间戳在业务日窗口之内
            System.out.println("判断: 时间戳在业务日窗口之内，分类为【当前时间】。");
            processDayLog(checkTime);

        } else {
            // 分类: 将来 (Future) - 时间戳在业务日窗口结束之后或恰好在结束时刻
            System.out.println("判断: 时间戳在业务日窗口结束之后，分类为【将来时间】，不执行任何操作。");
        }

        System.out.println("--- 处理结束 ---\n");
    }

    /**
     * 辅助方法：获取当前业务日的时间窗口 [开始时间, 结束时间)。
     * （此方法的逻辑保持不变，因为它正确地计算了业务日窗口）
     */
    public static Entry<LocalDateTime, LocalDateTime> getBusinessDayWindow() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        LocalDateTime windowStart;
        // 如果当前挂钟时间还没到今天的 8:30，业务日就从昨天 8:30 开始
        if (now.toLocalTime().isBefore(CUTOFF_TIME)) {
            windowStart = today.minusDays(1).atTime(CUTOFF_TIME);
        } else { // 否则，业务日从今天 8:30 开始
            windowStart = today.atTime(CUTOFF_TIME);
        }
        // 结束时间总是开始时间加一天
        LocalDateTime windowEnd = windowStart.plusDays(1);
        return new SimpleImmutableEntry<>(windowStart, windowEnd);
    }

    // ================== 具体的业务处理方法 (模拟) ==================

    /**
     * 处理【当前】业务日时间日志的方法。
     */
    private static void processDayLog(LocalDateTime logTime) {
        System.out.println("结果: 调用 processDayLog() -> 正在处理当前业务日的日志: " + logTime);
    }

    /**
     * 处理【过去】业务日时间日志的方法。
     */
    private static void processDayAgoLog(LocalDateTime logTime) {
        System.out.println("结果: 调用 processDayAgoLog() -> 正在处理过去业务日的日志: " + logTime);
    }

    // ================== 测试入口 ==================

    public static void main(String[] args) {
        System.out.println("====== 测试开始 (当前系统时间: " + LocalDateTime.now() + ") ======");

//        // 场景1: 检查时间为【当前业务日】 (例如，今天中午)
//        LocalDateTime presentTime = LocalDate.now().atTime(12, 0);
//        classifyAndProcessLog(presentTime);

        // 场景2: 检查时间为【过去时间】 (例如，昨天中午)
        LocalDateTime pastTime = LocalDateTime.now().minusDays(1);
        classifyAndProcessLog(pastTime);

//        // 场景3: 检查时间为【将来时间】 (例如，明天中午)
//        LocalDateTime futureTime = LocalDateTime.now().plusDays(1);
//        classifyAndProcessLog(futureTime);

//        // --- 边界测试 ---
//        System.out.println("====== 边界测试 ======");
//        Entry<LocalDateTime, LocalDateTime> window = getBusinessDayWindow();
//
//        // 边界1: 恰好是业务日开始时间 -> 应该属于【当前】
//        classifyAndProcessLog(window.getKey());
//
//        // 边界2: 在业务日开始前1秒 -> 应该属于【过去】
//        classifyAndProcessLog(window.getKey().minusSeconds(1));
//
//        // 边界3: 在业务日结束前1秒 -> 应该属于【当前】
//        classifyAndProcessLog(window.getValue().minusSeconds(1));
//
//        // 边界4: 恰好是业务日结束时间 -> 应该属于【将来】
//        classifyAndProcessLog(window.getValue());
    }
}
