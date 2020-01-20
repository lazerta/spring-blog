package com.shawn.springblog.service;


import com.shawn.springblog.entity.User;

public interface UserService {

    User checkUser(String username, String password);
}
