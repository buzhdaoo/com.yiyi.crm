package com.yiyi.crm.workbench.service.impl;

import com.yiyi.crm.utils.SqlSessionUtil;
import com.yiyi.crm.workbench.dao.ActivityDao;
import com.yiyi.crm.workbench.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao= SqlSessionUtil.getSqlSession ().getMapper (ActivityDao.class);
}
