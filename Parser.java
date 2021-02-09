package com.company;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Parser {
    //final String space_extractor = "[\\w]+";
    private TreeMap<StringBuilder, Integer> CSVData;
    private int totalCount = 0;
    void parse(String textName) {
        CSVData = new TreeMap<>();
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(textName));
            //Pattern pattern = Pattern.compile(space_extractor);
            StringBuilder word = new StringBuilder();
            while (reader.ready()) {
                int symbol = reader.read();
                if (Character.isLetterOrDigit(symbol)) {
                    word.append((char)symbol);
                }
                else {
                    if (word.isEmpty())
                        continue;
                    ++totalCount;
                    //System.out.println(word);
                    if (CSVData.containsKey(word)) {
                        CSVData.put(word, CSVData.get(word) + 1);
                    }
                    else
                        CSVData.put(word, 1);
                    //word.setLength(0);
                    word = new StringBuilder();
                }
            }
            if (!word.isEmpty()) {
                ++totalCount;
                //System.out.println(word);
                if (CSVData.containsKey(word)) {
                    CSVData.put(word, CSVData.get(word) + 1);
                }
                else
                    CSVData.put(word, 1);
                //HashMap<StringBuilder, Integer> aaaa = new HashMap<>(CSVData);
            }
            /*for (Map.Entry<StringBuilder, Integer> entry: CSVData.entrySet()) {
                StringBuilder key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(key+" "+value+"\n");
            }*/

        } catch (IOException er) {
            System.err.println("Error while reading file: " + er.getLocalizedMessage());
        }
        finally {
            if (null != reader) {
                try {
                    reader.close();
                }
                catch (IOException er) {
                    er.printStackTrace(System.err);
                }
            }
        }
    }
    public final TreeMap<StringBuilder, Integer> getCSVData() {
        return CSVData;
    }
    public final int getTotalCount() {
        return totalCount;
    }
}
