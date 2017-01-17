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
         __map.put("unidata.ucar.edu", "http://www.unidata.ucar.edu/software/netcdf/examples/files.html");
         __map.put("people.sc.fsu.edu", "https://people.sc.fsu.edu/~jburkardt/data/netcdf/netcdf.html");
         __map.put("ncdc.noaa.gov", "https://www.ncdc.noaa.gov/thredds/catalog/isccp/catalog.html");
         __map.put("esrl.noaa.gov", "https://www.esrl.noaa.gov/psd/data/gridded/data.gpcp.html");
         __map.put("crudata.uea.ac.uk", "https://crudata.uea.ac.uk/cru/data/temperature/");

    }

    public void chooseIt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите желаемый ресурс введя только цифру:");
        __map.forEach((site, link) ->{
            count++;
            System.out.print(count + ")" + " " + site + "\n");
        });
        System.out.print("Желаемый ресурс под номером: ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                __parser.parseIt(__map.get("unidata.ucar.edu"));
                break;
            case 2:
                __parser.parseIt(__map.get("people.sc.fsu.edu"));
                break;
            case 3:
                __parser.parseIt(__map.get("ncdc.noaa.gov")); //Климатические данные с 1983-2009
                break;
            case 4:
                __parser.parseIt(__map.get("esrl.noaa.gov"));
                break;
            case 5:
                __parser.parseIt(__map.get("crudata.uea.ac.uk"));
                break;
            default:
//                System.out.println("Неправильный ввод!");
                Reader r = new Reader("http://www.unidata.ucar.edu/software/netcdf/examples/testrh.nc");
                r.ReadWhole();
                break;
        }
    }
}
