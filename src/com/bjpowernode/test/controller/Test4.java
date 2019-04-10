package com.bjpowernode.test.controller;

import java.io.*;

/**
 * ClassName:Test4
 * Package:com.bjpowernode.test.controller
 * Dscription:
 *
 * @date:2019/3/30 12:01
 * @Author:liujian
 */
public class Test4 {

    public static void main(String[] args){
        String srcPath = "E:\\copy";
        String targetPath = "E:\\copy-target";
        copy(srcPath,targetPath);
    }


    public static void copy(String srcPath,String targetPath) {

        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
        //如果是文件
        if (srcFile.isFile()) {
            copyFile(srcPath, targetPath);
        }else{
            File[] listFiles = srcFile.listFiles();
            //文件夹为空
            if (listFiles.length == 0) {
                if(!targetFile.exists()){
                    targetFile.mkdir();
                }
            }
            //文件夹不为空
            for (File file:listFiles) {
                if(file.isFile()){
                    copyFile(file.toString(),targetPath+"/"+file.toString().split("\\\\")[file.toString().split("\\\\").length-1]);
                }else{

                    File srcFileNew = new File(targetPath+"/"+file.toString().split("\\\\")[file.toString().split("\\\\").length-1]);
                    srcFileNew.mkdir();
                    copy(file.toString(),targetPath+"/"+file.toString().split("\\\\")[file.toString().split("\\\\").length-1]);

                }
            }


        }
        //不是文件就是文件夹

    }

    //拷贝文件
    public static void copyFile(String srcPath, String targetPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(targetPath);

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) >= 0) {
                fos.write(bytes, 0, len);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}














