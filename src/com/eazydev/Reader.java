package com.eazydev;
import ucar.ma2.Array;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NCdumpW;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;
import ucar.nc2.dataset.NetcdfDataset;

import java.io.IOException;
import java.util.Scanner;


public class Reader {
    private NetcdfFile nc = null;
    private String fileName;
    private Scanner scanner;


    public Reader(String filePath){
        fileName = filePath;
        scanner = new Scanner(System.in);
    }

    public void readWholeFile(){
        try {
            nc = NetcdfDataset.open(fileName, null);
//            System.out.println("Краткое описание файла: " + nc.findGlobalAttribute("title").getStringValue());

            System.out.println("Хотите открыть файл полностью? д/н ");
            String answer = scanner.next();

            if (answer.equals("д")){
                System.out.println(nc);
                getData();
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

    public void getData(){
        String varName = "tas";
        Variable v = nc.findVariable(varName);
        if (null == v) return;
        try {
            Array data = v.read("0, 0:120, 0:250");
            NCdumpW.printArray(data, varName, System.out, null);

        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (InvalidRangeException e) {
            System.out.println(e);
        }
    }
}
