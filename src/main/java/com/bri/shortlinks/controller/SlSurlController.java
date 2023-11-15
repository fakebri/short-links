package com.bri.shortlinks.controller;

import com.bri.shortlinks.pojo.SlSurl;
import com.bri.shortlinks.service.SlSurlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 短链接-源链接;(sl_surl)表控制层
 *
 * @date : 2023-11-15
 */
@Api(tags = "短链接-源链接对象功能接口")
@RestController
public class SlSurlController {
    @Resource
    private SlSurlService slSurlService;

    @PostMapping("/reshort")
    public ResponseEntity<?> reShort(@RequestBody String shortUrl) {
        System.out.println(shortUrl);
        return ResponseEntity.ok(slSurlService.reShort(shortUrl));
    }


    @ApiOperation("新增短链接")
    @PostMapping
    public ResponseEntity<SlSurl> add(SlSurl slSurl) {
        return ResponseEntity.ok(slSurlService.insert(slSurl));
    }

}