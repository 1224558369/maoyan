package com.huyuya.maoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huyu
 * @version 1.0
 * @date 2021/6/29 14:49
 */
@Controller
public class IndexController {
    @GetMapping("/toLogin")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
