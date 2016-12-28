package com.eazydev;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Choices {
    private HtmlParser __parser;
    private Map<String, String> __map;
    private int count = 0;

    public Choices(){
         __map = new HashMap<>();
         __parser = new HtmlParser();
         __map.put("UniData.ucar.edu", "http://www.unidata.ucar.edu/software/netcdf/examples/files.html");
         __map.put("people.sc.fsu.edu", "https://people.sc.fsu.edu/~jburkardt/data/netcdf/netcdf.html");
    }

    public void chooseIt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста выберите желаемый ресурс:");
        __map.forEach((site, link) ->{
            count++;
            System.out.print(count + ")" + " " + site + "\t");
        });
        System.out.println("");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                __parser.parseIt(__map.get("UniData.ucar.edu"));
                break;
            case 2:
                __parser.parseIt(__map.get("people.sc.fsu.edu"));
                break;
            default:
                System.out.println("Неправильный ввод!");

        }
//        __map.forEach((site, link) -> System.out.println(site + "\t" + link));
    }
}
