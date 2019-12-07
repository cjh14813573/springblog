package me.jinhao.springblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.jinhao.springblog.model.Comment;
import me.jinhao.springblog.service.CommentService;

@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController {


    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public String index(Model model){
        List<Comment> comments = commentService.findAllComments();
        model.addAttribute("comments",comments);
        return "/admin/comment/index";
    }
    
}