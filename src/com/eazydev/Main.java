package com.eazydev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter url address to parse: ");
        String url = scanner.next();

        HtmlParser parser = new HtmlParser();
        parser.parseIt(url);
    }
}
