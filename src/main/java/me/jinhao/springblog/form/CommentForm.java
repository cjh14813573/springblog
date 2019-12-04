package me.jinhao.springblog.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import me.jinhao.springblog.model.Comment;

@Data
public class CommentForm {

    @NotNull(message = "no valid blog specified")
    private Integer blogId;

    @NotBlank(message = "a nick name is needed")
    private String name;

    @NotBlank(message = "email can not be empty")
    @Email(message = "please enter a valid email")
    private String email;

    private String website;

    @NotBlank(message = "content can not be empty")
    private String content;

    public CommentForm(){

    }

    public CommentForm(Integer blogId){
        this.blogId = blogId;
    }

    public CommentForm(Comment comment){
        this.blogId = comment.getBlog().getId();
        this.name = comment.getName();
        this.email = comment.getEmail();
        this.website = comment.getWebsite();
        this.content = comment.getContent();
    }
    
}