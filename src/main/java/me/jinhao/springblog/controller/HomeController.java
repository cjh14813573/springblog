package me.jinhao.springblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.service.BlogService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String home(Model model){
        List<Blog> blogs = blogService.findAllBlogs();
        model.addAttribute("blogs", blogs);
        return "/home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin";
    }
}