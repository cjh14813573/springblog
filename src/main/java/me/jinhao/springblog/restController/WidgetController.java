package me.jinhao.springblog.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @GetMapping("/test")
    public Map<String, Object> test() {
        Map<String,Object> testResult = new HashMap<String,Object>();
        testResult.put("testK", "testV");
        return testResult;
    }

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
        List<Category> wCategories = categoryService.findAllCategories()
                                                    .stream()
                                                    .map(cat->categoryWidgetDto(cat))
                                                    .collect(Collectors.toList());
        resultMap.put("wCategories", wCategories);


        // tags widget
        List<Tag> wTags = tagService.findAllTags();
        resultMap.put("wTags", wTags);

        return resultMap;
    }

    private Category categoryWidgetDto(Category category){
        //do not need blog information here
        category.setBlogList(null);
        return category;
    }

}