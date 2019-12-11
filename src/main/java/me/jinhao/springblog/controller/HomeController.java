package me.jinhao.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("")
    public String index(){
        return "forward:/index.html";
    }

    @GetMapping("/home")
    public String home(){
        return "forward:/index.html";
    }
/*

    @GetMapping("")
    public String home(Model model){
        List<Blog> blogs = blogService.findAllBlogs();
        model.addAttribute("blogs", blogs);
        return "/home";
    }
    */

    @GetMapping("/admin")
    public String admin(){
        return "/admin";
    }
}