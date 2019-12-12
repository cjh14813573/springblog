package me.jinhao.springblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import me.jinhao.springblog.form.CommentForm;
import me.jinhao.springblog.model.Comment;
import me.jinhao.springblog.service.CommentService;

@Controller
@RequestMapping("/comment")
public class OldCommentController {

    @Autowired
    private CommentService commentService;

    private void load_section(Integer blogId, CommentForm commentForm, Model model){
        //Blog blog = blogService.findBlogById(blogId);
        //List<Comment> comments = blog.getCommentList();
        List<Comment> comments = commentService.findCommentsByBlogIdOrderByCreatedTimeDesc(blogId);
        model.addAttribute("comments", comments);
        model.addAttribute("commentForm", commentForm);
    }

    @GetMapping("/load/{blogId}")
    public String load(@PathVariable Integer blogId, Model model){
        load_section(blogId, new CommentForm(blogId), model);
        return "/comment_section";
    }

    @PostMapping("/add")
    public String addComment(@Valid CommentForm commentForm, BindingResult bindingResult, Model model){

        Integer blogId = commentForm.getBlogId();

        if(!bindingResult.hasErrors()){
            commentService.addCommentByForm(commentForm);
            load_section(blogId, new CommentForm(blogId), model);
        }else{
            load_section(blogId, commentForm, model);
        }


        return "/comment_section";
    }
}