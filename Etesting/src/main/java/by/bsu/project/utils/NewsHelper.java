package by.bsu.project.utils;

import by.bsu.project.model.News;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * User: iason
 * Date: 15.02.15
 */
public class NewsHelper {
    public static List<News> getRandomNews() throws Exception{
        List<News> news = new ArrayList<>();
        Document doc = Jsoup.connect("http://liceum.bsu.by/").get();
        Elements elements = doc.getElementsByAttributeValue("class", "news-item");

        List<Element> list =  elements.subList(0, elements.size());
        Collections.shuffle(list);
        List<Element> el = list.subList(0, 3);
        for (Element e: el) {
            news.add(getNews(e));
        }
        return news;
    }


    private static News getNews(Element element) {
        News news = new News();
        news.setDate(element.getElementsByAttributeValue("class", "time").get(0).text());
        news.setUrl(element.getElementsByAttributeValue("class", "to-full-page").get(0).attr("href"));
        news.setTitle(element.getElementsByAttributeValue("class", "to-full-page").get(0).getElementsByTag("h3").get(0).text());
        if(!element.getElementsByTag("img").isEmpty()){
        news.setImageUrl(element.getElementsByTag("img").get(0).attr("src"));
        }
        if(!element.getElementsByAttributeValue("class", "teaser clearfix").isEmpty()){
        news.setContent(element.getElementsByAttributeValue("class", "teaser clearfix").get(0).text());
        } else {
            news.setContent(news.getTitle());
        }
        return news;
    }
}
