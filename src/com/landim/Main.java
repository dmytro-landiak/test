package com.landim;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static final String VERSION_KEYWORD = "version";
    public static final String COMMENT_STARTS_KEYWORD = "<!--";
    public static final String COMMENT_ENDS_KEYWORD = "-->";

    public static final Map<String, String> SPECIAL_CHARACTERS_MAP;

    static {

        Map<String, String> specialCharactersMap = new HashMap<>();
        specialCharactersMap.put("&quot;", "\"");
        specialCharactersMap.put("&amp;", "&");
        specialCharactersMap.put("&apos;", "'");
        specialCharactersMap.put("&lt;", "<");
        specialCharactersMap.put("&gt;", ">");


        SPECIAL_CHARACTERS_MAP = Collections.unmodifiableMap(specialCharactersMap);
    }

    public static void main(String[] args) throws IOException {

        String xmlInString = readFile("items.xml");
////        System.out.println("Version: " + findVersion(xmlInString));
////
////        System.out.println("Amount of comments: " + commentsAmount(xmlInString));
//        List<String> elements = findTextElements(xmlInString);
//        System.out.println("Amount: " + elements.size());
//        elements.stream().forEach(System.out::println);

        List<String> namespaces = findNamespaces(xmlInString);
        namespaces.stream().forEach(System.out::println);


    }

    public static List<String> findNamespaces(String xmlInString) {

        List<String> namespaces = new ArrayList<>();
        int position = 0;
        while (position < xmlInString.length()) {
            int namespaceStarts = xmlInString.indexOf("xmlns", position);
            if(namespaceStarts == -1) {
                return namespaces;
            }

            position = namespaceStarts;
            position = xmlInString.indexOf("=\"", position);


            int namespaceEnds = xmlInString.indexOf("\"", position  + 2);
            if(namespaceEnds == -1) {
                return namespaces;
            }
            position = namespaceEnds;



            namespaces.add(xmlInString.substring(namespaceStarts, namespaceEnds).replace("=\"", " : "));

        }

        return namespaces;
    }

    public static List<String> findTextElements(String xmlInString) {

        List<String> elements = new ArrayList<>();

//        Pattern pattern = Pattern.compile(">(.*)<");
        String regexString = Pattern.quote(">") + "(.*)" + Pattern.quote("</");
        Pattern pattern = Pattern.compile(regexString);

        Matcher matcher = pattern.matcher(xmlInString);
        while (matcher.find()) {
            if(!commented(matcher, xmlInString)) {

                String textElement = matcher.group(1);
//                textElement = textElement.substring(1, textElement.length() - 1);
                for(String key: SPECIAL_CHARACTERS_MAP.keySet()) {
                    textElement = textElement.replace(key, SPECIAL_CHARACTERS_MAP.get(key));
                }

                elements.add(textElement);
            }
        }

        return elements;
    }

    public static boolean commented(Matcher matcher, String xmlInString) {

        int position = 0;
        while (position < xmlInString.length()) {
            int commentStarts = xmlInString.indexOf(COMMENT_STARTS_KEYWORD, position);
            if (commentStarts == -1) {
                return false;
            }

            position = commentStarts;
            int commentEnds = xmlInString.indexOf(COMMENT_ENDS_KEYWORD, position);
            if (commentEnds == -1) {
                return false;
            }

            position = commentEnds;
            if(matcher.start() >= commentStarts && matcher.end() <= commentEnds) {
                return true;
            }
        }

        return false;
    }

    public static String findVersion(String xmlInString) {
        int versionStarts = xmlInString.indexOf(VERSION_KEYWORD) + VERSION_KEYWORD.length() + 2;
        int versionEnds = xmlInString.indexOf("\"", versionStarts);
        return xmlInString.substring(versionStarts, versionEnds);
    }

    public static int commentsAmount(String xmlInString) {

        int amount = 0;
        int position = 0;
        while (position < xmlInString.length()) {
            int commentStarts = xmlInString.indexOf(COMMENT_STARTS_KEYWORD, position);
            if (commentStarts == -1) {
                return amount;
            }

            position = commentStarts;
            int commentEnds = xmlInString.indexOf(COMMENT_ENDS_KEYWORD, position);
            if (commentEnds == -1) {
                return amount;
            }

            position = commentEnds;
            amount++;
        }

        return amount;
    }

    public static String readFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return new String(bytes);
    }
}
