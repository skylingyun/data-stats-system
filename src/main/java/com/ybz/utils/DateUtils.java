package com.ybz.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 *
 * @author zhangybt
 * @email zhangybt@yonyou.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static Date format(String currentTime) {
        Date currentDate = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            currentDate = simpleDateFormat.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDate;
    }

    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 生成随机时间
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);//构造开始日期
            Date end = format.parse(endDate);//构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        //如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
}
