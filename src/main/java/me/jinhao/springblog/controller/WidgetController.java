package me.jinhao.springblog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.jinhao.springblog.model.Category;
import me.jinhao.springblog.model.Tag;
import me.jinhao.springblog.service.CategoryService;
import me.jinhao.springblog.service.TagService;

@RestController
@RequestMapping("/api/widget")
public class WidgetController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @GetMapping("")
    public Map<String, Object> widgetData() {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        // avatar widget
        String wAvatarImgSrc = "";
        String avatarFilePath = System.getProperty("user.home") + "/springblog/media/image/avatar/avatar.jpg";
        Resource avatarResource = new FileSystemResource(avatarFilePath);
        if (avatarResource.exists()) {
            wAvatarImgSrc = "/media/image/avatar/avatar.jpg";
        } else {
            wAvatarImgSrc = "https://picsum.photos/180/180";
        }
        resultMap.put("wAvatarImgSrc", wAvatarImgSrc);

        // catagories widget
        List<Category> wCategories = categoryService.findAllCategories();
        resultMap.put("wCategories", wCategories);

        // tags widget
        List<Tag> wTags = tagService.findAllTags();
        resultMap.put("wTags", wTags);

        return resultMap;
    }

}