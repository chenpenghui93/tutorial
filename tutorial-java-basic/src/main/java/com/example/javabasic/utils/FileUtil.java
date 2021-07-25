package com.example.javabasic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @description: 文件处理工具类
 * @author: cph
 * @date: 2021-7-19 23:13
 */
public class FileUtil {

    /**
     * 将指定目录下的文件分别压缩为zip文件
     *
     * @param filePath     "D:/tmp/1/"
     * @param zipPath      "D:/tmp/2/"
     * @param originalName "test.zip"
     * @return
     */
    public static List<String> zipSeparateFile(String filePath, String zipPath, String originalName) {
        List<String> pathList = new ArrayList<>();
        try {
            File fileDir = new File(filePath);
            File zipDir = new File(zipPath);
            if (!zipDir.exists()) {
                zipDir.mkdirs();
            }
            String fileName = originalName.substring(0, originalName.lastIndexOf("."));
            InputStream input;
            if (fileDir.exists()) {
                File[] files = fileDir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    String zipFileName = fileName + i + ".zip";
                    File zipFile = new File(zipDir, zipFileName);
                    ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
                    input = new FileInputStream(files[i]);
                    zipOut.putNextEntry(new ZipEntry(files[i].getName()));
                    int temp;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                    input.close();
                    zipOut.close();
                    pathList.add(zipPath + zipFileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathList;
    }

    /**
     * 删除目录/文件及其子级
     *
     * @param file
     */
    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    f.delete();
                } else if (f.isDirectory()) {
                    deleteFile(f);
                }
            }
            file.delete();
        }
        file.delete();
    }

    /**
     * 分割文件
     *
     * @param originalFilePath
     * @param zipFilePath
     * @param size
     * @return
     * @throws Exception
     */
    public static List<String> splitFile(String originalFilePath, String zipFilePath, long size) throws Exception {
        File originalFile = new File(originalFilePath);
        if (!originalFile.exists() || !originalFile.isFile()) {
            throw new RuntimeException(originalFilePath + " 指定文件不存在！");
        }
        File zipFileDir = new File(zipFilePath);
        if (!zipFileDir.exists()) {
            zipFileDir.mkdirs();
        }
        // 文件大小,单位Byte
        long fileLength = originalFile.length();
        // 切分文件个数
        int num = fileLength % size != 0 ? (int) (fileLength / size + 1) : (int) (fileLength / size);
        List<String> nameList = new ArrayList<>(num);
        FileInputStream in = new FileInputStream(originalFile);
        int begin = 0;
        long end = 0;
        for (int i = 0; i < num; i++) {
            File outFile = new File(zipFileDir, originalFile.getName() + i + ".txt");
            FileOutputStream out = new FileOutputStream(outFile);
            // 前num-1个文件大小指定为size，最后一个文件按实际大小写入
            end += size;
            end = end > fileLength ? fileLength : end;
            for (; begin < end; begin++) {
                out.write(in.read());
            }
            out.close();
            nameList.add(outFile.getAbsolutePath());
        }
        in.close();
        return nameList;
    }


}
