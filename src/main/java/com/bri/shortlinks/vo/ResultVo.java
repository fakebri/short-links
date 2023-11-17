package com.bri.shortlinks.vo;

import lombok.Data;

@Data
public class ResultVo {
    private String message;
    private Object data;

    public ResultVo(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResultVo() {
    }
}
