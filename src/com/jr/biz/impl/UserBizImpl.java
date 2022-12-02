package com.jr.biz.impl;

import com.jr.biz.IUserBiz;
import com.jr.dao.impl.UserDaolmpl;
import com.jr.entry.User;

public class UserBizImpl implements IUserBiz {
    /*
     * 登录功能
     * */
    UserDaolmpl u1=new UserDaolmpl();
    @Override
    public boolean login(User user) {
        return u1.queryByAccountAndPassword(user)==null?true:false;
    }
}
