package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
import com.jr.until.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaolmpl implements IUserDao {
    /**
     * 通过用户账号和用户密码查询指定用户，登入功能
     */
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public User queryByAccountAndPassword(User user) {
        User u2=null;
        try{
            Connection con= DBHelper.getconn();
            String sql="select * from user where account=? and password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,u2.getAccount());
            ps.setString(2,u2.getPassword());
            rs=ps.executeQuery();
            while (rs.next()){
                u2.setAccount(rs.getString(1));
                u2.setPassword(rs.getString(2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return u2;
    }
}
