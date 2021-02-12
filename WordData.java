package com.company;

public class WordData implements Comparable<WordData>{
    StringBuilder word;
    Integer count;
    public WordData(StringBuilder word, int count) {
        this.word = word;
        this.count = count;
    }
    public int compareTo(WordData data) {
        String first = this.word.toString();
        String second = data.word.toString();
        int strCompare = (first.compareTo(second) > 0) ? 1 : 0;
        return -((this.count - data.count) * 2 - strCompare);
    }
}
