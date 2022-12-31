package com.datastruct.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyDate {

    public String myDate;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");

    public MyDate(String myDate) {
        this.myDate = myDate;
    }

    public void setDate(String myDate) {
        this.myDate = myDate;
    }

    public void plusOneDay() {
        try {
            Date date = df.parse(myDate);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            date = calendar.getTime();
            myDate = df.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void printDate() {
        try {
            String format = df2.format(df.parse(myDate));
            System.out.println(format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MyDate myDate1 = new MyDate("2022-03-04");
        myDate1.plusOneDay();
        myDate1.printDate();
    }
}
