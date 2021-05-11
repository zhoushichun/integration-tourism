package com.ifm.comment.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Checkcellphone {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if ((phoneNumber != null) && (!phoneNumber.isEmpty())) {
            return Pattern.matches("^1[3-9]\\d{9}$", phoneNumber);
        }
        return false;
    }


    //方式二：根据Matcher 和Pattern 判断
    public static boolean isMobilesNumber(String str) {
        Pattern pattern = Pattern.compile("1[358][0-9]{9}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }

    }

}
