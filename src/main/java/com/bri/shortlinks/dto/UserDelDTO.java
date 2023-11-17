package com.bri.shortlinks.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDelDTO {
    private List<Integer> delUserIds;
}
