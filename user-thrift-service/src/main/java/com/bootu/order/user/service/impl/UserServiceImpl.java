package com.bootu.order.user.service.impl;

import com.bootu.order.user.mapper.UserMapper;
import com.bootu.thrift.user.UserInfo;
import com.bootu.thrift.user.UserService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService.Iface {


    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserById(int id) throws TException {
        return userMapper.getUserById(id);
    }

    @Override
    public UserInfo getUserByName(String username) throws TException {
        return userMapper.getUSerByName(username);
    }

    @Override
    public void regiserUser(UserInfo userinfo) throws TException {
        userMapper.registerUser(userinfo);
    }
}