package com.jr.dao.impl;

import com.jr.dao.IEnterpriseDao;
import com.jr.entry.Enterprise;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseDaoImpl implements IEnterpriseDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public Enterprise queryEnterpriseByEnterpriseID(int in) {
        Enterprise enterprise = new Enterprise();
        try {
            con = DBHelper.getconn();
            String sql = "select * from enterprise where id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,in);
            rs = ps.executeQuery();
            while (rs.next()){
                enterprise.setId(rs.getInt("id"));
                enterprise.setName(rs.getString("name"));
                enterprise.setSocialUniformCcode(rs.getString("social_uniform_code"));
                enterprise.setEmail(rs.getString("email"));
                enterprise.setPhone(rs.getString("phone"));
                enterprise.setAddress(rs.getString("address"));
                enterprise.setScale(rs.getString("scale"));
                enterprise.setFax(rs.getString("fax"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }

        return enterprise;
    }

    @Override
    public List<Enterprise> queryAllEnterprise() {
        List<Enterprise> enterprises = new ArrayList<>();
        try {
            Connection con = DBHelper.getconn();
            String sql = "select * from enterprise";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Enterprise enterprise1 = new Enterprise(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("social_uniform_code"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("scale"),
                        rs.getString("fax")
                );
                enterprises.add(enterprise1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return enterprises;
    }
}
