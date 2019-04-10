package com.bjpowernode.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName:Test2
 * Package:com.bjpowernode.test.controller
 * Dscription:
 *
 * @date:2019/3/27 20:21
 * @Author:liujian
 */
public class Test2 {

    public static void main(String[] args){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        File file = new File("E:\\copy");
        File fileTarget = new File("E:/copy-target");
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(fileTarget);

            byte bytes[] = new byte[1024];
            int len = 0;
            while((len=fis.read(bytes)) >= 0){
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
