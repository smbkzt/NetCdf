package com.eazydev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scaneer = new Scanner(System.in);
//        String urlToParse = "http://www.unidata.ucar.edu/software/netcdf/examples/files.html";
        String urlToParse = "https://people.sc.fsu.edu/~jburkardt/data/netcdf/netcdf.html";

        System.out.println("Enter url address to parse: ");
        String url = scaneer.nextLine();
        HtmlParser parser = new HtmlParser();
        parser.parser(urlToParse);
    }
}
