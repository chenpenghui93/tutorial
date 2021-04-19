package com.example.javabasic.sample.collection.conversion.xml2obj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cph
 * @date 2019/11/7
 */
public class RegTest {
    public static void main(String[] args) {
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ns:getCustByIDResponse xmlns:ns=\"http://ws.apache.org/axis2/samples/Cust/xsd/\">\n" +
                "         <ns:return>\n" +
                "            <age xmlns=\"http://webservice.primeton.com/xsd\">50</age>\n" +
                "            <custid xmlns=\"http://webservice.primeton.com/xsd\">1</custid>\n" +
                "            <name xmlns=\"http://webservice.primeton.com/xsd\">primeton1</name>\n" +
                "            <phone xmlns=\"http://webservice.primeton.com/xsd\">8008205821</phone>\n" +
                "            <sex xmlns=\"http://webservice.primeton.com/xsd\">男</sex>\n" +
                "         </ns:return>\n" +
                "      </ns:getCustByIDResponse>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        //splitXmlString(xml);

        int i = xml.indexOf("<ns:return>");
        int j = xml.indexOf("</ns:return>");
    }

    public static void splitXmlString(String data){
        data = data.toLowerCase();
        Pattern pattern=Pattern.compile("<ns:return>(.*?)</ns:return>");
        Matcher matcher=pattern.matcher(data);
        while(matcher.find()){
            int i = 1;
            String data1 =matcher.group(i);
            System.out.println(getParameter(data1, "custid"));
            System.out.println(getParameter(data1, "name"));
            System.out.println(getParameter(data1, "age"));
            System.out.println(getParameter(data1, "phone"));
        }
    }

    public static String getParameter(String data,String para)
    {
        String result="";
        StringBuffer reStr=new StringBuffer();
        reStr.append("<");
        reStr.append(para);
        reStr.append(">");
        reStr.append("(.*?)");
        reStr.append("</");
        reStr.append(para);
        reStr.append(">");
        Pattern pattern=Pattern.compile(reStr.toString());
        Matcher matcher=pattern.matcher(data);
        if(matcher.find())
        {
            result=matcher.group(1);
        }
        return result;
    }
}
