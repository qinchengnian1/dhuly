package com.ecms.cums.utils.weixin;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class XmlUtils {

    public XmlUtils() {
    }

    public static Element getRootElement(String fileName) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
        return document.getRootElement();
    }

    public static Element getRootElementByXml(String xmlData) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new ByteArrayInputStream(xmlData.getBytes("utf-8")));
        return document.getRootElement();
    }

    public static List<Element> getElements(String fileName) throws Exception {
        return getElementsByRootElement(getRootElement(fileName));
    }

    private static List<Element> getElementsByRootElement(Element root) {
        return root.elements();
    }

    public static Map<String, String> xmlToStringMap(String xmlData) throws Exception {
        List<Element> elements = getElementsByRootElement(getRootElementByXml(xmlData));
        return (Map)elements.stream().collect(Collectors.toMap(Node::getName, Element::getStringValue));
    }

    public static Map<String, Object> xmlToObjMap(String xmlData) throws Exception {
        List<Element> elements = getElementsByRootElement(getRootElementByXml(xmlData));
        return (Map)elements.stream().collect(Collectors.toMap(Node::getName, Element::getData));
    }

    public static <T> String mapToXml(Map<String, T> params) {
        List<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        Iterator var4 = keys.iterator();

        while(var4.hasNext()) {
            String key = (String)var4.next();
            sb.append("<" + key + ">");
            sb.append("<![CDATA[" + params.get(key) + "]]>");
            sb.append("</" + key + ">");
        }

        sb.append("</xml>");
        return sb.toString().trim();
    }

}
