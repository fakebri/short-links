package com.bri.shortlinks.controller;

import com.bri.shortlinks.dto.SUrlDelDTO;
import com.bri.shortlinks.dto.UserDelDTO;
import com.bri.shortlinks.pojo.SlSurl;
import com.bri.shortlinks.pojo.SlUser;
import com.bri.shortlinks.service.AdminService;
import com.bri.shortlinks.service.SlSurlService;
import com.bri.shortlinks.service.SlUserService;
import com.bri.shortlinks.vo.ResultVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "管理接口")
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private SlUserService slUserService;
    @Resource
    private SlSurlService slSurlService;
    @Resource
    private AdminService adminService;

    @GetMapping("/user/all")
    public List<SlUser> allUser() {
        return adminService.queryAll();
    }

    @PostMapping("/user/del")
    public ResultVo delUser(@RequestBody UserDelDTO userDelDTO) {
        for (Integer userId : userDelDTO.getDelUserIds()) {
            slUserService.deleteById(userId);
        }
        return new ResultVo("删除成功", userDelDTO);
    }

    @PostMapping("/user/add")
    public ResultVo addUser(@RequestBody SlUser slUser) {
        return new ResultVo("添加成功", slUserService.insert(slUser));
    }

    @PostMapping("/user/update")
    public ResultVo updateUser(@RequestBody SlUser slUser) {
        return new ResultVo("修改成功", slUserService.update(slUser));
    }

    @GetMapping("/surl/all")
    public List<SlSurl> allSurl() {
        return slSurlService.queryAll();
    }

    @PostMapping("/surl/del")
    public ResultVo delSurl(@RequestBody SUrlDelDTO sUrlDelDTO) {
        for (Integer surlId : sUrlDelDTO.getDelSurlIds()) {
            slSurlService.deleteById(surlId);
        }
        return new ResultVo("删除成功", sUrlDelDTO);
    }

    @PostMapping("/surl/add")
    public ResultVo addSurl(@RequestBody SlSurl surl) {
        return new ResultVo("添加成功", slSurlService.insert(surl));
    }

    @PostMapping("/surl/update")
    public ResultVo updateSurl(@RequestBody SlSurl surl) {
        return new ResultVo("修改成功", slSurlService.update(surl));
    }
}
