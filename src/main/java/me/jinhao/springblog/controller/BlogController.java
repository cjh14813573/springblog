package me.jinhao.springblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.jinhao.springblog.exception.BlogNotFoundException;
import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/{id}")
    public String blog(@PathVariable Integer id, Model model) throws BlogNotFoundException {
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "/blog";
    }
}