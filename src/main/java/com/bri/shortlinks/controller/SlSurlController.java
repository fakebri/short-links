package com.bri.shortlinks.controller;

import com.bri.shortlinks.dto.ReshortDTO;
import com.bri.shortlinks.dto.ShortUrlDTO;
import com.bri.shortlinks.pojo.SlSurl;
import com.bri.shortlinks.service.SlSurlService;
import com.bri.shortlinks.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 短链接-源链接;(sl_surl)表控制层
 *
 * @date : 2023-11-15
 */
@Api(tags = "短链接-源链接对象功能接口")
@RestController
@CrossOrigin
public class SlSurlController {

    @Resource
    private SlSurlService slSurlService;

    @ApiOperation("链接数量统计")
    @GetMapping("/count")
    public long count() {
        return slSurlService.count();
    }

    @ApiOperation("还原短链接")
    @PostMapping("/reshort")
    public ResponseEntity<?> reShort(@RequestBody @Validated ReshortDTO reshortDTO, BindingResult result) {
        if (result.hasErrors()) {
            // 处理验证错误
            ResultVo resultVo = new ResultVo(result.getFieldError().getDefaultMessage(), result.getFieldError().getField());
            return ResponseEntity.badRequest().body(resultVo);
        }
        SlSurl surl = slSurlService.reShort(reshortDTO.getShortUrl());
        if (surl != null) {
            ResultVo resultVo = new ResultVo("成功", surl);
            return ResponseEntity.ok(resultVo);
        }
        return ResponseEntity.notFound().build();
    }


    @ApiOperation("新增短链接")
    @PostMapping("/short")
    public ResponseEntity<?> shortUrl(@RequestBody @Validated ShortUrlDTO shortUrlDTO, BindingResult result) {
        if (result.hasErrors()) {
            // 处理验证错误
            ResultVo resultVo = new ResultVo(result.getFieldError().getDefaultMessage(), result.getFieldError().getField());
            return ResponseEntity.badRequest().body(resultVo);
        }
        // TODO: 1.增加有效期;
        SlSurl resultData = slSurlService.shortUrl(shortUrlDTO.getOriginalUrl(), shortUrlDTO.getCustomShortUrl(), shortUrlDTO.getExpiresDays());
        ResultVo resultVo = new ResultVo("新增成功", resultData);
        return ResponseEntity.ok(resultVo);
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