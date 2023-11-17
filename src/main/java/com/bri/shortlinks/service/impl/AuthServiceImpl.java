package com.bri.shortlinks.service.impl;

import com.bri.shortlinks.dao.SlUserMapper;
import com.bri.shortlinks.pojo.SlUser;
import com.bri.shortlinks.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    SlUserMapper slUserMapper;

    @Override
    public SlUser queryUserByUserNameAndPassword(String userName, String password) {
        return slUserMapper.queryByUserNameAndPassword(userName, password);
    }
}
