package com.bri.shortlinks.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 短链接-源链接;
 *
 * @author : bri
 * @date : 2023-11-15
 */
@ApiModel(value = "短链接-源链接", description = "")
public class SlSurl implements Serializable, Cloneable {
    /**
     * 短链接编号
     */
    @ApiModelProperty(name = "短链接编号", notes = "")
    private Integer surlId;
    /**
     * 短链接
     */
    @ApiModelProperty(name = "短链接", notes = "")
    private String shortUrl;
    /**
     * 源链接
     */
    @ApiModelProperty(name = "源链接", notes = "")
    private String originalUrl;

    /**
     * 短链接编号
     */
    public Integer getSurlId() {
        return this.surlId;
    }

    /**
     * 短链接编号
     */
    public void setSurlId(Integer surlId) {
        this.surlId = surlId;
    }

    /**
     * 短链接
     */
    public String getShortUrl() {
        return this.shortUrl;
    }

    /**
     * 短链接
     */
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    /**
     * 源链接
     */
    public String getOriginalUrl() {
        return this.originalUrl;
    }

    /**
     * 源链接
     */
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
