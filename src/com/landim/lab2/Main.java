package com.landim.lab2;

import com.landim.lab2.Text;

public class Main {

    public static final String DEFAULT_STRING = "Soaaaaaaame some saaaatr string strict restrict";

    public static void run() {

//        com.maxclay.lab2.Sentence firstSentence = new com.maxclay.lab2.Sentence();
//        firstSentence.addSentenceComponent(com.maxclay.lab2.Word.valueOf("Hello"));
//        firstSentence.addSentenceComponent(com.maxclay.lab2.PunctuationMark.valueOf(','));
//        firstSentence.addSentenceComponent(com.maxclay.lab2.Word.valueOf(" World"));
//        firstSentence.addSentenceComponent(com.maxclay.lab2.PunctuationMark.valueOf('!'));
//
//        com.maxclay.lab2.Sentence secondSentence = new com.maxclay.lab2.Sentence();
//        secondSentence.addSentenceComponent(com.maxclay.lab2.Word.valueOf("Hello"));
//        secondSentence.addSentenceComponent(com.maxclay.lab2.PunctuationMark.valueOf(','));
//        secondSentence.addSentenceComponent(com.maxclay.lab2.Word.valueOf(" cruel"));
//        secondSentence.addSentenceComponent(com.maxclay.lab2.Word.valueOf(" world"));
//        secondSentence.addSentenceComponent(com.maxclay.lab2.PunctuationMark.valueOf('!'));
//
        Text text = Text.valueOf("Hello, World");
        System.out.println(text);

    }

    /**
     * Finds amount of string occurrences.
     * @param toFind - string to find.
     * @param findIn - string in which searching performs.
     * @return amount of occurrences.
     */
    public static int substringOccurrences(String toFind, String findIn) {

        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = findIn.indexOf(toFind,lastIndex);
            if(lastIndex != -1){

                count ++;
                lastIndex ++;//= toFind.length();
            }
        }

        return count;
    }

    /**
     * Checks if the passed string is palindrome.
     * @param arg - string to check.
     * @return 'true' if string is palindrome, otherwise - 'false'.
     */
    public static boolean isPalindrome(String arg) {

        if(arg == null)
            throw new IllegalArgumentException("String must not be null");

        return arg.toLowerCase().equals(new StringBuilder(arg.toLowerCase()).reverse().toString());

    }
}
