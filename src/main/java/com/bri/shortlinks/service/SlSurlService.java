package com.bri.shortlinks.service;

import com.bri.shortlinks.pojo.SlSurl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 短链接-源链接;(sl_surl)表服务接口
 *
 * @author : bri
 * @date : 2023-11-15
 */
public interface SlSurlService {
    /**
     * 通过ID查询单条数据
     *
     * @param surlId 主键
     * @return 实例对象
     */
    SlSurl queryById(Integer surlId);

    /**
     * 分页查询
     *
     * @param slSurl      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SlSurl> paginQuery(SlSurl slSurl, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param slSurl 实例对象
     * @return 实例对象
     */
    SlSurl insert(SlSurl slSurl);

    /**
     * 更新数据
     *
     * @param slSurl 实例对象
     * @return 实例对象
     */
    SlSurl update(SlSurl slSurl);

    /**
     * 通过主键删除数据
     *
     * @param surlId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer surlId);

    SlSurl reShort(String shortUrl);

    SlSurl shortUrl(String originalUrl);
}