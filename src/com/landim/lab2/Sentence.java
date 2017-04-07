package com.landim.lab2;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private List<SentenceComponent> sentenceComponents;

    public void setSentenceComponents(List<SentenceComponent> sentenceComponents) {
        this.sentenceComponents = sentenceComponents;
    }

    public List<SentenceComponent> getSentenceComponents() {
        return sentenceComponents;
    }

    public void addSentenceComponent(SentenceComponent sentenceComponent) {

        if(sentenceComponents == null)
            sentenceComponents = new ArrayList<>();

        sentenceComponents.add(sentenceComponent);
    }

    @Override
    public String toString() {

        if(sentenceComponents == null || sentenceComponents.isEmpty())
            return "";

        StringBuilder stringBuilder = new StringBuilder();
        for(SentenceComponent sentenceComponent : sentenceComponents)
            stringBuilder.append(sentenceComponent);


        return stringBuilder.toString();
    }
}
