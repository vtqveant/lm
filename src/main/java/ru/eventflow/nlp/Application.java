package ru.eventflow.nlp;

import java.io.File;
import java.io.IOException;

public class Application {

    private static final String DATA_DIR = "/home/transcend/code/HALLUCINATE/lm/data";

    public static void main(String[] args) throws IOException {

        Processor processor = new Processor(Language.PT_PT);
        processor.process(new File(DATA_DIR + "/dslcc4/DSL-TRAIN.txt"));
        LanguageModel model = processor.buildLanguageModel();

        String s = "Dicionario";
        

//        for (String key : processor.getFourgrams().getKeys()) {
//            System.out.println(key + "\t" + processor.getFourgrams().getCounts().get(key));
//        }
    }

}
