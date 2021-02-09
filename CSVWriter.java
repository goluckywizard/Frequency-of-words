package com.company;

import com.company.WordData;

import java.io.FileWriter;
import java.io.IOException;
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
        FileWriter toCSV = null;
        try{
            toCSV = new FileWriter("out.csv");
            for (WordData data : dataSet) {
                //System.out.println(data.word +" "+data.count+" "+((float)data.count/totalCount)*100);
                toCSV.write(data.word +" "+data.count+" "+((float)data.count/totalCount)*100+"\n");
            }
        }
        catch (IOException er) {
            System.err.println("Error while writing file: " + er.getLocalizedMessage());
        }
        finally {
            if (null != toCSV) {
                try {
                    toCSV.close();
                }
                catch (IOException er) {
                    er.printStackTrace(System.err);
                }
            }
        }
        for (WordData data : dataSet) {
            System.out.println(data.word +" "+data.count+" "+((float)data.count/totalCount)*100);
        }
    }
}
