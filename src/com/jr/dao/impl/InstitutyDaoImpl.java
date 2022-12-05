package com.jr.dao.impl;

import com.jr.dao.IInstitutyDao;
import com.jr.entry.Instituty;
import com.jr.util.DBHelper;

import javax.smartcardio.CommandAPDU;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstitutyDaoImpl implements IInstitutyDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Instituty> queryAllInstituty() {

        List<Instituty> list=new ArrayList<>();
        try {
            con= DBHelper.getconn();
            String sql="select * from instituty";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Instituty is=new Instituty();
                is.setId(rs.getInt("id"));
                is.setName(rs.getString("name"));
                list.add(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return list;
    }
}
