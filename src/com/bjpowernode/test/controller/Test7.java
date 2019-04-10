package com.bjpowernode.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

/**
 * ClassName:Test7
 * Package:com.bjpowernode.test.controller
 * Dscription:
 *
 * @date:2019/4/4 8:54
 * @Author:liujian
 */
public class Test7 {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(32);

//        String srcPath = "E:\\copy";
//        String targetPath = "E:\\copy-target";
//        copy(srcPath,targetPath);

//        bubbleSort();

        jdbcConnection(7369);
    }

    public static void copy(String srcPath, String targetPath) {

        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
        //判断是不是文件
        if (srcFile.isFile()) {
            copyFile(srcPath, targetPath);
            return;
        }
        //是文件夹
        File[] files = srcFile.listFiles();
        targetFile.mkdir();
        for (File file : files) {
            String s = file.toString().split("\\\\")[file.toString().split("\\\\").length - 1];
            if (file.isFile()) {
                copyFile(file.toString(), targetPath + "\\" + s);
            } else {
                copy(file.toString(), targetPath + "\\" + s);
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
            while ((len = fis.read()) > 0) {
                fos.write(bytes, 0, len);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

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

    public static void bubbleSort() {

        int[] a = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        for (int j = 0; j < a.length - 2; j++) {
            for (int i = j; i < a.length - 1; i++) {
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
    }

    public static void jdbcConnection(Integer empno) {

        String sql = "select * from emp where empno = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode", "root", "123456");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empno);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(0));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}




















