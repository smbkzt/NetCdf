package com.eazydev;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlParser {
    public void parseIt(String url) {
        String urlToParse;
        int count = 0;

        // Проверяем ссылку
        if (!url.startsWith("http")){
            urlToParse = "http://" + url;
        }
        else urlToParse = url;

        // Получаем страницу
        Document doc = null;
        try {
            doc = Jsoup.connect("" + urlToParse).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String title = doc.title();
        System.out.println("___________________________");
        System.out.println(title);
        System.out.println("___________________________");
        System.out.println("Files: ");

        // Получаем все элементы из документа по тэгу
        Elements links = doc.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();

            if (linkHref.endsWith(".nc")){
                count++;
                System.out.print(count + ") ");

                if (linkHref.startsWith("http")) {
                    System.out.println(linkText + " " + linkHref);
                }
                else{
                    String urlToDownload = urlToParse.substring(urlToParse.indexOf("h"), urlToParse.lastIndexOf("/")) + "/" + linkHref;
                    System.out.println(linkText + " " + urlToDownload);
                }
            }
        }
    }
}
