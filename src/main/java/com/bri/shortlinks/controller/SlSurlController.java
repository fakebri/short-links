package com.bri.shortlinks.controller;

import com.bri.shortlinks.pojo.SlSurl;
import com.bri.shortlinks.service.SlSurlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    @PostMapping("/short")
    public ResponseEntity<SlSurl> shortUrl(@RequestBody String originalUrl) {
        return ResponseEntity.ok(slSurlService.shortUrl(originalUrl));
    }

    @ApiOperation("跳转链接")
    @GetMapping("/s/{redirectPath}")
    public ResponseEntity<?> navigate(HttpServletRequest request) {
        String redirectUrl = slSurlService.navigate(String.valueOf(request.getRequestURL()));
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "text/plain; charset=UTF-8");
        if (redirectUrl != null) {
            headers.add("Location", redirectUrl);
            return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).headers(headers).body("跳转中...");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("你所访问到链接不存在");
    }

}