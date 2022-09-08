package org.example.entil;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.example.util.DateOfDay;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

public class DataBaseGet {
    public String getDayClass() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://39.101.78.69:3306/myclass?user=root&password=guiqi308&useUnicode=true&useSSL=false";
        String username = "root";
        String password = "guiqi308";
        Connection connection= DriverManager.getConnection(url, username, password);
        Date date = new Date();
        DateOfDay dateOfDay = new DateOfDay();

        String sql = "";

        sql = "select * from mydb2";

        //3.获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);

        //5.执行sql
        ResultSet rs = pstmt.executeQuery();


        //6.处理结果
        String kebiao = "";
        String sum = "";
        while (rs.next()) {
            //获取数据
            kebiao = rs.getString(dateOfDay.getWeek(date));
            sum += kebiao + "\n" + "--------------------------------" + "\n";
        }
        return sum;
    }
}
