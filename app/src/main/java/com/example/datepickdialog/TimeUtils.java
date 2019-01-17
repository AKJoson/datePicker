package com.example.datepickdialog;


import android.text.TextUtils;

import com.example.MyApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * The method to parse a specified String value to a Date instance according to the pattern that provided.
     *
     * @param pattern    the pattern to parse String, like "yyyy-MM-dd", "HH:mm:ss" , etc.
     * @param dateString the String value needed to be parsed.
     * @return the Date instance.
     * @throws ParseException if the specified dateString cannot be parsed.
     */
    public static Date parse(String pattern, String dateString) throws ParseException {
        return new SimpleDateFormat(pattern, MyApplication.getContext().getResources().getConfiguration().locale).parse(dateString);
    }

    /**
     * The method to format a specified Date instance as a String value according to the pattern that provided.
     *
     * @param pattern the pattern to format Date, like "yyyy-MM-dd", "HH:mm:ss" , etc.
     * @param date    the Date instance needed to be formatted.
     * @return the String value.
     */
    public static String format(String pattern, Date date) {
        return new SimpleDateFormat(pattern, MyApplication.getContext().getResources().getConfiguration().locale).format(date);
    }

    /**
     * Method to get the common formatted date.
     *
     * @param date the string date.
     * @return the formatted string date.
     * @throws ParseException
     */
    public static Date getCommonFormatDate(String date) throws ParseException {
        return parse("yyyy-MM-dd HH:mm:ss", date);
    }

    /**
     * Judgement method if the time is legal.
     *
     * @param time the time.
     * @return true illegal, otherwise false.
     */
    public static boolean isIllegalTime(String time) {
        return TextUtils.isEmpty(time) || time.contains("0000-00-00");
    }


}
