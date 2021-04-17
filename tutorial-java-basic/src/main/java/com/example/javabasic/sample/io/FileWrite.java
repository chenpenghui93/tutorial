package com.example.javabasic.sample.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2021-3-27
 */
public class FileWrite {

    private static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("d:/aaa.txt");
        writeFile(path, "hello world" + NEW_LINE);

        List<String> list = Arrays.asList("a", "b", "c");
        // Java 7
        Files.write(path, list, StandardCharsets.UTF_8);
        // Java 8
        Files.write(path, list);
        // Java 11
//        Files.writeString(path, "aaa");
//        Files.writeString(path, "aaa", StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    }

    private static void writeFile(Path path, String content) throws IOException {
        // 文件不存在，则创建、写入；存在则覆盖内容
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        // 文件不存在则创建、写入内容；文件存在时，在末尾添加内容
//        Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        // 文件不存在则抛出异常；存在则append
//        Files.write(path,content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }
}
