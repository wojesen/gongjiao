package com.yinlian.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>The Super Java Framework .</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * @author Steven
 * @version 1.0
 */

public class DateUtil
{
    private static final int[] dayArray = new int[]
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static SimpleDateFormat sdf = new SimpleDateFormat();

    public static synchronized Calendar getCalendar()
    {
        return GregorianCalendar.getInstance();
    }

    /**
     @return String
     */
    public static synchronized String getDateMilliFormat()
    {
        Calendar cal = Calendar.getInstance();
        return getDateMilliFormat( cal );
    }

    /**
     @param cal
     @return String
     */
    public static synchronized String getDateMilliFormat( Calendar cal )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
        return getDateFormat( cal, pattern );
    }

    /**
     @param date
     @return String
     */
    public static synchronized String getDateMilliFormat( Date date )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
        return getDateFormat( date, pattern );
    }

    /**
     @param strDate
     @return java.util.Calendar
     */
    public static synchronized Calendar parseCalendarMilliFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
        return parseCalendarFormat( strDate, pattern );
    }

    /**
     @param strDate
     @return java.util.Date
     */
    public static synchronized Date parseDateMilliFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
        return parseDateFormat( strDate, pattern );
    }

    /**
     @return String
     */
    public static synchronized String getDateSecondFormat()
    {
        Calendar cal = Calendar.getInstance();
        return getDateSecondFormat( cal );
    }

    /**
     @param cal
     @return String
     */
    public static synchronized String getDateSecondFormat( Calendar cal )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return getDateFormat( cal, pattern );
    }

    /**
     @param date
     @return String
     */
    public static synchronized String getDateSecondFormat( Date date )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return getDateFormat( date, pattern );
    }

    /**
     @param strDate
     @return java.util.Calendar
     */
    public static synchronized Calendar parseCalendarSecondFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return parseCalendarFormat( strDate, pattern );
    }

    /**
     @param strDate
     @return java.util.Date
     */
    public static synchronized Date parseDateSecondFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return parseDateFormat( strDate, pattern );
    }

    /**
     @return String
     */
    public static synchronized String getDateMinuteFormat()
    {
        Calendar cal = Calendar.getInstance();
        return getDateMinuteFormat( cal );
    }

    /**
     @param cal
     @return String
     */
    public static synchronized String getDateMinuteFormat( Calendar cal )
    {
        String pattern = "yyyy-MM-dd HH:mm";
        return getDateFormat( cal, pattern );
    }

    /**
     @param date
     @return String
     */
    public static synchronized String getDateMinuteFormat( Date date )
    {
        String pattern = "yyyy-MM-dd HH:mm";
        return getDateFormat( date, pattern );
    }

    /**
     @param strDate
     @return java.util.Calendar
     */
    public static synchronized Calendar parseCalendarMinuteFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm";
        return parseCalendarFormat( strDate, pattern );
    }

    /**
     @param strDate
     @return java.util.Date
     */
    public static synchronized Date parseDateMinuteFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm";
        return parseDateFormat( strDate, pattern );
    }
    /**
     @param patten
     @return java.lang.String
     */
    public static String getDate(String patten) {
        SimpleDateFormat sf = new SimpleDateFormat(patten, Locale.US);
        return sf.format(new Date());
    }
    /**
     @return String
     */
    public static synchronized String getDateDayFormat()
    {
        Calendar cal = Calendar.getInstance();
        return getDateDayFormat( cal );
    }

    /**
     @param cal
     @return String
     */
    public static synchronized String getDateDayFormat( Calendar cal )
    {
        String pattern = "yyyy-MM-dd";
        return getDateFormat( cal, pattern );
    }

    /**
     @param date
     @return String
     */
    public static synchronized String getDateDayFormat( Date date )
    {
        String pattern = "yyyy-MM-dd";
        return getDateFormat( date, pattern );
    }

    /**
     @param strDate
     @return java.util.Calendar
     */
    public static synchronized Calendar parseCalendarDayFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd";
        return parseCalendarFormat( strDate, pattern );
    }

    /**
     @param strDate
     @return java.util.Date
     */
    public static synchronized Date parseDateDayFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd";
        return parseDateFormat( strDate, pattern );
    }

    /**
     @return String
     */
    public static synchronized String getDateFileFormat()
    {
        Calendar cal = Calendar.getInstance();
        return getDateFileFormat( cal );
    }

    /**
     @param cal
     @return String
     */
    public static synchronized String getDateFileFormat( Calendar cal )
    {
        String pattern = "yyyy-MM-dd_HH-mm-ss";
        return getDateFormat( cal, pattern );
    }

    /**
     @param date
     @return String
     */
    public static synchronized String getDateFileFormat( Date date )
    {
        String pattern = "yyyy-MM-dd_HH-mm-ss";
        return getDateFormat( date, pattern );
    }

    /**
     @param strDate
     @return java.util.Calendar
     */
    public static synchronized Calendar parseCalendarFileFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd_HH-mm-ss";
        return parseCalendarFormat( strDate, pattern );
    }

    /**
     @param strDate
     @return java.util.Date
     */
    public static synchronized Date parseDateFileFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd_HH-mm-ss";
        return parseDateFormat( strDate, pattern );
    }

    /**
     @return String
     */
    public static synchronized String getDateW3CFormat()
    {
        Calendar cal = Calendar.getInstance();
        return getDateW3CFormat( cal );
    }

    /**
     @param cal
     @return String
     */
    public static synchronized String getDateW3CFormat( Calendar cal )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return getDateFormat( cal, pattern );
    }

    /**
     @param date
     @return String
     */
    public static synchronized String getDateW3CFormat( Date date )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return getDateFormat( date, pattern );
    }

    /**
     @param strDate
     @return java.util.Calendar
     */
    public static synchronized Calendar parseCalendarW3CFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return parseCalendarFormat( strDate, pattern );
    }

    /**
     @param strDate
     @return java.util.Date
     */
    public static synchronized Date parseDateW3CFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return parseDateFormat( strDate, pattern );
    }

    /**
     @param cal
     @return String
     */
    public static synchronized String getDateFormat( Calendar cal )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return getDateFormat( cal, pattern );
    }

    /**
     @param date
     @return String
     */
    public static synchronized String getDateFormat( Date date )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return getDateFormat( date, pattern );
    }

    /**
     @param strDate
     @return java.util.Calendar
     */
    public static synchronized Calendar parseCalendarFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return parseCalendarFormat( strDate, pattern );
    }

    /**
     @param strDate
     @return java.util.Date
     */
    public static synchronized Date parseDateFormat( String strDate )
    {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return parseDateFormat( strDate, pattern );
    }

    /**
     @param cal
     @param pattern
     @return String
     */
    public static synchronized String getDateFormat( Calendar cal, String pattern )
    {
        return getDateFormat( cal.getTime(), pattern );
    }

    /**
     @param date
     @param pattern
     @return String
     */
    public static synchronized String getDateFormat( Date date, String pattern )
    {
        synchronized ( sdf )
        {
            String str = null;
            sdf.applyPattern( pattern );
            str = sdf.format( date );
            return str;
        }
    }

    /**
     @param strDate
     @param pattern
     @return java.util.Calendar
     */
    public static synchronized Calendar parseCalendarFormat( String strDate, String pattern )
    {
        synchronized ( sdf )
        {
            Calendar cal = null;
            sdf.applyPattern( pattern );
            try
            {
                sdf.parse( strDate );
                cal = sdf.getCalendar();
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
            return cal;
        }
    }

    /**
     @param strDate
     @param pattern
     @return java.util.Date
     */
    public static synchronized Date parseDateFormat( String strDate, String pattern )
    {
        synchronized ( sdf )
        {
            Date date = null;
            sdf.applyPattern( pattern );
            try
            {
                date = sdf.parse( strDate );
            }
            catch ( Exception e )
            {
            }
            return date;
        }
    }

    public static synchronized int getLastDayOfMonth( int month )
    {
        if ( month < 1 || month > 12 )
        {
            return -1;
        }
        int retn = 0;
        if ( month == 2 )
        {
            if ( isLeapYear() )
            {
                retn = 29;
            }
            else
            {
                retn = dayArray[month - 1];
            }
        }
        else
        {
            retn = dayArray[month - 1];
        }
        return retn;
    }

    public static synchronized int getLastDayOfMonth( int year, int month )
    {
        if ( month < 1 || month > 12 )
        {
            return -1;
        }
        int retn = 0;
        if ( month == 2 )
        {
            if ( isLeapYear( year ) )
            {
                retn = 29;
            }
            else
            {
                retn = dayArray[month - 1];
            }
        }
        else
        {
            retn = dayArray[month - 1];
        }
        return retn;
    }

    public static synchronized boolean isLeapYear()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get( Calendar.YEAR );
        return isLeapYear( year );
    }

    public static synchronized boolean isLeapYear( int year )
    {
        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
        if ( ( year % 400 ) == 0 )
            return true;
        else if ( ( year % 4 ) == 0 )
        {
            if ( ( year % 100 ) == 0 )
                return false;
            else return true;
        }
        else return false;
    }

    /**
     * 判断指定日期的年份是否是闰年
     *
     * @param date
     *            指定日期。
     * @return 是否闰年
     */
    public static synchronized boolean isLeapYear( Date date )
    {
        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
//  int year = date.getYear();
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        int year = gc.get( Calendar.YEAR );
        return isLeapYear( year );
    }

    public static synchronized boolean isLeapYear( Calendar gc )
    {
        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
        int year = gc.get( Calendar.YEAR );
        return isLeapYear( year );
    }

    /**
     * 得到指定日期的前一个工作日
     *
     * @param date
     *            指定日期。
     * @return 指定日期的前一个工作日
     */
    public static synchronized Date getPreviousWeekDay(
            Date date )
    {
        {
            /**
             * 详细设计：
             * 1.如果date是星期日，则减3天
             * 2.如果date是星期六，则减2天
             * 3.否则减1天
             */
            GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
            gc.setTime( date );
            return getPreviousWeekDay( gc );
//   switch ( gc.get( Calendar.DAY_OF_WEEK ) )
//   {
//    case ( Calendar.MONDAY    ):
//     gc.add( Calendar.DATE, -3 );
//     break;
//    case ( Calendar.SUNDAY    ):
//     gc.add( Calendar.DATE, -2 );
//     break;
//    default:
//     gc.add( Calendar.DATE, -1 );
//     break;
//   }
//   return gc.getTime();
        }
    }

    public static synchronized Date getPreviousWeekDay(
            Calendar gc )
    {
        {
            /**
             * 详细设计：
             * 1.如果date是星期日，则减3天
             * 2.如果date是星期六，则减2天
             * 3.否则减1天
             */
            switch ( gc.get( Calendar.DAY_OF_WEEK ) )
            {
                case ( Calendar.MONDAY    ):
                    gc.add( Calendar.DATE, -3 );
                    break;
                case ( Calendar.SUNDAY    ):
                    gc.add( Calendar.DATE, -2 );
                    break;
                default:
                    gc.add( Calendar.DATE, -1 );
                    break;
            }
            return gc.getTime();
        }
    }

    /**
     * 得到指定日期的后一个工作日
     *
     * @param date
     *            指定日期。
     * @return 指定日期的后一个工作日
     */
    public static synchronized Date getNextWeekDay(
            Date date )
    {
        /**
         * 详细设计：
         * 1.如果date是星期五，则加3天
         * 2.如果date是星期六，则加2天
         * 3.否则加1天
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        switch ( gc.get( Calendar.DAY_OF_WEEK ) )
        {
            case ( Calendar.FRIDAY    ):
                gc.add( Calendar.DATE, 3 );
                break;
            case ( Calendar.SATURDAY    ):
                gc.add( Calendar.DATE, 2 );
                break;
            default:
                gc.add( Calendar.DATE, 1 );
                break;
        }
        return gc.getTime();
    }

    public static synchronized Calendar getNextWeekDay(
            Calendar gc )
    {
        /**
         * 详细设计：
         * 1.如果date是星期五，则加3天
         * 2.如果date是星期六，则加2天
         * 3.否则加1天
         */
        switch ( gc.get( Calendar.DAY_OF_WEEK ) )
        {
            case ( Calendar.FRIDAY    ):
                gc.add( Calendar.DATE, 3 );
                break;
            case ( Calendar.SATURDAY    ):
                gc.add( Calendar.DATE, 2 );
                break;
            default:
                gc.add( Calendar.DATE, 1 );
                break;
        }
        return gc;
    }

    /**
     * 取得指定日期的下一个月的最后一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的下一个月的最后一天
     */
    public static synchronized Date getLastDayOfNextMonth(
            Date date )
    {
        /**
         * 详细设计：
         * 1.调用getNextMonth设置当前时间
         * 2.以1为基础，调用getLastDayOfMonth
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.setTime( DateUtil.getNextMonth( gc.getTime() ) );
        gc.setTime( DateUtil.getLastDayOfMonth( gc.getTime() ) );
        return gc.getTime();
    }

    /**
     * 取得指定日期的下一个星期的最后一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的下一个星期的最后一天
     */
    public static synchronized Date getLastDayOfNextWeek(
            Date date )
    {
        /**
         * 详细设计：
         * 1.调用getNextWeek设置当前时间
         * 2.以1为基础，调用getLastDayOfWeek
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.setTime( DateUtil.getNextWeek( gc.getTime() ) );
        gc.setTime( DateUtil.getLastDayOfWeek( gc.getTime() ) );
        return gc.getTime();
    }

    /**
     * 取得指定日期的下一个月的第一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的下一个月的第一天
     */
    public static synchronized Date getFirstDayOfNextMonth(
            Date date )
    {
        /**
         * 详细设计：
         * 1.调用getNextMonth设置当前时间
         * 2.以1为基础，调用getFirstDayOfMonth
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.setTime( DateUtil.getNextMonth( gc.getTime() ) );
        gc.setTime( DateUtil.getFirstDayOfMonth( gc.getTime() ) );
        return gc.getTime();
    }

    public static synchronized Calendar getFirstDayOfNextMonth(
            Calendar gc )
    {
        /**
         * 详细设计：
         * 1.调用getNextMonth设置当前时间
         * 2.以1为基础，调用getFirstDayOfMonth
         */
        gc.setTime( DateUtil.getNextMonth( gc.getTime() ) );
        gc.setTime( DateUtil.getFirstDayOfMonth( gc.getTime() ) );
        return gc;
    }

    /**
     * 取得指定日期的下一个星期的第一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的下一个星期的第一天
     */
    public static synchronized Date getFirstDayOfNextWeek(
            Date date )
    {
        /**
         * 详细设计：
         * 1.调用getNextWeek设置当前时间
         * 2.以1为基础，调用getFirstDayOfWeek
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.setTime( DateUtil.getNextWeek( gc.getTime() ) );
        gc.setTime( DateUtil.getFirstDayOfWeek( gc.getTime() ) );
        return gc.getTime();
    }

    public static synchronized Calendar getFirstDayOfNextWeek(
            Calendar gc )
    {
        /**
         * 详细设计：
         * 1.调用getNextWeek设置当前时间
         * 2.以1为基础，调用getFirstDayOfWeek
         */
        gc.setTime( DateUtil.getNextWeek( gc.getTime() ) );
        gc.setTime( DateUtil.getFirstDayOfWeek( gc.getTime() ) );
        return gc;
    }

    /**
     * 取得指定日期的下一个月
     *
     * @param date
     *            指定日期。
     * @return 指定日期的下一个月
     */
    public static synchronized Date getNextMonth( Date date )
    {
        /**
         * 详细设计：
         * 1.指定日期的月份加1
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.add( Calendar.MONTH, 1 );
        return gc.getTime();
    }

    public static synchronized Calendar getNextMonth( Calendar gc )
    {
        /**
         * 详细设计：
         * 1.指定日期的月份加1
         */
        gc.add( Calendar.MONTH, 1 );
        return gc;
    }

    /**
     * 取得指定日期的下n个月
     *
     * @param date
     *            指定日期。
     * @return 指定日期的下n个月
     */
    public static synchronized Date getNextSomeMonth( Date date, int n )
    {
        /**
         * 详细设计：
         * 1.指定日期的月份加1
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.add( Calendar.MONTH, n );
        return gc.getTime();
    }

    /**
     * 取得指定日期的下一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的下一天
     */
    public static synchronized Date getNextDay( Date date )
    {
        /**
         * 详细设计： 1.指定日期加1天
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.add( Calendar.DATE, 1 );
        return gc.getTime();
    }

    public static synchronized Calendar getNextDay( Calendar gc )
    {
        /**
         * 详细设计： 1.指定日期加1天
         */
        gc.add( Calendar.DATE, 1 );
        return gc;
    }

    /**
     * 取得指定日期的下一个星期
     *
     * @param date
     *            指定日期。
     * @return 指定日期的下一个星期
     */
    public static synchronized Date getNextWeek( Date date )
    {
        /**
         * 详细设计：
         * 1.指定日期加7天
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.add( Calendar.DATE, 7 );
        return gc.getTime();
    }

    public static synchronized Calendar getNextWeek( Calendar gc )
    {
        /**
         * 详细设计：
         * 1.指定日期加7天
         */
        gc.add( Calendar.DATE, 7 );
        return gc;
    }

    /**
     * 取得指定日期的所处星期的最后一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的所处星期的最后一天
     */
    public static synchronized Date getLastDayOfWeek(
            Date date )
    {
        /**
         * 详细设计：
         * 1.如果date是星期日，则加6天
         * 2.如果date是星期一，则加5天
         * 3.如果date是星期二，则加4天
         * 4.如果date是星期三，则加3天
         * 5.如果date是星期四，则加2天
         * 6.如果date是星期五，则加1天
         * 7.如果date是星期六，则加0天
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        switch ( gc.get( Calendar.DAY_OF_WEEK ) )
        {
            case ( Calendar.SUNDAY  ):
                gc.add( Calendar.DATE, 6 );
                break;
            case ( Calendar.MONDAY  ):
                gc.add( Calendar.DATE, 5 );
                break;
            case ( Calendar.TUESDAY  ):
                gc.add( Calendar.DATE, 4 );
                break;
            case ( Calendar.WEDNESDAY  ):
                gc.add( Calendar.DATE, 3 );
                break;
            case ( Calendar.THURSDAY  ):
                gc.add( Calendar.DATE, 2 );
                break;
            case ( Calendar.FRIDAY  ):
                gc.add( Calendar.DATE, 1 );
                break;
            case ( Calendar.SATURDAY  ):
                gc.add( Calendar.DATE, 0 );
                break;
        }
        return gc.getTime();
    }

    /**
     * 取得指定日期的所处星期的第一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的所处星期的第一天
     */
    public static synchronized Date getFirstDayOfWeek(
            Date date )
    {
        /**
         * 详细设计：
         * 1.如果date是星期日，则减0天
         * 2.如果date是星期一，则减1天
         * 3.如果date是星期二，则减2天
         * 4.如果date是星期三，则减3天
         * 5.如果date是星期四，则减4天
         * 6.如果date是星期五，则减5天
         * 7.如果date是星期六，则减6天
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        switch ( gc.get( Calendar.DAY_OF_WEEK ) )
        {
            case ( Calendar.SUNDAY  ):
                gc.add( Calendar.DATE, 0 );
                break;
            case ( Calendar.MONDAY  ):
                gc.add( Calendar.DATE, -1 );
                break;
            case ( Calendar.TUESDAY  ):
                gc.add( Calendar.DATE, -2 );
                break;
            case ( Calendar.WEDNESDAY  ):
                gc.add( Calendar.DATE, -3 );
                break;
            case ( Calendar.THURSDAY  ):
                gc.add( Calendar.DATE, -4 );
                break;
            case ( Calendar.FRIDAY  ):
                gc.add( Calendar.DATE, -5 );
                break;
            case ( Calendar.SATURDAY  ):
                gc.add( Calendar.DATE, -6 );
                break;
        }
        return gc.getTime();
    }

    public static synchronized Calendar getFirstDayOfWeek(
            Calendar gc )
    {
        /**
         * 详细设计：
         * 1.如果date是星期日，则减0天
         * 2.如果date是星期一，则减1天
         * 3.如果date是星期二，则减2天
         * 4.如果date是星期三，则减3天
         * 5.如果date是星期四，则减4天
         * 6.如果date是星期五，则减5天
         * 7.如果date是星期六，则减6天
         */
        switch ( gc.get( Calendar.DAY_OF_WEEK ) )
        {
            case ( Calendar.SUNDAY  ):
                gc.add( Calendar.DATE, 0 );
                break;
            case ( Calendar.MONDAY  ):
                gc.add( Calendar.DATE, -1 );
                break;
            case ( Calendar.TUESDAY  ):
                gc.add( Calendar.DATE, -2 );
                break;
            case ( Calendar.WEDNESDAY  ):
                gc.add( Calendar.DATE, -3 );
                break;
            case ( Calendar.THURSDAY  ):
                gc.add( Calendar.DATE, -4 );
                break;
            case ( Calendar.FRIDAY  ):
                gc.add( Calendar.DATE, -5 );
                break;
            case ( Calendar.SATURDAY  ):
                gc.add( Calendar.DATE, -6 );
                break;
        }
        return gc;
    }

    /**
     * 取得指定日期的所处月份的最后一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的所处月份的最后一天
     */
    public static synchronized Date getLastDayOfMonth(
            Date date )
    {
        /**
         * 详细设计：
         * 1.如果date在1月，则为31日
         * 2.如果date在2月，则为28日
         * 3.如果date在3月，则为31日
         * 4.如果date在4月，则为30日
         * 5.如果date在5月，则为31日
         * 6.如果date在6月，则为30日
         * 7.如果date在7月，则为31日
         * 8.如果date在8月，则为31日
         * 9.如果date在9月，则为30日
         * 10.如果date在10月，则为31日
         * 11.如果date在11月，则为30日
         * 12.如果date在12月，则为31日
         * 1.如果date在闰年的2月，则为29日
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        switch ( gc.get( Calendar.MONTH ) )
        {
            case 0:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 1:
                gc.set( Calendar.DAY_OF_MONTH, 28 );
                break;
            case 2:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 3:
                gc.set( Calendar.DAY_OF_MONTH, 30 );
                break;
            case 4:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 5:
                gc.set( Calendar.DAY_OF_MONTH, 30 );
                break;
            case 6:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 7:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 8:
                gc.set( Calendar.DAY_OF_MONTH, 30 );
                break;
            case 9:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 10:
                gc.set( Calendar.DAY_OF_MONTH, 30 );
                break;
            case 11:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
        }
        //检查闰年
        if ( ( gc.get( Calendar.MONTH ) == Calendar.FEBRUARY )
                && ( isLeapYear( gc.get( Calendar.YEAR ) ) ) )
        {
            gc.set( Calendar.DAY_OF_MONTH, 29 );
        }
        return gc.getTime();
    }

    public static synchronized Calendar getLastDayOfMonth(
            Calendar gc )
    {
        /**
         * 详细设计：
         * 1.如果date在1月，则为31日
         * 2.如果date在2月，则为28日
         * 3.如果date在3月，则为31日
         * 4.如果date在4月，则为30日
         * 5.如果date在5月，则为31日
         * 6.如果date在6月，则为30日
         * 7.如果date在7月，则为31日
         * 8.如果date在8月，则为31日
         * 9.如果date在9月，则为30日
         * 10.如果date在10月，则为31日
         * 11.如果date在11月，则为30日
         * 12.如果date在12月，则为31日
         * 1.如果date在闰年的2月，则为29日
         */
        switch ( gc.get( Calendar.MONTH ) )
        {
            case 0:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 1:
                gc.set( Calendar.DAY_OF_MONTH, 28 );
                break;
            case 2:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 3:
                gc.set( Calendar.DAY_OF_MONTH, 30 );
                break;
            case 4:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 5:
                gc.set( Calendar.DAY_OF_MONTH, 30 );
                break;
            case 6:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 7:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 8:
                gc.set( Calendar.DAY_OF_MONTH, 30 );
                break;
            case 9:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
            case 10:
                gc.set( Calendar.DAY_OF_MONTH, 30 );
                break;
            case 11:
                gc.set( Calendar.DAY_OF_MONTH, 31 );
                break;
        }
        //检查闰年
        if ( ( gc.get( Calendar.MONTH ) == Calendar.FEBRUARY )
                && ( isLeapYear( gc.get( Calendar.YEAR ) ) ) )
        {
            gc.set( Calendar.DAY_OF_MONTH, 29 );
        }
        return gc;
    }

    /**
     * 取得指定日期的所处月份的第一天
     *
     * @param date
     *            指定日期。
     * @return 指定日期的所处月份的第一天
     */
    public static synchronized Date getFirstDayOfMonth( Date date )
    {
        /**
         * 详细设计： 1.设置为1号
         */
        GregorianCalendar gc = ( GregorianCalendar ) Calendar.getInstance();
        gc.setTime( date );
        gc.set( Calendar.DAY_OF_MONTH, 1 );
        return gc.getTime();
    }

    public static synchronized Calendar getFirstDayOfMonth( Calendar gc )
    {
        /**
         * 详细设计： 1.设置为1号
         */
        gc.set( Calendar.DAY_OF_MONTH, 1 );
        return gc;
    }

    /**
     * 将日期对象转换成为指定ORA日期、时间格式的字符串形式。如果日期对象为空，返回 一个空字符串对象，而不是一个空对象。
     *
     * @param theDate
     *            将要转换为字符串的日期对象。
     * @param hasTime
     *            如果返回的字符串带时间则为true
     * @return 转换的结果
     */
    public static synchronized String toOraString( Date theDate, boolean hasTime )
    {
        /**
         * 详细设计：
         * 1.如果有时间，则设置格式为getOraDateTimeFormat()的返回值
         * 2.否则设置格式为getOraDateFormat()的返回值
         * 3.调用toString(Date theDate, DateFormat
         * theDateFormat)
         */
        DateFormat theFormat;
        if ( hasTime )
        {
            theFormat = getOraDateTimeFormat();
        }
        else
        {
            theFormat = getOraDateFormat();
        }
        return toString( theDate, theFormat );
    }

    /**
     * 将日期对象转换成为指定日期、时间格式的字符串形式。如果日期对象为空，返回 一个空字符串对象，而不是一个空对象。
     *
     * @param theDate
     *            将要转换为字符串的日期对象。
     * @param hasTime
     *            如果返回的字符串带时间则为true
     * @return 转换的结果
     */
    public static synchronized String toString( Date theDate, boolean hasTime )
    {
        /**
         * 详细设计：
         * 1.如果有时间，则设置格式为getDateTimeFormat的返回值
         * 2.否则设置格式为getDateFormat的返回值
         * 3.调用toString(Date theDate, DateFormat theDateFormat)
         */
        DateFormat theFormat;
        if ( hasTime )
        {
            theFormat = getDateTimeFormat();
        }
        else
        {
            theFormat = getDateFormat();
        }
        return toString( theDate, theFormat );
    }

    /**
     * 标准日期格式
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            "MM/dd/yyyy" );
    /**
     * 标准时间格式
     */
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm" );
    /**
     * 带时分秒的标准时间格式
     */
    private static final SimpleDateFormat DATE_TIME_EXTENDED_FORMAT = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm:ss" );
    /**
     * ORA标准日期格式
     */
    private static final SimpleDateFormat ORA_DATE_FORMAT = new SimpleDateFormat(
            "yyyyMMdd" );
    /**
     * ORA标准时间格式
     */
    private static final SimpleDateFormat ORA_DATE_TIME_FORMAT = new SimpleDateFormat(
            "yyyyMMddHHmm" );
    /**
     * 带时分秒的ORA标准时间格式
     */
    private static final SimpleDateFormat ORA_DATE_TIME_EXTENDED_FORMAT = new SimpleDateFormat(
            "yyyyMMddHHmmss" );

    /**
     * 创建一个标准日期格式的克隆
     *
     * @return 标准日期格式的克隆
     */
    public static synchronized DateFormat getDateFormat()
    {
        /**
         * 详细设计： 1.返回DATE_FORMAT
         */
        SimpleDateFormat theDateFormat = ( SimpleDateFormat )
                DATE_FORMAT.clone();
        theDateFormat.setLenient( false );
        return theDateFormat;
    }

    /**
     * 创建一个标准时间格式的克隆
     *
     * @return 标准时间格式的克隆
     */
    public static synchronized DateFormat getDateTimeFormat()
    {
        /**
         * 详细设计： 1.返回DATE_TIME_FORMAT
         */
        SimpleDateFormat theDateTimeFormat = ( SimpleDateFormat ) DATE_TIME_FORMAT
                .clone();
        theDateTimeFormat.setLenient( false );
        return theDateTimeFormat;
    }

    /**
     * 创建一个标准ORA日期格式的克隆
     *
     * @return 标准ORA日期格式的克隆
     */
    public static synchronized DateFormat getOraDateFormat()
    {
        /**
         * 详细设计： 1.返回ORA_DATE_FORMAT
         */
        SimpleDateFormat theDateFormat = ( SimpleDateFormat ) ORA_DATE_FORMAT
                .clone();
        theDateFormat.setLenient( false );
        return theDateFormat;
    }

    /**
     * 创建一个标准ORA时间格式的克隆
     *
     * @return 标准ORA时间格式的克隆
     */
    public static synchronized DateFormat getOraDateTimeFormat()
    {
        /**
         * 详细设计： 1.返回ORA_DATE_TIME_FORMAT
         */
        SimpleDateFormat theDateTimeFormat = ( SimpleDateFormat )
                ORA_DATE_TIME_FORMAT.clone();
        theDateTimeFormat.setLenient( false );
        return theDateTimeFormat;
    }

    /**
     * 将一个日期对象转换成为指定日期、时间格式的字符串。 如果日期对象为空，返回一个空字符串，而不是一个空对象。
     *
     * @param theDate
     *            要转换的日期对象
     * @param theDateFormat
     *            返回的日期字符串的格式
     * @return 转换结果
     */
    public static synchronized String toString( Date theDate,
                                                DateFormat theDateFormat )
    {
        /**
         * 详细设计：
         * 1.theDate为空，则返回""
         * 2.否则使用theDateFormat格式化
         */
        if ( theDate == null )
            return "";
        return theDateFormat.format( theDate );
    }

    public static String getTomorrowDate(String todayDate, int n) {
        String pattern = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(todayDate);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.add(Calendar.DAY_OF_MONTH, n);
            SimpleDateFormat fa = new SimpleDateFormat("yyyy-MM-dd");
            return fa.format(ca.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param todayDate
     * @param n
     * @param pattern
     * @return
     */
    public static String getTomorrowDate(String todayDate, int n ,String  pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(todayDate);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.add(Calendar.DAY_OF_MONTH, n);
            SimpleDateFormat fa = new SimpleDateFormat(pattern);
            return fa.format(ca.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getCurrentDate() {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat fa = new SimpleDateFormat("yyyy-MM-dd");
        return fa.format(currentDate.getTime());
    }

    /**
     * 获取当前时间字符串，格式为HHmmss
     * @return String
     */
    public static String getCurrentTime() {
        return new SimpleDateFormat("HHmmss").format(new Date());
    }

    /**
     * 获得long类型的时间
     * @param dateStr
     * @param patten
     * @return
     */
    public static long getDateTime(String dateStr, String patten){
        try {
            if (dateStr == null)
                return 0l;
            SimpleDateFormat sf = new SimpleDateFormat(patten);
            return sf.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0l;
    }



    /**
     * 比较给定的时间是否在当前时间之前
     * @param dateTime
     * @param pattern （"yyyy-MM-dd hh:MM:ss"）
     * @return boolean
     */
    public static boolean isBeforCurrentTime(String dateTime ,String pattern ){
        try {
            Calendar currentTime =Calendar.getInstance();
            Calendar beforTime =Calendar.getInstance();
            DateFormat df=new SimpleDateFormat(pattern);
            beforTime.setTime(df.parse(dateTime));
            beforTime.add(Calendar.DAY_OF_MONTH, 1);
            if(currentTime.after(beforTime))
                return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Date addDayOrTime(Date datetime, int addNum,int filed) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(datetime);
//		ca.add(field, addNum);
//		ca.set(Calendar.DATE,1);//设为当前月的1号
        ca.add(filed,addNum);//减一天，变为上月最后一天

        return ca.getTime();
    }

    public static String getDateStr(String dateStr,String old_pattern ,String new_pattern){
        String sDate="";
        try {
            sDate=getDate(getDate(dateStr, old_pattern), new_pattern);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  sDate;
    }

    public static String getDate(Date date, String patten) {
        SimpleDateFormat sf = new SimpleDateFormat(patten);
        return sf.format(date);
    }

    public static Date getDate(String dateStr , String pattern , Locale local){

        DateFormat df1 = new SimpleDateFormat(pattern,local);
        try {
            return df1.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDate(String dateStr, String patten)
            throws ParseException {
        if (dateStr == null)
            return null;
        SimpleDateFormat sf = new SimpleDateFormat(patten);
        return sf.parse(dateStr);
    }

    public static void main(String[] args){
        //Date d=addDayOrTime(new Date(),20,Calendar.DATE);
        //.out.println(getDateFormat(d,"yyyy年MM月"));
//		String date = "20111111 09:30:00";
//		String old = "yyyyMMdd HH:mm:ss";
//		String new_pattern = "yyyy-MM-dd HH:mm:ss";
//		String a = getDateStr(date,old,new_pattern);
//		System.out.println(a);

        String x = 	getTomorrowDate(getDate("MMdd"), 1,"MMdd");
        System.out.println(x);
    }

    public static String makeRandomStr()
    {
        // author : herrapfel
        String radStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer generateRandStr = new StringBuffer();
        Random rand = new Random();
        int length = 32;
        for(int i=0;i<length;i++)
        {
            int randNum = rand.nextInt(36);
            generateRandStr.append(radStr.substring(randNum,randNum+1));
        }
        return generateRandStr+"";
    }

    //返回毫秒数
    public static long fromDateStringToLong(String inVal) { //此方法计算时间毫秒
        Date date = null;   //定义时间类型
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyMMddhhmmss");
        try {
            date = inputFormat.parse(inVal); //将字符型转换成日期型
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();   //返回毫秒数
    }

    //比较时间
    public static int compareDateTime(String dateTime1,String dateTime2 ,String pattern ){
        DateFormat df=new SimpleDateFormat(pattern);
        Calendar c1= Calendar.getInstance();
        Calendar c2= Calendar.getInstance();
        try{
            c1.setTime(df.parse(dateTime1));
            c2.setTime(df.parse(dateTime2));
        }catch(ParseException e){
            System.err.println("格式不正确");
        }
        return c1.compareTo(c2);
    }
}


