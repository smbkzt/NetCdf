package com.eazydev;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HtmlParser {
    private Map<String, String> map;
    private Reader reader;
    private Scanner scanner;

    public HtmlParser(){
        map = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void parseIt(String url) {
        String urlToParse;
        int count = 0;

        // Проверяем ссылку
        if (!url.startsWith("http")){
            urlToParse = "http://" + url;
        }
        else urlToParse = url;

        // Получаем страницу
        Document doc;
        try {
            doc = Jsoup.connect("" + urlToParse).get();
            String title = doc.title();
            System.out.println("___________________________");
            System.out.println(title);
            System.out.println("___________________________");
            System.out.println("\nФайлы, найденные на выбранном ресурсе: \n");

            // Получаем все элементы из документа по тэгу
            Elements links = doc.getElementsByTag("a");
            for (Element link : links) {
                String linkHref = link.attr("href");
                String linkText = link.text();

                if (linkHref.endsWith(".nc")){
                    count++;
                    System.out.print(count + ") ");

                    if (linkHref.startsWith("https")){
                        String LinK = linkHref.replaceAll("https", "http");
                        System.out.println(linkText + " " + LinK);
                        map.put(String.valueOf(count), LinK);
                    }
                    else if (linkHref.startsWith("http")) {
                        System.out.println(linkText + " " + linkHref);
                        map.put(String.valueOf(count), linkHref);
                    }
                    else if (linkHref.startsWith("ftp")){ // ftp ссылки не работают при чтении файлов
                        System.out.println(linkText + " " + linkHref + " ftp ссылки недоступны для чтения");
                        map.put(String.valueOf(count), linkHref);
                    }
                    else{
                        String urlToDownload = urlToParse.substring(urlToParse.indexOf("h"), urlToParse.lastIndexOf("/")) + "/" + linkHref;
                        System.out.println(linkText + "\t" + urlToDownload);
                        map.put(String.valueOf(count), urlToDownload.replaceAll("https", "http"));
                    }
                }
            }
            System.out.println("Для открытия файла введите номер: ");
            int answer = scanner.nextInt();
            reader = new Reader(map.get(String.valueOf(answer)));
            reader.readWholeFile();
        }
        catch (IOException e) {
            System.out.println("Недействительная ссылка!");
        }
    }
}
