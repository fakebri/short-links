package com.bri.shortlinks.controller;

import com.bri.shortlinks.pojo.SlUser;
import com.bri.shortlinks.service.AuthService;
import com.bri.shortlinks.vo.ResultVo;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "身份验证接口")
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SlUser loginUser) {
        SlUser resultUser = authService.queryUserByUserNameAndPassword(loginUser.getUserName(), loginUser.getPassword());
        ResultVo resultVo = new ResultVo();
        if (resultUser != null) {
            resultVo.setMessage("登录成功");
            resultVo.setData(resultUser);
            return ResponseEntity.ok(resultVo);
        } else {
            resultVo.setMessage("账户或密码错误");
            resultVo.setData(null);
            return ResponseEntity.badRequest().body(resultVo);
        }
    }
}
