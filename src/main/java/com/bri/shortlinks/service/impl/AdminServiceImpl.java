package com.bri.shortlinks.service.impl;

import com.bri.shortlinks.dao.SlUserMapper;
import com.bri.shortlinks.pojo.SlUser;
import com.bri.shortlinks.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private SlUserMapper slUserMapper;

    @Override
    public List<SlUser> queryAll() {
        return slUserMapper.queryAll();
    }
}
