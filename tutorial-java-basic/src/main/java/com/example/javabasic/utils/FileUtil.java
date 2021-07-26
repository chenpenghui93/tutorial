package com.example.javabasic.utils;

import java.io.*;
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
     * 将指定文件夹下的内容压缩为zip文件
     *
     * @param filePath    待压缩文件目录 "/tmp/before-zip/"
     * @param zipPath     压缩后文件目录 "/tmp/after-zip/"
     * @param zipFileName 文件名 "xxx.zip"
     * @return
     */
    public static String zipMultiFile(String filePath, String zipPath, String zipFileName) {
        File zipFile = null;
        try {
            File fileDir = new File(filePath);
            File zipDir = new File(zipPath);
            if (!zipDir.exists()) {
                zipDir.mkdirs();
            }
            zipFile = new File(zipDir, zipFileName);
            InputStream input;
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            if (fileDir.exists()) {
                File[] files = fileDir.listFiles();
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
//            log.error("FileUtil#zipMultiFile异常: {}", e.getMessage(), e);
        }
        return zipFile.getAbsolutePath();
    }


    /**
     * 将指定目录下的文件分别压缩成zip文件
     *
     * @param filePath
     * @param zipPath
     * @param originalName
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
//            log.error("FileUtil#zipSeparateFile异常: {}", e.getMessage(), e);
        }
        return pathList;
    }

    /**
     * 将大文件分割成指定大小的小文件
     *
     * @param file
     * @param outputPath
     * @param size
     * @return
     */
    public static List<String> splitFile(File file, String outputPath, long size) {
        if (!file.exists() || !file.isFile()) {
//            log.error(file.getAbsolutePath() + " 指定文件不存在！");
            throw new RuntimeException(file.getAbsolutePath() + " 指定文件不存在！");
        }
        File zipFileDir = new File(outputPath);
        if (!zipFileDir.exists()) {
            zipFileDir.mkdirs();
        }
        // 文件大小(Byte)
        long fileLength = file.length();
        // 切分文件个数
        int num = fileLength % size != 0 ? (int) (fileLength / size + 1) : (int) (fileLength / size);
        List<String> nameList = new ArrayList<>(num);
        try {
            FileInputStream in = new FileInputStream(file);
            long begin = 0;
            long end = 0;
            for (int i = 0; i < num; i++) {
                File outFile = new File(zipFileDir, file.getName() + i + ".txt");
                FileOutputStream out = new FileOutputStream(outFile);
                // 前 num-1 个文件大小指定为size，最后一个文件按实际大小写入
                end += size;
                end = end > fileLength ? fileLength : end;
                for (; begin < end; begin++) {
                    out.write(in.read());
                }
                out.close();
                nameList.add(outFile.getAbsolutePath());
            }
            in.close();
        } catch (IOException e) {
//            log.error("切分文件出现异常: {}", e.getMessage(), e);
            throw new RuntimeException("切分文件出现异常" + e.getMessage());
        }
        return nameList;
    }

    /**
     * 删除目录及文件(含子级)
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
            // 删除文件夹后结束当前递归调用
            return;
        }
        file.delete();
    }


}
