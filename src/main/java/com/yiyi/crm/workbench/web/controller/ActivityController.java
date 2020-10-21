package com.yiyi.crm.workbench.web.controller;
import com.yiyi.crm.settings.domain.User;
import com.yiyi.crm.settings.service.UserService;
import com.yiyi.crm.settings.service.impl.UserServiceImpl;
import com.yiyi.crm.utils.PrintJson;
import com.yiyi.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ActivityController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println ("进入到市场控制器" );
        String path=request.getServletPath ();
        if ("/workbench/activity/getUserList.do".equals (path)){
           getUserList(request,response);
        }else  if ("/workbench/activity/xxx.do".equals (path)) {
            //xxx(request,response)
        }
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println ("取得用户信息列表" );
        UserService us= (UserService) ServiceFactory.getService (new UserServiceImpl ());
        List<User> uList=us.getUserList();
        PrintJson.printJsonObj (response,uList);

    }
}
