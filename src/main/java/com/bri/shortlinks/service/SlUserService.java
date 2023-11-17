package com.bri.shortlinks.service;

import com.bri.shortlinks.pojo.SlUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户表;(sl_user)表服务接口
 *
 * @author : bri
 * @date : 2023-11-16
 */
public interface SlUserService {
    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SlUser queryById(Integer userId);

    /**
     * 分页查询
     *
     * @param slUser      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SlUser> paginQuery(SlUser slUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param slUser 实例对象
     * @return 实例对象
     */
    SlUser insert(SlUser slUser);

    /**
     * 更新数据
     *
     * @param slUser 实例对象
     * @return 实例对象
     */
    SlUser update(SlUser slUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);
}