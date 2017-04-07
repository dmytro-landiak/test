package com.landim.lab2;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private List<Sentence> sentences;

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void addSentence(Sentence sentence) {

        if(sentences == null)
            sentences = new ArrayList<>();

        sentences.add(sentence);
    }

    public static Text valueOf(String text) {

        if(text == null || text.isEmpty())
            throw new IllegalArgumentException("com.landim.lab2.Text can't be empty!");

        Text textToReturn = new Text();
        for(String stringSentence : text.split("[\\\\p{Punct}\\\\s]+")) {

            Sentence sentence = new Sentence();
            for(String stringComponent : stringSentence.split(" ")) {

                //TODO change it
                if(",".equals(stringComponent) || ";".equals(stringComponent)) {

                    sentence.addSentenceComponent(PunctuationMark.valueOf(stringComponent));
                } else {

                   sentence.addSentenceComponent(Word.valueOf(stringComponent));
                }
            }

            sentence.addSentenceComponent(PunctuationMark.valueOf('.'));
            textToReturn.addSentence(sentence);
        }

        return textToReturn;
    }

    @Override
    public String toString() {

        if(sentences == null || sentences.isEmpty())
            return "";

        StringBuilder stringBuilder = new StringBuilder();
        for(Sentence sentence : sentences) {
            stringBuilder.append(sentence);
            stringBuilder.append(" ");
        }

            return stringBuilder.toString();
    }
}
