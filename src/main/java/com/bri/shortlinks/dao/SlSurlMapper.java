package com.bri.shortlinks.dao;

import com.bri.shortlinks.pojo.SlSurl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 短链接-源链接;(sl_surl)表数据库访问层
 *
 * @author : bri
 * @date : 2023-11-15
 */
@Mapper
public interface SlSurlMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param surlId 主键
     * @return 实例对象
     */
    SlSurl queryById(Integer surlId);

    /**
     * 分页查询指定行数据
     *
     * @param slSurl   查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<SlSurl> queryAllByLimit(SlSurl slSurl, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param slSurl 查询条件
     * @return 总行数
     */
    long count(SlSurl slSurl);

    /**
     * 新增数据
     *
     * @param slSurl 实例对象
     * @return 影响行数
     */
    int insert(SlSurl slSurl);

    /**
     * 批量新增数据
     *
     * @param entities List<SlSurl> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SlSurl> entities);

    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<SlSurl> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SlSurl> entities);

    /**
     * 更新数据
     *
     * @param slSurl 实例对象
     * @return 影响行数
     */
    int update(SlSurl slSurl);

    /**
     * 通过主键删除数据
     *
     * @param surlId 主键
     * @return 影响行数
     */
    int deleteById(Integer surlId);

    SlSurl queryByShortUrl(String shortUrl);
}