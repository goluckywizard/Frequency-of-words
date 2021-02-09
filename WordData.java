package com.company;

public class WordData implements Comparable<WordData>{
    StringBuilder word;
    Integer count;
    public WordData(StringBuilder word, int count) {
        this.word = word;
        this.count = count;
    }
    public int compareTo(WordData data){
        return -(this.count - data.count);
    }
}
