package com.jr.util;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBHelper {
    //获得连接
    public static Connection getconn() throws IOException, ClassNotFoundException, SQLException {
        //1.使用io流 将属性文件 输入到程序里
        InputStream is= ConnectionPropertiesTransform.class.getClassLoader().getResourceAsStream("jdbc.properties");

        //2.将io 转换为 Properties
        Properties properties=new Properties();
        properties.load(is);

        //3.获得连接对象： 三要素 ：驱动，url，用户名和密码
        String url=properties.getProperty("url");
        String username=properties.getProperty("user");
        String password=properties.getProperty("password");
        String driverClass=properties.getProperty("driverClass");
        Class.forName(driverClass);
        Connection con= DriverManager.getConnection(url,username,password);
        //System.out.println(con);
        return con;
    }


    //关闭连接
    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection con) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

    public static void SIUD(String sql, Object... obj) throws SQLException, IOException, ClassNotFoundException {

//        try {
            Connection getconn = DBHelper.getconn();
            PreparedStatement ps = getconn.prepareStatement(sql);
            for (int i = 1; i <= obj.length + 1; i++) {
                ps.setObject(i, obj[i - 1]);
            }
//            if(sql.)
//            ResultSet rs = ps.executeQuery();
//

//        }
    }
}


