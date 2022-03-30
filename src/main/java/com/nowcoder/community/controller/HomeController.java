package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import com.nowcoder.community.entity.User;

import java.util.*;

@Controller
public class HomeController {
    //Controller的访问路径可以省略，访问的时候就是这一级就是没有，就是空的，直接访问方法就可以了
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    //定义一下请求的访问路径
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //  方法调用之前，SpringMVC会自动实例化Model和Page，并将Page注入Model.
        //  所以，在thymeledf中可以直接访问Page对象中的数据.
        page.setRows(discussPostService.findDiscussPostRows(0));    //  page还有当前页码，每页显示多少条数据，页面可以传进来，不是服务器操心的事情
        page.setPath("/index");


        List<DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if(list != null)
        {
              for(DiscussPost post : list){
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        //我们需要把最终要给页面展现的结果装到Model里面，页面才可以得到
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }
}
