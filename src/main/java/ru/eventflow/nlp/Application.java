package ru.eventflow.nlp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.eventflow.nlp.Language.PT_PT;

public class Application {

    private static final String DATA_DIR = "/home/transcend/code/HALLUCINATE/lm/data";

    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();
        Counter unigrams = new Counter(1);
        Counter bigrams = new Counter(2);
        Counter trigrams = new Counter(3);

        try {
            File f = new File(DATA_DIR + "/dslcc4/DSL-TRAIN.txt");
            InputStream in = new FileInputStream(f);

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = reader.readLine()) != null) {
                int index = line.indexOf('\t');
                String sentence = line.substring(0, index);
                String lang = line.substring(index + 1);

                // collect sentences
                if (!map.containsKey(lang)) {
                    map.put(lang, new ArrayList<>());
                }
                map.get(lang).add(sentence);

                // unigrams
                if (lang.equals(PT_PT.getCode())) {
                    unigrams.count(sentence);
                    bigrams.count(sentence);
                    trigrams.count(sentence);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(map.size());

        for (String key : trigrams.getSortedKeys()) {
            System.out.println(key + "\t" + trigrams.getCounts().get(key));
        }

    }

}
