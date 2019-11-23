package me.jinhao.springblog.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import me.jinhao.springblog.model.Blog;
import me.jinhao.springblog.model.Tag;

@Data
public class BlogForm {

    private Integer id;

    @NotBlank(message = "title can not be empty")
    private String title;

    @Size(min = 5, max = 200, message = "length should be in range of 5~200")
    private String brief;

    @NotBlank(message = "content can not be empty")
    private String content;

    @NotNull(message = "you must choose a category")
    private Integer categoryId;

    private List<Integer> tagIdList;

    public BlogForm() {

    }

    public BlogForm(Blog blog) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.brief = blog.getBrief();
        this.content = blog.getContent();
        this.categoryId = blog.getCategory().getId();
        List<Integer> tagIdList = new ArrayList<Integer>();
        for (Tag tag : blog.getTagList()) {
            tagIdList.add(tag.getId());
        }
        this.tagIdList = tagIdList;
    }

}