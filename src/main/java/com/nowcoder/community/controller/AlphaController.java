package com.nowcoder.community.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/alpha")
//"/alpha"相当于给类起名，便于浏览器访问
//ResponseBody作用：我们return的是一个字符串，不是一个网页，所以要加以说明
public class AlphaController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot.";
    }
}
