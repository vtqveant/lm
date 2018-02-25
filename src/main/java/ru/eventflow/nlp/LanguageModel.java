package ru.eventflow.nlp;

public interface LanguageModel {

    String UNK = "<unk>";
    String STOP = "<s>";
    String PAD = "<pad>";

    double getParameter(String ngram);

}
