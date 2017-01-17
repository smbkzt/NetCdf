package com.eazydev;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Choices {
    private HtmlParser __parser;
    private Map<String, String> __categories;
    private Map<String, String> __types;
    private Map<String, String> __sources;
    private int count = 0;

    public Choices() {
        __parser = new HtmlParser();
        __categories = new HashMap<>();
        __types = new HashMap<>();
        __sources = new HashMap<>();
        __categories.put("1", "Атмосферные осадки");
    }

    public void selectSource() {
        count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите метеорологический центр: ");
        __sources.forEach((name, link) -> {
            count++;
            System.out.println(count + ")" + " " + name);

        });
        int choice = scanner.nextInt();
        __parser.parseIt(__sources.get(__sources.keySet().toArray()[choice - 1]));

    }

    public void selectTypes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип сбора данных: ");
        __types.forEach((id, name) -> {
            System.out.println(id + " " + name);
        });
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Вы выбрали: " + __types.get(String.valueOf(choice)));
                __sources.put("NASA GIS", "http://research.jisao.washington.edu/data_sets/precip_eofts/");
                __sources.put("National Centers for Environmental Prediction (NCEP) Climate Prediction Center", "http://research.jisao.washington.edu/data_sets/unified/");
                __sources.put("University of Delaware", "http://research.jisao.washington.edu/data_sets/ud/");
                __sources.put("University of Washington", "http://www.cses.washington.edu/data/gridded.shtml");
                selectSource();
                break;
            case 2:
                System.out.println("Вы выбрали: " + __types.get(String.valueOf(choice)));
                __sources.put("NOAA NCEP Climate Prediction Center Merged Analysis of Precipitation", "http://research.jisao.washington.edu/data_sets/cmap_precip/");
                __sources.put("Global Precipitation Climatology Project (GPCP)", "http://research.jisao.washington.edu/data_sets/gpcp/");
                __sources.put("Legates / MSU Precipitation Climatology", "http://research.jisao.washington.edu/legates_msu/");
                __sources.put("GOES Precipitation Index (GPI)", "http://research.jisao.washington.edu/data_sets/gpi/");
                __sources.put("Outgoing Longwave Radiation", "http://research.jisao.washington.edu/data_sets/olr/index.html");
                __sources.put("Special Sensor Microwave / Imager (SSM/I)", "http://research.jisao.washington.edu/data_sets/ssmi/nesdis/");
                selectSource();
                break;
        }
    }

    public void selectCategories() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите категорию: ");
        __categories.forEach((id, name) -> {
            System.out.println(id + " " + name);
        });
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Вы выбрали: " + __categories.get(String.valueOf(choice)));
                __types.put("1", "С помощью дождемера: ");
                __types.put("2", "С помощью спутника: ");
                selectTypes();
                break;
            //Добавить типы по итогам исследования
        }
    }

}
