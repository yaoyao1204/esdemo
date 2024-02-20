package com.example.esdemo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ContentService {
    public Boolean parseContent(String keywords) throws Exception;
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws Exception;
    public List<Map<String, Object>> searchHighlightPage(String keyword, int pageNo, int pageSize) throws IOException;
}
