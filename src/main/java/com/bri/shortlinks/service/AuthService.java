package com.bri.shortlinks.service;


import com.bri.shortlinks.pojo.SlUser;

public interface AuthService {
    SlUser queryUserByUserNameAndPassword(String userName, String password);
}
