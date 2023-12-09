package com.bri.shortlinks.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ShortUrlDTO {
    @NotBlank(message = "源链接不能为空")
    private String originalUrl;

    @NotNull
    @URL(message = "错误的URL")
    private String customShortUrl;
    @Range(min = 1, max = 30, message = "过期时间必须在0-30天之间")
    private int expiresDays;
}
