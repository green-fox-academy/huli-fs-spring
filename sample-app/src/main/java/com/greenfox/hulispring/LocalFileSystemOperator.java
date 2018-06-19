package com.greenfox.hulispring;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.nio.file.Files;


@Service
public class LocalFileSystemOperator {

    public static void main(String[] args) throws IOException {

    }


    public static void deleteFile(String path)
            throws IOException {
        Path newFilePath = Paths.get(path);
        Files.delete(newFilePath);
    }

    public static void createFile(String path)
            throws IOException {
        Path newFilePath = Paths.get(path);
        Files.createFile(newFilePath);
        System.out.println("file created at " + newFilePath.toString());
    }

    public static String readFile(String fileName)
            throws IOException {

        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeToFile(String string, String pathh) throws IOException {
        Path path = Paths.get(pathh);
        byte[] strToBytes = string.getBytes();
        Files.write(path, strToBytes);
    }

    public static void createDirectrory(String path) {
        Path newPath = Paths.get(path);
        if (!Files.exists(newPath)) {
            try {
                Files.createDirectories(newPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   private static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    public static boolean deleteDirectory(String path) {
        File file = new File(path);
        return deleteDirectory(file);
    }

    public static void moveDirectory(String pathFrom, String pathTo) {
        File fromDir = new File(pathFrom);
        File toDir = new File(pathTo);

        System.out.println(toDir.toPath().toString() + "  " + fromDir.toPath().toString());

        Path movefrom = FileSystems.getDefault().getPath(pathFrom);
        Path target = FileSystems.getDefault().getPath(pathTo);
        try {
            Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void moveFile(String pathFrom, String pathTo) {
        Path movefrom = FileSystems.getDefault().getPath(pathFrom );
        Path target = FileSystems.getDefault().getPath(pathTo);
        try {
            Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void copyFile(String pathFrom, String pathTo) {
        Path copyFrom = FileSystems.getDefault().getPath(pathFrom );
        Path target = FileSystems.getDefault().getPath(pathTo);
        try {
            Files.copy(copyFrom, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void copyDirectory(String pathFrom, String pathTo) {
        Path copyFrom = FileSystems.getDefault().getPath(pathFrom);
        Path target = FileSystems.getDefault().getPath(pathTo);
        try {
            Files.copy(copyFrom,target);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static List listDirectory(String thePath) throws IOException {
        List itemList = new List();
        Files.newDirectoryStream(Paths.get(thePath))
                .forEach(Path -> itemList.add(Path.toString()));
        return itemList;
    }

    public static boolean isDirectory(String path) {
        File file = new File(path);
        return file.isDirectory();
    }

    public static boolean isFile(String path) {
        File file = new File(path);
        return file.isFile();
    }

    public static void getStats(String path) throws IOException {
        Path file = Paths.get(path,"BasicFileAttributesExample.java");
        BasicFileAttributes basicAttr = Files.readAttributes(file, BasicFileAttributes.class);
    }
    /**
     * @author Greenfoxacademy
     * - Get item stats
     */
}
