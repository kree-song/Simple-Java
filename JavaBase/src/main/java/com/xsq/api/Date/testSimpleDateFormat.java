package com.xsq.api.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testSimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        //格式化(从Date到String)
        Date date = new Date();
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String result = sdf.format(date);
        System.out.println(result);
        System.out.println("---------------------------------------------------------");

//解析(从String到Date)
        String s = "2021-02-04 20:49:39";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = sdf2.parse(s);
        System.out.println(date2);

    }
}
