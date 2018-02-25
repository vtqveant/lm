package ru.eventflow.nlp;

import java.io.*;

public class Processor {

    private Counter unigrams = new Counter(1);
    private Counter bigrams = new Counter(2);
    private Counter trigrams = new Counter(3);
    private Language language;

    public Processor(Language language) {
        this.language = language;
    }

    public void process(File f) throws IOException {
        InputStream in = new FileInputStream(f);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = reader.readLine()) != null) {
            int index = line.indexOf('\t');
            String sentence = line.substring(0, index);
            String lang = line.substring(index + 1);

            if (lang.equals(language.getCode())) {
                unigrams.count(sentence);
                bigrams.count(sentence);
                trigrams.count(sentence);
            }
        }
    }

    public LanguageModel buildLanguageModel() {
        MLModel model = new MLModel();
        model.addCounts(unigrams.getCounts());
        model.addCounts(bigrams.getCounts());
        model.addCounts(trigrams.getCounts());
        return model;
    }
}
