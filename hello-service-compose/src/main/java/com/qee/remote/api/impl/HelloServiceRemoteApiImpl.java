package com.qee.remote.api.impl;

import com.qee.remote.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by hzzhuqi1 on 2017/5/22.
 */
@RestController
public class HelloServiceRemoteApiImpl implements HelloServiceRemoteApi {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        try {
            name= URLDecoder.decode(name,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        if (user == null) {
            return "未知";
        }
        return user.toString();
    }
}