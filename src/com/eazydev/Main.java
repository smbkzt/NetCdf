package com.eazydev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scaneer = new Scanner(System.in);
        System.out.println("Enter url address to parse: ");
        String url = scaneer.next();
        HtmlParser parser = new HtmlParser();
        parser.parser(url);
    }
}
