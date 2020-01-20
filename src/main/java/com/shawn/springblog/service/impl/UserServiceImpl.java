package com.shawn.springblog.service.impl;


import com.shawn.springblog.entity.User;
import com.shawn.springblog.repository.UserRepository;
import com.shawn.springblog.service.UserService;
import com.shawn.springblog.util.EncodeUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        password = EncodeUtils.encode(password);
        System.out.println("username = " + username + ", password = " + password);
        User byUsernameAndPassword = userRepository.findByUsernameAndPassword(username, password);
        System.out.println(byUsernameAndPassword == null);
        return byUsernameAndPassword;
    }
}
