package com.company;

public class Main {

    public static void main(String[] args) {
        Parser a = new Parser();
        a.parse(args[0]);
        CSVWriter b = new CSVWriter(a.getTotalCount(), a.getCSVData());
        b.show();
    }
}
