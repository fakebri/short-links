package com.bri.shortlinks.service.impl;

import com.bri.shortlinks.dao.SlSurlMapper;
import com.bri.shortlinks.pojo.SlSurl;
import com.bri.shortlinks.service.SlSurlService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 短链接-源链接;(sl_surl)表服务实现类
 *
 * @author : bri
 * @date : 2023-11-15
 */
@Service
public class SlSurlServiceImpl implements SlSurlService {
    @Resource
    private SlSurlMapper slSurlMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param surlId 主键
     * @return 实例对象
     */
    @Override
    public SlSurl queryById(Integer surlId) {
        return slSurlMapper.queryById(surlId);
    }

    /**
     * 分页查询
     *
     * @param slSurl      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SlSurl> paginQuery(SlSurl slSurl, PageRequest pageRequest) {
        long total = slSurlMapper.count(slSurl);
        return new PageImpl<>(slSurlMapper.queryAllByLimit(slSurl, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param slSurl 实例对象
     * @return 实例对象
     */
    @Override
    public SlSurl insert(SlSurl slSurl) {
        slSurlMapper.insert(slSurl);
        return slSurl;
    }

    /**
     * 更新数据
     *
     * @param slSurl 实例对象
     * @return 实例对象
     */
    @Override
    public SlSurl update(SlSurl slSurl) {
        slSurlMapper.update(slSurl);
        return queryById(slSurl.getSurlId());
    }

    /**
     * 通过主键删除数据
     *
     * @param surlId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer surlId) {
        int total = slSurlMapper.deleteById(surlId);
        return total > 0;
    }

    @Override
    public SlSurl reShort(String shortUrl) {
        return slSurlMapper.queryByShortUrl(shortUrl);
    }
}