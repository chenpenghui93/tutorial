package com.example.javabasic.sample.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @description: protobuf序列化、反序列化
 * @author: cph
 * @date: 2021/7/13 16:30
 */
public class ProtoBufTest {

    public static void main(String[] args) {

        try {

            List<String> dataList = new ArrayList<>();

            // 读取源文件获取数据list
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Yuanbao\\Downloads\\idfa_md5.csv"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                dataList.add(line);
            }

            // protobuf序列化
            FileOutputStream fos = new FileOutputStream("D:/devRepo/ziptest" + File.separator + "idfa.txt");
            dataList.forEach(t -> {
                DmpDataProto.DmpData.Builder dmpDataBuilder = DmpDataProto.DmpData.newBuilder();
                DmpDataProto.IdItem.Builder idItemBuilder = DmpDataProto.IdItem.newBuilder();
                idItemBuilder.setId(t);
                idItemBuilder.setDataType(DmpDataProto.IdItem.DataType.IDFA_MD5);
                idItemBuilder.addTags("已转人群");
                DmpDataProto.IdItem idItem = idItemBuilder.build();
                dmpDataBuilder.addIdList(idItem);
                DmpDataProto.DmpData dmpData = dmpDataBuilder.build();
                try {
                    fos.write(Base64.getEncoder().encode(dmpData.toByteArray()));
                    fos.write("\r\n".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fos.flush();
            fos.close();

            // 压缩成zip文件
            zipMultiFile("D:/devRepo/ziptest", "D:/devRepo/idfa.zip");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void zipMultiFile(String filePath, String zipPath) {
        try {
            File file = new File(filePath);
            File zipFile = new File(zipPath);
            InputStream input;
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    input = new FileInputStream(files[i]);
                    zipOut.putNextEntry(new ZipEntry(files[i].getName()));
                    int temp;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                    input.close();
                }
            }
            zipOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
