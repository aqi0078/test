package com.zdz.test.web.tool.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

    public static boolean isTrue(String regex, String orginal) {
        Pattern pattern = Pattern.compile(regex);
        Matcher isTrue = pattern.matcher(orginal);
        return isTrue.matches();
    }
}
