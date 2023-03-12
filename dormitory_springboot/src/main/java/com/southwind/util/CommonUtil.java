package com.southwind.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CommonUtil {
    public static  String createDate(){
        //把当前时间转换 年-月-日 格式，如  2023-2-8
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
