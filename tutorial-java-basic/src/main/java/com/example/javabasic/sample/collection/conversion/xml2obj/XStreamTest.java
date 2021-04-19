package com.example.javabasic.sample.collection.conversion.xml2obj;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;

/**
 * https://segmentfault.com/a/1190000012435867
 *
 * @author cph
 * @date 2019/11/7
 */
public class XStreamTest {
    public static void main(String[] args) {

        //bean to xml
        User user = new User(1, "zhangsan", "man");
        XStream xStream = new XStream();
        String xml = xStream.toXML(user);
        System.out.println(xml);
        System.out.println("-------------------");

        //xml to bean
        String xml1 = "<com.example.helloworld.convertxml.User>\n" +
                "  <id>1</id>\n" +
                "  <userName>zhangsan</userName>\n" +
                "  <sex>man</sex>\n" +
                "</com.example.helloworld.convertxml.User>";
        User user1 = (User)xStream.fromXML(xml1);
        System.out.println(user1.toString());
        System.out.println("-------------------");
        System.out.println(JSON.toJSONString(user1));

    }
}
