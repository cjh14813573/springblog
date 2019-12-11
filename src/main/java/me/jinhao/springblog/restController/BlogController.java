package me.jinhao.springblog.restController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.jinhao.springblog.exception.BlogNotFoundException;
import me.jinhao.springblog.form.CommentForm;
import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.service.BlogService;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public List<Blog> home(){
        List<Blog> blogs = blogService.findAllBlogs()
                                        .stream()
                                        .map(blog->blogListDTO(blog))
                                        .collect(Collectors.toList());
        return blogs;
    }

    private Blog blogListDTO(Blog blog){
        blog.setContent(null);
        blog.setCommentList(null);
        blog.setCategory(null);
        return blog;
    }


    @GetMapping("/{id}")
    public Blog blog(@PathVariable Integer id){
        Blog blog = blogService.findBlogById(id);
        return blog;
    }


}