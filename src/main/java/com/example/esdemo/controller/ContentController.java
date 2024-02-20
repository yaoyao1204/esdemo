package com.example.esdemo.controller;

import com.example.esdemo.service.ContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wmy
 * @version 1.0
 * @date 2024/2/19 10:03
 * @description
 */
@RestController
public class ContentController {
    @Resource
    private ContentService contentService;

    @GetMapping("/parse/{keyword}")
    public Boolean parse(@PathVariable("keyword") String keyword) throws Exception {
        return contentService.parseContent(keyword);
    }

    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword, @PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) throws Exception {
        return contentService.searchPage(keyword, pageNo, pageSize);
    }
    /**
     * 实现搜索高亮显示
     */
    @GetMapping("/highlight/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> highlight(@PathVariable("keyword") String keyword, @PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) throws Exception {
        return contentService.searchHighlightPage(keyword, pageNo, pageSize);
    }

}
