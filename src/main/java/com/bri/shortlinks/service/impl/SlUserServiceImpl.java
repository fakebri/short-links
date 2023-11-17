package com.bri.shortlinks.service.impl;

import com.bri.shortlinks.dao.SlUserMapper;
import com.bri.shortlinks.pojo.SlUser;
import com.bri.shortlinks.service.SlUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表;(sl_user)表服务实现类
 *
 * @author : bri
 * @date : 2023-11-16
 */
@Service
public class SlUserServiceImpl implements SlUserService {
    @Resource
    private SlUserMapper slUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SlUser queryById(Integer userId) {
        return slUserMapper.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param slUser      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SlUser> paginQuery(SlUser slUser, PageRequest pageRequest) {
        long total = slUserMapper.count(slUser);
        return new PageImpl<>(slUserMapper.queryAllByLimit(slUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param slUser 实例对象
     * @return 实例对象
     */
    @Override
    public SlUser insert(SlUser slUser) {
        slUserMapper.insert(slUser);
        return slUser;
    }

    /**
     * 更新数据
     *
     * @param slUser 实例对象
     * @return 实例对象
     */
    @Override
    public SlUser update(SlUser slUser) {
        slUserMapper.update(slUser);
        return queryById(slUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        int total = slUserMapper.deleteById(userId);
        return total > 0;
    }
}