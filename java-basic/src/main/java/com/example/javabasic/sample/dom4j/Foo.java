package com.example.javabasic.sample.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Parsing XML
 * 1、从文件、url中读取xml数据至Document
 * 2、操作Document、Element、Attribute
 * 3、输出XML、HTML、DOM、SAX Events
 *
 * @author cph
 * @date 2019/11/8
 */
public class Foo {

    public static void main(String[] args) throws MalformedURLException, DocumentException {
        URL url = new URL("http://10.19.40.110:8080/wsdemo/services/CustMgrService?wsdl");
        System.out.println(parse(url).toString());
    }

    public static Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        Element element = document.getRootElement();

        //xml
        String str = document.asXML();

        return document;
    }

    public static Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");

        Element author1 = root.addElement("author")
                .addAttribute("name", "james")
                .addAttribute("location", "UK")
                .addText("111");

        Element author2 = root.addElement("author")
                .addAttribute("name", "jack")
                .addAttribute("location", "US")
                .addText("222");
        return document;
    }

    public static void write(Document document) throws IOException {
        //file
        XMLWriter writer = new XMLWriter(
                new FileWriter("output.xml")
        );
        writer.write(document);
        writer.close();

        //pretty
        OutputFormat format = new OutputFormat().createPrettyPrint();
        writer = new XMLWriter(System.out, format);
        writer.write(document);

        //compact
        format = new OutputFormat().createCompactFormat();
        writer = new XMLWriter(System.out, format);
        writer.write(document);
    }


}
