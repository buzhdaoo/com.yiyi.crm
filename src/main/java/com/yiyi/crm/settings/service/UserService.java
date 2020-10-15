package com.yiyi.crm.settings.service;

import com.yiyi.crm.exception.LoginException;
import com.yiyi.crm.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
