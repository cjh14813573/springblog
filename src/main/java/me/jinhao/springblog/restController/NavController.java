package me.jinhao.springblog.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.jinhao.springblog.model.Page;
import me.jinhao.springblog.service.PageService;

@RestController
@RequestMapping("/api/nav")
public class NavController {

    @Autowired
    private PageService pageService;

    @GetMapping("")
    public Map<String, Object> widgetData() {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        List<Page> nPages = pageService.findAllPages()
                                        .stream()
                                        .map(page->pageNavDto(page))
                                        .collect(Collectors.toList());
        resultMap.put("nPages", nPages);
        
        return resultMap;
    }

    private Page pageNavDto(Page page){
        //do not need content in nav
        page.setContent("");
        return page;
    }

}