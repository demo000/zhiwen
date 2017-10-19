package com.dem.weixin.utils;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DEM on 2017/10/15.
 */
public class RgRexTest {



    @Test
    public void testFirst(){
        String test = "this is my 1st test 2st String";
        String myRex = "\\d+\\w+";//\d+\w
        Pattern compile = Pattern.compile(myRex);
        Matcher matcher = compile.matcher(test);
        while (matcher.find()){

            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("匹配字符:"+group+"\n匹配位置:["+start+","+end+"]");
        }

    }
    @Test
    public void test2(){
        boolean matches = "1214".matches("\\d*");
        System.out.println(matches);
        System.out.println("1212a".matches("\\d*"));

    }
    @Test
    public void test3(){
        String testStr = "before java 1.5 and java 1.4 and java 1.6 ";
        String reg = "\\bjava\\s*1\\.([56])\\b";
        Matcher matcher = Pattern.compile(reg).matcher(testStr);
        System.out.println(matcher.replaceAll("java 1.$1.0"));
        System.out.println(testStr.replaceAll("\\bjava\\s*1\\.([56])\\b","java 1.$1.0"));
    }

}