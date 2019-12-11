package me.jinhao.springblog.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.jinhao.springblog.form.CommentForm;
import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.model.Comment;
import me.jinhao.springblog.service.BlogService;
import me.jinhao.springblog.service.CommentService;
import me.jinhao.springblog.util.CommonRest;
import me.jinhao.springblog.util.MD5Util;

@CrossOrigin
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{blogId}")
    private List<Comment> getComments(@PathVariable Integer blogId){
        List<Comment> comments = commentService.findCommentsByBlogIdOrderByCreatedTimeDesc(blogId)
                                                .stream()
                                                .map(comment->commentListInBlogDTO(comment))
                                                .collect(Collectors.toList());
        comments.add(new Comment());
        return comments;
    }

    //not need for blog information in comment section of a blog page
    private Comment commentListInBlogDTO(Comment comment){
        comment.setAvatar("https://www.gravatar.com/avatar/" + MD5Util.md5Hex(comment.getEmail().toLowerCase().trim()) + "?s=50&d=identicon");
        comment.setBlog(null);
        return comment;
    }
/*
    @GetMapping("/load/{blogId}")
    public String load(@PathVariable Integer blogId, Model model) {
        load_section(blogId, new CommentForm(blogId), model);
        return "/comment_section";
    }
*/
    @PostMapping("/blog/{blogId}")
    public CommonRest addComment(@RequestBody @Valid CommentForm commentForm, BindingResult bindingResult, Model model) {

        if (!bindingResult.hasErrors()) {
            commentService.addCommentByForm(commentForm);
            return new CommonRest(null);
        } else {
            Map<String,String> errors = new HashMap<String,String>();
            bindingResult.getFieldErrors().forEach((error)->{
                errors.put(error.getField(),error.getDefaultMessage());
            });
            return new CommonRest(-1, errors);
        }
    }

}