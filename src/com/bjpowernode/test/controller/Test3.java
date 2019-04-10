package com.bjpowernode.test.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName:Test3
 * Package:com.bjpowernode.test.controller
 * Dscription:
 *
 * @date:2019/3/28 10:21
 * @Author:liujian
 */
public class Test3 {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("1");
        list.add("1");
//        list.stream().distinct().forEach(x -> System.out.println(x));
        Set<String> set = new HashSet<>(list);
        System.out.println(set);

        //线程
        for (int i=0;i<1000;i++){
//            Test3 test3 = new Test3();
//            Thread thread = new Thread(test3);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
            thread.start();

        }

    }

//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName());
//    }
}





















