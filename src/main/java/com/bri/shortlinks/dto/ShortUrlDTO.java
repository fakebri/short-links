package com.bri.shortlinks.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShortUrlDTO {
    @NotBlank(message = "源链接不能为空")
    private String originalUrl;
    private String customShortUrl;
    private int expiresDays;
}
