package com.bri.shortlinks.dao;

import com.bri.shortlinks.pojo.SlUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户表;(sl_user)表数据库访问层
 *
 * @author : bri
 * @date : 2023-11-16
 */
@Mapper
public interface SlUserMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SlUser queryById(Integer userId);

    /**
     * 分页查询指定行数据
     *
     * @param slUser   查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<SlUser> queryAllByLimit(SlUser slUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param slUser 查询条件
     * @return 总行数
     */
    long count(SlUser slUser);

    /**
     * 新增数据
     *
     * @param slUser 实例对象
     * @return 影响行数
     */
    int insert(SlUser slUser);

    /**
     * 批量新增数据
     *
     * @param entities List<SlUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SlUser> entities);

    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<SlUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SlUser> entities);

    /**
     * 更新数据
     *
     * @param slUser 实例对象
     * @return 影响行数
     */
    int update(SlUser slUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

    SlUser queryByUserNameAndPassword(String userName, String password);

    List<SlUser> queryAll();
}