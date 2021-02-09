package com.company;

import com.company.WordData;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Iterator;

public class CSVWriter {
    private int totalCount;
    private TreeMap<StringBuilder, Integer> CSVData;
    CSVWriter(int totalCount, TreeMap<StringBuilder, Integer> CSVData) {
        this.totalCount = totalCount;
        this.CSVData = CSVData;
    }
    void show() {
        TreeSet<WordData> dataSet = new TreeSet<>();
        for (Map.Entry<StringBuilder, Integer> entry: CSVData.entrySet()) {
            StringBuilder key = entry.getKey();
            Integer value = entry.getValue();
            //System.out.println(key+" "+value+"\n");
            dataSet.add(new WordData(key, value));
        }
        for (WordData data : dataSet) {
            System.out.println(data.word +" "+data.count+" "+((float)data.count/totalCount)*100);
        }
    }
}
