package me.jinhao.springblog.form;

import lombok.Data;
import me.jinhao.springblog.model.Comment;

@Data
public class CommentForm {

    private Integer blogId;

    private String name;

    private String email;

    private String website;

    private String content;

    public CommentForm(){

    }

    public CommentForm(Comment comment){
        this.blogId = comment.getBlog().getId();
        this.name = comment.getName();
        this.email = comment.getEmail();
        this.website = comment.getWebsite();
        this.content = comment.getContent();
    }
    
}