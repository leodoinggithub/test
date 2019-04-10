package com.bjpowernode.test.controller;

import java.io.*;

/**
 * ClassName:Test5
 * Package:com.bjpowernode.test.controller
 * Dscription:
 *
 * @date:2019/4/2 11:02
 * @Author:liujian
 */
public class Test5 {

    public static void main(String[] args){

        String srcPath = "E:\\copy";
        String targetPath = "E:\\copy-target";
        Test5 test5 = new Test5();
        test5.copy(srcPath,targetPath);
    }

    public static void copy(String srcPath,String targetPath){

        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
        //如果是文件
        if(srcFile.isFile()){
            copyFile(srcPath, targetPath);
            return;
        }
        //判断是不是空
        File[] files = srcFile.listFiles();
        for(File file:files){
            targetFile.mkdir();
            String s = file.toString().split("\\\\")[file.toString().split("\\\\").length-1];
            if(files.length!=0){
                if(file.isFile()){
                    copyFile(file.toString(),targetPath+"\\"+s);
                }else{
                    copy(file.toString(),targetPath+"\\"+s);
                }
            }
        }

    }

    public static void copyFile(String srcPath,String targetPath){

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(targetPath);
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = fis.read(bytes))>0){
                fos.write(bytes,0,len);
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

























