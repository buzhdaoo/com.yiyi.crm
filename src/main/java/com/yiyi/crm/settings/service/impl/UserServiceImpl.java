package com.yiyi.crm.settings.service.impl;

import com.yiyi.crm.exception.LoginException;
import com.yiyi.crm.settings.dao.UserDao;
import com.yiyi.crm.settings.domain.User;
import com.yiyi.crm.settings.service.UserService;
import com.yiyi.crm.utils.DateTimeUtil;
import com.yiyi.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        Map<String,String>map=new HashMap<>();
        UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
        map.put ("loginAct",loginAct);
        map.put ("loginPwd",loginPwd);
        User user =userDao.login(map);
        if (user==null){
            throw new LoginException ("账号密码错误");
        }
        String exprieTime=user.getEditTime ();
        String currentTime= DateTimeUtil.getSysTime ();
        if (exprieTime.compareTo (currentTime)<0){
            throw new LoginException ("账号已失效");
        }
        String lockState=user.getLockState ();
        if ("0".equals (lockState)){
            throw new LoginException ("账号已锁定");
        }
        String allowIps=user.getAllowIps ();
        if (allowIps.contains (ip)){
            throw new LoginException ("ip地址受限");
        }
        return user;
    }
}
