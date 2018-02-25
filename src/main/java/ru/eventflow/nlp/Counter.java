package ru.eventflow.nlp;

import java.util.*;

public class Counter {

    private final Map<String, Integer> counts;
    private int n;

    public Counter(int n) {
        this.n = n;
        this.counts = new HashMap<>();
    }

    public void count(String line) {
        for (int i = 0; i < line.length() - n; i++) {
            String ngram = line.substring(i, i + n);
            int count = counts.getOrDefault(ngram, 0);
            counts.put(ngram, count + 1);
        }
    }

    public Map<String, Integer> getCounts() {
        return counts;
    }

    public List<String> getKeys() {
        return new ArrayList<>(counts.keySet());
    }

}
