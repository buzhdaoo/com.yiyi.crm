package com.yiyi.crm.settings.dao;

import com.yiyi.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {
    User login(Map<String, String> map);
}