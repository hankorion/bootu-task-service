package com.bootu.order.user.controller;

import com.bootu.order.user.response.Response;
import com.bootu.order.user.thrift.UserServiceProvider;
import com.bootu.order.user.utils.MD5Util;
import com.bootu.thrift.user.UserInfo;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceProvider userServiceProvider;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Response login(@RequestParam("username")String username,@RequestParam("password")String password){
        UserInfo userInfo = null;
        try {
            userInfo = userServiceProvider.getUserService().getUserByName(username);
            return Response.USERNAME_PASSWORD_INVALID;
        } catch (TException e) {
            e.printStackTrace();
        }

        if(userInfo == null){
            return Response.USERNAME_PASSWORD_INVALID;
        }
        if(!userInfo.getPassword().equals(MD5Util.encodeStr(password.trim()))){
            return Response.USERNAME_PASSWORD_INVALID;
        }

    }
}
