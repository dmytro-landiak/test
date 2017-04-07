package com.landim.lab2;

public class Word implements SentenceComponent {

    private String word;

    private Word() {}

    public static Word valueOf(String word) {

        if(word == null || word.isEmpty())
            throw new IllegalArgumentException("com.maxclay.lab2.Word can't be empty!");

        Word instance = new Word();
        instance.word = word;

        return instance;
    }

    @Override
    public String toString() {
        return this.word;
    }
}
