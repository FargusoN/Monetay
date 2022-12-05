package com.jr.biz.impl;

import com.jr.biz.IUserBiz;
import com.jr.dao.impl.UserDaoImpl;
import com.jr.entry.User;

public class UserBizImpl implements IUserBiz {
    @Override
    public User login(User user) {

        return new UserDaoImpl().selectByAccountAndPassword(user);
    }
}
