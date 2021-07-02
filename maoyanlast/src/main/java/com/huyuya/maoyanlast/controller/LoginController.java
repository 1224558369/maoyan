package com.huyuya.maoyanlast.controller;

import com.huyuya.maoyanlast.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author huyu
 * @version 1.0
 * @date 2021/7/1 9:11
 */
@RestController
@RequestMapping("/film/user")
@CrossOrigin // 解决跨域!!!
public class LoginController {
    // login
    @PostMapping("/login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @GetMapping("/info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://huyuya.oss-cn-hangzhou.aliyuncs.com/mm01.jpg");
    }

    // login
    @PostMapping("/logout")
    public R logout() {
        return R.ok();
    }

}
