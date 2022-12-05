package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;



    @Override
    public User selectByAccountAndPassword(User user) {
        User user1=null;
        try {
            con = DBHelper.getconn();
            String sql = "select * from user where name=? and password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());

            rs = ps.executeQuery();
            if (rs.next()) {
                user1 = new User(
                           rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("enterprise_id"),
                        rs.getString("phone"),
                        rs.getString("account"),
                        rs.getString("password"),
                        rs.getString("idcard_name"),
                        rs.getString("idcard_no"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }

        return user1;
    }

}