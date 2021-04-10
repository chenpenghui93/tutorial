package com.example.javabasic.sample.io;

import java.io.File;
import java.io.IOException;

/**
 * @author cph
 */
public class Example {
    public static void main(String[] args) {
//        createFile();
//        absoluteFilePath();
//        workingDirectory();
//        filePermission();



    }

    private static void filePermission() {
        try {
            File file = new File("D:\\shellscript.sh");

            if (file.exists()) {
                System.out.println("Exectue? " + file.canExecute());
                System.out.println("Write? " + file.canWrite());
                System.out.println("Read? " + file.canRead());
            }

            file.setExecutable(false);
            file.setWritable(false);
            file.setReadable(false);

            System.out.println("Exectue? " + file.canExecute());
            System.out.println("Write? " + file.canWrite());
            System.out.println("Read? " + file.canRead());

            if (file.createNewFile()) {
                System.out.println("file is created.");
            } else {
                System.out.println("file is already existed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void workingDirectory() {
        String filename = "newFile2.txt";
        String workingDirectory = System.getProperty("user.dir");

        File file = new File(workingDirectory, filename);

        System.out.println("final path: " + file.getAbsolutePath());

        try {
            if (file.createNewFile()) {
                System.out.println("file is created.");
            } else {
                System.out.println("file is already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void absoluteFilePath() {
        String filename = "newFile1.txt";
        String workingDirectory = System.getProperty("user.dir");

        String absoluteFilePath = "";
//        absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
        absoluteFilePath = workingDirectory + File.separator + filename;
        System.out.println("final path: " + absoluteFilePath);

        File file = new File(absoluteFilePath);
        try {
            if (file.createNewFile()) {
                System.out.println("File is created.");
            } else {
                System.out.println("File is already existed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile() {
        try {
            File file = new File("D:\\newFile.txt");
            if (file.createNewFile()) {
                System.out.println("file created.");
            } else {
                System.out.println("file already exists.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
