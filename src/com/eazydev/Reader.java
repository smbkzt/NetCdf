package com.eazydev;
import ucar.nc2.NetcdfFile;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by smbek on 17.01.2017.
 */
public class Reader {
    String fileName;
    NetcdfFile nc = null;
    NetcdfFile  ncfile = null;
    Scanner scaneer;


    public Reader(String filePath){
        fileName = filePath;
        scaneer = new Scanner(System.in);
    }

    public void ReadWhole(){
        NetcdfFile nc = null;
        try {

            nc = NetcdfFile.open(fileName);
            System.out.println("Краткое опписание файла: " + nc.findGlobalAttribute("title").getStringValue());
            System.out.println("Хотите открыть файл полностью? д/н ");
            String answer = scaneer.next();

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
