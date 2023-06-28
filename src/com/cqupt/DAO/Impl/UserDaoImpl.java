package com.cqupt.DAO.Impl;

import com.cqupt.DAO.UserDao;
import com.cqupt.Entity.User;
import com.cqupt.Util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao
{
    public User selbyUsername(User user)
    {
        User returnUser = null;
        Connection conn = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            conn = DBHelper.getCon();
            ps = conn.prepareStatement("select * from user where username='" + user.getUsername() + "'");
            rs = ps.executeQuery();

            if(rs.next())
            {
                returnUser = new User();
                returnUser.setId(user.getId());
                returnUser.setUsername(rs.getString(2));
                returnUser.setPassword(rs.getString(3));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBHelper.getClose(conn, ps, rs);
        }

        return returnUser;
    }


}
