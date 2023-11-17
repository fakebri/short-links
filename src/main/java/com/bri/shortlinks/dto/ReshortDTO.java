package com.bri.shortlinks.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReshortDTO {
    @NotBlank
    private String shortUrl;
}
