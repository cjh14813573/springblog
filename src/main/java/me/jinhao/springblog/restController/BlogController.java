package me.jinhao.springblog.restController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.service.BlogService;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public Page<Blog> home(@RequestParam(defaultValue = "0") Integer page){
        /* 
        List<Blog> blogs = blogService.findAllBlogs()
                                        .stream()
                                        .map(blog->blogListDTO(blog))
                                        .collect(Collectors.toList());
        */                          
        Page<Blog> blogs = blogService.findAllBlogsByPage(page);
        return blogs;
    }

    private Blog blogListDTO(Blog blog) {
        blog.setContent(null);
        blog.setCommentList(null);
        blog.setCategory(null);
        return blog;
    }

    @GetMapping("/{id}")
    public Blog blog(@PathVariable Integer id) {
        Blog blog = blogService.findBlogById(id);
        return blog;
    }

}