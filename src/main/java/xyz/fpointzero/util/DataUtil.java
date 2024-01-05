package xyz.fpointzero.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtil {
    //获取当前时间
    public static String getCurrentTime() {
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化当前时间为指定格式
        String formattedDateTime = currentTime.format(formatter);
        return formattedDateTime;
    }
    //计算时间差
    public static Duration getDurationTime(String time) {
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 将时间字符串解析为 LocalDateTime 对象
        LocalDateTime sendTime = LocalDateTime.parse(time, formatter);
        // 计算两个 LocalDateTime 对象之间的时间差
        Duration duration = Duration.between(sendTime,currentTime);
        return duration;
    }
}
