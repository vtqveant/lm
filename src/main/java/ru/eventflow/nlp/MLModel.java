package ru.eventflow.nlp;

import java.util.HashMap;
import java.util.Map;

/**
 * Maximum likelihood language model
 */
public class MLModel implements LanguageModel {

    private final Map<String, Integer> counts;

    public MLModel() {
        this.counts = new HashMap<>();
    }

    public void addCounts(Map<String, Integer> counts) {
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            int c = counts.getOrDefault(entry.getKey(), 0);
            counts.put(entry.getKey(), c + entry.getValue());
        }
    }

    @Override
    public double getParameter(String s) {
        if (s.length() == 0) {
            throw new IllegalArgumentException("empty string");
        } else {
            return counts.getOrDefault(s, 0) / getParameter(s.substring(0, s.length() - 1));
        }
    }
}
