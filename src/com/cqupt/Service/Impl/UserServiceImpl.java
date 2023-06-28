package com.cqupt.Service.Impl;

import com.cqupt.DAO.Impl.UserDaoImpl;
import com.cqupt.DAO.UserDao;
import com.cqupt.Entity.User;
import com.cqupt.Service.UserService;

public class UserServiceImpl implements UserService
{
    private UserDao userDao;
    public boolean loginCheck(User user)
    {
        boolean result = false;

        userDao = new UserDaoImpl();
        User returnUser = userDao.selbyUsername(user);
        if(returnUser == null)
        {
            return false;
        }
        if(returnUser.getPassword().equals(user.getPassword()))
        {
            result = true;
        }
        return result;
    }
}
