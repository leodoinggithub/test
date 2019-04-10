package com.bjpowernode.test.controller;

import java.io.*;

/**
 * ClassName:Test6
 * Package:com.bjpowernode.test.controller
 * Dscription:
 *
 * @date:2019/4/3 8:59
 * @Author:liujian
 */
public class Test6 {

    public static void main(String[] args) {

        int[] a = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        for (int j = 0; j < (a.length - 2); j++) {
            for (int i = j; i < (a.length - 1); i++) {
                //如果前一个大于后一个
                if (a[i] > a[i + 1]) {
                    int b = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = b;
                }
            }
        }
        for (int c : a) {
            System.out.println(c);
        }

        String srcPath = "E:\\copy";
        String targetPath = "E:\\copy-target";
        copy(srcPath, targetPath);
    }

    public static void copy(String srcPath, String targetPath) {

        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
        //判断是不是文件
        if (srcFile.isFile()) {
            copyFile(srcPath, targetPath);
            return;
        }
        //是文件夹的情况
        File[] files = srcFile.listFiles();
        targetFile.mkdir();
        if (files.length != 0) {
            for (File file : files) {
                String s = file.toString().split("\\\\")[file.toString().split("\\\\").length - 1];
                if (file.isFile()) {
                    copyFile(file.toString(), targetPath + "\\" + s);
                } else {
                    copy(file.toString(), targetPath + "\\" + s);
                }
            }
        }
    }

    public static void copyFile(String srcPath, String targetPath) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(targetPath);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) > 0) {
                fos.write(bytes, 0, len);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}






















