package com.bri.shortlinks.controller;

import com.bri.shortlinks.pojo.SlUser;
import com.bri.shortlinks.service.AuthService;
import com.bri.shortlinks.vo.ResultVo;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "身份验证接口")
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(HttpServletRequest request, @RequestBody SlUser loginUser) {
        ResultVo resultVo = new ResultVo();
        if (request.getSession().getAttribute("userName") !=null ) {
            resultVo.setMessage("用户已登录");
            return ResponseEntity.ok(resultVo);
        }
        SlUser resultUser = authService.queryUserByUserNameAndPassword(loginUser.getUserName(), loginUser.getPassword());
        if (resultUser != null) {
            request.getSession().setAttribute("userName", resultUser.getUserName());
            resultVo.setMessage("登录成功");
            resultVo.setData(resultUser.getUserName());
            return ResponseEntity.ok(resultVo);
        } else {
            resultVo.setMessage("账户或密码错误");
            resultVo.setData(null);
            return ResponseEntity.badRequest().body(resultVo);
        }
    }

    @GetMapping("/status")
    public ResponseEntity<?> getStatus(HttpServletRequest request) {
        ResultVo resultVo = new ResultVo();
        if (request.getSession().getAttribute("userName")!=null ) {
            resultVo.setMessage("用户已登录");
            resultVo.setData(request.getSession().getAttribute("userName"));
            return ResponseEntity.ok(resultVo);
        } else {
            resultVo.setMessage("用户未登录");
            return ResponseEntity.badRequest().body(resultVo);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        ResultVo resultVo = new ResultVo();
        request.getSession().removeAttribute("userName");
        resultVo.setMessage("用户已退出");
        return ResponseEntity.ok(resultVo);
    }
}
