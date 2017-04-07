package com.landim.lab3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemXMLParser {

    private File file;

    public ItemXMLParser(String filename) {

        this.file = new File(filename);
    }

    public String parse() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(this.file);
        document.getDocumentElement().normalize();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n\"items\": [\n");
//        System.out.println("Root element :"
//            + document.getDocumentElement().getNodeName());

        NodeList nodeList = document.getElementsByTagName("item");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                stringBuilder.append("{\n\"name\":" + element.getElementsByTagName("name").item(0).getTextContent() + ",\n");
                stringBuilder.append("\"producer\":" + element.getElementsByTagName("producer").item(0).getTextContent() + ",\n");
                stringBuilder.append("\"price\":" + element.getElementsByTagName("price").item(0).getTextContent() + ",\n");
                stringBuilder.append("\"category-list\":");


//                System.out.println("Name : " + element.getElementsByTagName("name").item(0).getTextContent());
//                System.out.println("Producer : " + element.getElementsByTagName("producer").item(0).getTextContent());
//                System.out.println("Price : " + element.getElementsByTagName("price").item(0).getTextContent());


                List<String> categoriesNames = null;
                NodeList catagories = element.getElementsByTagName("category-list").item(0).getChildNodes();
                for(int j = 0; j < catagories.getLength(); j++) {
                    if (catagories.item(j).getNodeType() == Node.ELEMENT_NODE) {

                        if(categoriesNames == null) {
                            categoriesNames = new ArrayList<>();
                        }
                        categoriesNames.add(catagories.item(j).getTextContent());

                    }
                }

                String.join(",", new ArrayList<String>());

                stringBuilder.append((categoriesNames == null) ? "null" :
                        "[\n" + String.join(",", categoriesNames) + "\n]");

                stringBuilder.append("\n}");
                if(i + 1 < nodeList.getLength() && nodeList.item(i + 1).getNodeType() == Node.ELEMENT_NODE) {
                    stringBuilder.append(",\n");
                }
            }
        }

        stringBuilder.append("]\n}");

        return stringBuilder.toString();
    }
}
