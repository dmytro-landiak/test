package com.landim.lab2;


public class PunctuationMark implements SentenceComponent {

    public static final PunctuationMark DOT = new PunctuationMark('.');
    public static final PunctuationMark COMMA = new PunctuationMark(',');

    private char mark;

    private PunctuationMark(char mark) {
        this.mark = mark;
    }

    public static PunctuationMark valueOf(char mark) {

        return new PunctuationMark(mark);
    }

    public static PunctuationMark valueOf(String mark) {

        if(mark == null || mark.isEmpty())
            throw new IllegalArgumentException("Punctuation mark can't be empty!");

        if(mark.length() > 1)
            throw new IllegalArgumentException("Punctuation mark's size can't be greater than 1!");

        return new PunctuationMark(mark.charAt(0));
    }

    @Override
    public String toString() {

        return String.valueOf(this.mark);
    }
}
