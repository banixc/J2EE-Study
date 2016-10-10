package com.banixc.study.j2ee.lesson.ex3;

/**
 * Created by Banixc on 2016/10/8.
 */
public class StatisticInfo {

    private static int count = 1;

    public static synchronized int getCount(){

        return count++;
    }
}
