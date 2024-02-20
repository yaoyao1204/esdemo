package com.example.esdemo.utils;

import com.example.esdemo.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wmy
 * @version 1.0
 * @date 2024/2/18 16:51
 * @description
 */
public class HtmlParseUtil {
    //    public static void main(String[] args) throws IOException {
//        // 获取请求
//        // 前提：需要连网
//        String url = "";
//        // 解析网页，jsoup返回document就是浏览器Document对象
//        Document document = Jsoup.parse(new URL(url), 30000);
//        // 所有在js中可以使用的方法，这里都能用
//        Element element = document.getElementById("J_goodsList");
//        System.out.println(element.html());
//        // 获取所有的li标签
//        Elements elements = element.getElementsByTag("li");
//        // 获取元素中的内容
//        for (Element e : elements) {
//            // 关于这种图片特别多的网站，所有的图片都是延迟加载的
//            // source-data-lazy-img
//            String img = e.getElementsByTag("source-data-lazy-img").eq(0).attr("src");
//            String price = e.getElementsByClass("p-price").eq(0).text();
//            String title = e.getElementsByClass("p-name").eq(0).text();
//            System.out.println("======================");
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(title);
//        }
//    }
    public static void main(String[] args) throws Exception {
        // keyword 不支持设置中文
        new HtmlParseUtil().parseJD("java").forEach(System.out::println);
    }

    public List<Content> parseJD(String keyword) throws Exception {
        ArrayList<Content> list = new ArrayList<>();
        String url = "";
        // 可以设置URL转换成可编译的字符集
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        for (Element e : elements) {
            String img = e.getElementsByTag("source-data-lazy-img").eq(0).attr("src");
            String price = e.getElementsByClass("p-price").eq(0).text();
            String title = e.getElementsByClass("p-name").eq(0).text();
            Content content = new Content();
            content.setImg(img);
            content.setPrice(price);
            content.setTitle(title);
        }
        return list;
    }
}
