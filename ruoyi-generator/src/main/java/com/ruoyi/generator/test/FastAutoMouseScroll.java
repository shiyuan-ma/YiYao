package com.ruoyi.generator.test;

import java.awt.Robot;
import java.awt.AWTException;

public class FastAutoMouseScroll {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            System.out.println("程序将在5秒后开始自动快速滚动...");
            System.out.println("请尽快将鼠标移到需要滚动的窗口上。");
            robot.delay(5000);

            // 设置滚动的次数和每次滚动的延迟
            int scrollCount = 99900; // 总共滚动100次
            int delayInMillis = 200; // 每次滚动后延迟0.2秒，让页面有时间加载

            System.out.println("开始自动快速滚动...");
            for (int i = 0; i < scrollCount; i++) {
                // 增加参数值，模拟一次滚动多格
                // 这里的 5 是一个示例，你可以根据需要调整
                robot.mouseWheel(2);

                // 每次滚动后短暂延迟
                robot.delay(delayInMillis);
            }

            System.out.println("自动滚动完成。");

        } catch (AWTException e) {
            System.err.println("创建 Robot 实例失败: " + e.getMessage());
        }
    }
}