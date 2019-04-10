package com.bjpowernode.test.controller;

import com.bjpowernode.test.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Test1
 * Package:com.bjpowernode.test
 * Dscription:
 *
 * @date:2019/3/27 15:56
 * @Author:liujian
 */
public class Test1 {

    public static void main(String[] args){

        String sql = "select name from student where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student stu = new Student();
        List<Student> sList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://lcoalhost:3306/databaseName", "root", "123456");
            ps = conn.prepareStatement(sql);
            ps.setString(1,"001");
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                stu.setName(name);
                sList.add(stu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}















