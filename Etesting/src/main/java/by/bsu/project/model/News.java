package by.bsu.project.model;

/**
 * User: iason
 * Date: 15.02.15
 */
public class News {
    String title;
    String url;
    String content;
    String imageUrl;
    String date;

    public News() {

    }

    public News(String title, String url, String content, String imageUrl, String date) {
        this.title = title;
        this.url = url;
        this.content = content;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = "http://liceum.bsu.by" + url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = "http://liceum.bsu.by/" +imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
