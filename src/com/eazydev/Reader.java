package com.eazydev;
import ucar.nc2.NetcdfFile;
import ucar.nc2.dataset.NetcdfDataset;

import java.io.IOException;
import java.util.Scanner;


public class Reader {
    String fileName;
    Scanner scanner;


    public Reader(String filePath){
        fileName = filePath;
        scanner = new Scanner(System.in);
    }

    public void ReadWhole(){
        NetcdfFile nc = null;
        try {
            nc = NetcdfDataset.open(fileName, null);
//            System.out.println("Краткое описание файла: " + nc.findGlobalAttribute("title").getStringValue());

            System.out.println("Хотите открыть файл полностью? д/н ");
            String answer = scanner.next();

            if (answer.equals("д")){
                System.out.println(nc);
            }
            else {
                return;
            }
        }
        catch (IOException ioe) {
            System.out.println("При попытке открыть файл " + fileName + " произошла ошибка: " + ioe);


        } finally {
            if (null != nc) try {
              nc.close();
            } catch (IOException ioe) {
                System.out.println("При попытке закрыть файл " + fileName + " произошла ошибка: " + ioe);
            }
        }
    }
}
