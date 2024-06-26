package com.itoys.android.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * @Author Gu Fanfan
 * @Email fanfan.work@outlook.com
 * @Date 2023/12/26
 * @Desc
 * <p>在工具类中经常使用到工具类的格式化描述，这个主要是一个日期的操作类，所以日志格式主要使用 SimpleDateFormat的定义格式.</p>
 * 格式的意义如下： 日期和时间模式 <br>
 * <p>日期和时间格式由日期和时间模式字符串指定。在日期和时间模式字符串中，未加引号的字母 'A' 到 'Z' 和 'a' 到 'z'
 * 被解释为模式字母，用来表示日期或时间字符串元素。文本可以使用单引号 (') 引起来，以免进行解释。"''"
 * 表示单引号。所有其他字符均不解释；只是在格式化时将它们简单复制到输出字符串，或者在分析时与输入字符串进行匹配。
 * </p>
 * 定义了以下模式字母（所有其他字符 'A' 到 'Z' 和 'a' 到 'z' 都被保留）： <br>
 * <table border="1" cellspacing="1" cellpadding="1" summary="Chart shows pattern letters, date/time component,
 * presentation, and examples.">
 * <tr>
 * <th align="left">字母</th>
 * <th align="left">日期或时间元素</th>
 * <th align="left">表示</th>
 * <th align="left">示例</th>
 * </tr>
 * <tr>
 * <td><code>G</code></td>
 * <td>Era 标志符</td>
 * <td>Text</td>
 * <td><code>AD</code></td>
 * </tr>
 * <tr>
 * <td><code>y</code> </td>
 * <td>年 </td>
 * <td>Year </td>
 * <td><code>1996</code>; <code>96</code> </td>
 * </tr>
 * <tr>
 * <td><code>M</code> </td>
 * <td>年中的月份 </td>
 * <td>Month </td>
 * <td><code>July</code>; <code>Jul</code>; <code>07</code> </td>
 * </tr>
 * <tr>
 * <td><code>w</code> </td>
 * <td>年中的周数 </td>
 * <td>Number </td>
 * <td><code>27</code> </td>
 * </tr>
 * <tr>
 * <td><code>W</code> </td>
 * <td>月份中的周数 </td>
 * <td>Number </td>
 * <td><code>2</code> </td>
 * </tr>
 * <tr>
 * <td><code>D</code> </td>
 * <td>年中的天数 </td>
 * <td>Number </td>
 * <td><code>189</code> </td>
 * </tr>
 * <tr>
 * <td><code>d</code> </td>
 * <td>月份中的天数 </td>
 * <td>Number </td>
 * <td><code>10</code> </td>
 * </tr>
 * <tr>
 * <td><code>F</code> </td>
 * <td>月份中的星期 </td>
 * <td>Number </td>
 * <td><code>2</code> </td>
 * </tr>
 * <tr>
 * <td><code>E</code> </td>
 * <td>星期中的天数 </td>
 * <td>Text </td>
 * <td><code>Tuesday</code>; <code>Tue</code> </td>
 * </tr>
 * <tr>
 * <td><code>a</code> </td>
 * <td>Am/pm 标记 </td>
 * <td>Text </td>
 * <td><code>PM</code> </td>
 * </tr>
 * <tr>
 * <td><code>H</code> </td>
 * <td>一天中的小时数（0-23） </td>
 * <td>Number </td>
 * <td><code>0</code> </td>
 * </tr>
 * <tr>
 * <td><code>k</code> </td>
 * <td>一天中的小时数（1-24） </td>
 * <td>Number </td>
 * <td><code>24</code> </td>
 * </tr>
 * <tr>
 * <td><code>K</code> </td>
 * <td>am/pm 中的小时数（0-11） </td>
 * <td>Number </td>
 * <td><code>0</code> </td>
 * </tr>
 * <tr>
 * <td><code>h</code> </td>
 * <td>am/pm 中的小时数（1-12） </td>
 * <td>Number </td>
 * <td><code>12</code> </td>
 * </tr>
 * <tr>
 * <td><code>m</code> </td>
 * <td>小时中的分钟数 </td>
 * <td>Number </td>
 * <td><code>30</code> </td>
 * </tr>
 * <tr>
 * <td><code>s</code> </td>
 * <td>分钟中的秒数 </td>
 * <td>Number </td>
 * <td><code>55</code> </td>
 * </tr>
 * <tr>
 * <td><code>S</code> </td>
 * <td>毫秒数 </td>
 * <td>Number </td>
 * <td><code>978</code> </td>
 * </tr>
 * <tr>
 * <td><code>z</code> </td>
 * <td>时区 </td>
 * <td>General time zone </td>
 * <td><code>Pacific Standard Time</code>; <code>PST</code>; <code>GMT-08:00</code> </td>
 * </tr>
 * <tr>
 * <td><code>Z</code> </td>
 * <td>时区 </td>
 * <td>RFC 822 time zone </td>
 * <td><code>-0800</code> </td>
 * </tr>
 * </table>
 * <pre>
 *                          HH:mm    15:44
 *                         h:mm a    3:44 下午
 *                        HH:mm z    15:44 CST
 *                        HH:mm Z    15:44 +0800
 *                     HH:mm zzzz    15:44 中国标准时间
 *                       HH:mm:ss    15:44:40
 *                     yyyy-MM-dd    2016-08-12
 *               yyyy-MM-dd HH:mm    2016-08-12 15:44
 *            yyyy-MM-dd HH:mm:ss    2016-08-12 15:44:40
 *       yyyy-MM-dd HH:mm:ss zzzz    2016-08-12 15:44:40 中国标准时间
 *  EEEE yyyy-MM-dd HH:mm:ss zzzz    星期五 2016-08-12 15:44:40 中国标准时间
 *       yyyy-MM-dd HH:mm:ss.SSSZ    2016-08-12 15:44:40.461+0800
 *     yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
 *   yyyy.MM.dd G 'at' HH:mm:ss z    2016.08.12 公元 at 15:44:40 CST
 *                         K:mm a    3:44 下午
 *               EEE, MMM d, ''yy    周五, 八月 12, '16
 *          hh 'o''clock' a, zzzz    03 o'clock 下午, 中国标准时间
 *   yyyyy.MMMMM.dd GGG hh:mm aaa    02016.八月.12 公元 03:44 下午
 *     EEE, d MMM yyyy HH:mm:ss Z    周五, 12 八月 2016 15:44:40 +0800
 *                  yyMMddHHmmssZ    160812154440+0800
 *     yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
 * EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz    星期五 DATE(2016-08-12) TIME(15:44:40) 中国标准时间
 * </pre>
 * 注意：SimpleDateFormat不是线程安全的，线程安全需用{@code ThreadLocal<SimpleDateFormat>}
 */
object TimeUtils {

    /**
     * calendar -> String
     *
     * 默认返回 yyyy/MM/dd 格式
     */
    fun calendar2String(calendar: Calendar?, pattern: String = "yyyy/MM/dd"): String {
        if (calendar == null) return ""
        return SimpleDateFormat(pattern, Locale.getDefault()).format(calendar.time)
    }

    /**
     * 获取当前时间字符串
     * <p>格式为pattern, 默认返回 yyyy/MM/dd 格式</p>
     *
     * @param pattern 时间格式
     * @return 时间字符串
     */
    fun nowTimeString(pattern: String = "yyyy/MM/dd"): String {
        return millis2String(System.currentTimeMillis(), pattern)
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为pattern, 默认返回 yyyy/MM/dd 格式</p>
     *
     * @param millis 毫秒时间戳
     * @param pattern 时间格式
     * @return 时间字符串
     */
    fun millis2String(millis: Long, pattern: String = "yyyy/MM/dd"): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(Date(millis))
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为pattern, 默认yyyy/MM/dd 格式</p>
     *
     * @param time 毫秒时间戳
     * @param pattern 时间字符串
     * @return 毫秒时间戳
     */
    fun string2Millis(time: String, pattern: String = "yyyy/MM/dd"): Long {
        return try {
            SimpleDateFormat(pattern, Locale.getDefault()).parse(time)?.time ?: -1
        } catch (e: Exception) {
            -1
        }
    }

    /**
     * 获取友好型与当前时间的差
     */
    fun friendlyTimeSpanByNow(time: String, pattern: String = "yyyy/MM/dd"): String {
        return friendlyTimeSpanByNow(string2Millis(time, pattern))
    }

    /**
     * 获取友好型与当前时间的差
     */
    fun friendlyTimeSpanByNow(millis: Long): String {
        val now = System.currentTimeMillis()
        val span = now - millis
        if (span < 0) return String.format("%tc", millis)

        return when {
            span < 1000 -> "刚刚"
            span < MIN -> String.format("%d秒前", span / SEC)
            span < HOUR -> String.format("%d分钟前", span / MIN)
            else -> {
                val wee = (now / DAY) * DAY
                when {
                    millis >= wee -> String.format("今天%tR", millis)
                    millis >= wee - DAY -> String.format("昨天%tR", millis)
                    else -> String.format("%tF", millis)
                }
            }
        }
    }

    /**
     * 日期格式转换
     */
    fun datePatternConversion(date: String, from: String, to: String): String {
        val formTime = string2Millis(date, from)
        return millis2String(formTime, to)
    }

    /**
     * 加年
     */
    fun plusYears(date: String, pattern: String, years: Int): String {
        return if (SysUtils.isAndroid8()) {
            LocalDate.parse(date).plusYears(years.toLong()).minusDays(1).toString()
        } else {
            val formTime = string2Millis(date, pattern)
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = formTime
            calendar.add(Calendar.YEAR, years)
            calendar.add(Calendar.DAY_OF_MONTH, -1)
            calendar2String(calendar, pattern)
        }
    }
}