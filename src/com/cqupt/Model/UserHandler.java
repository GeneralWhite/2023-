package com.cqupt.Model;

import com.cqupt.Entity.User;
import com.cqupt.Util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// BO, 业务逻辑操作，针对user表的数据操作
public class UserHandler
{
    private Connection conn;

    public UserHandler()
    {
    }

    // 登录验证
    public boolean loginCheck(User user)
    {
        conn = DBHelper.getCon();
        boolean result = false;
        Statement sta = null;
        ResultSet rs = null;

        try
        {
            sta = conn.createStatement();
            String sql = "select password from user where username='" + user.getUsername() + "'";
            rs = sta.executeQuery(sql);

            if (rs.next())
            {
                if (rs.getString(1).equals(user.getPassword()))
                {
                    result = true;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
                sta.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return result;
    }
}
