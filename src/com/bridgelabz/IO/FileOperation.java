package com.bridgelabz.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileOperations {
    public static void main(String[] args){

        try {
            File file = new File("D:\\GitProgram\\Day27_IO\\src\\main\\java\\com\\bridgelabz\\myFile.txt");
            file.createNewFile();
            System.out.println("Does File Exists : " + file.exists());

            file.delete();
            System.out.println("Does File Exists : " + file.exists());

            Files.list(Path.of("C:\\Users\\Lenovo\\IdeaProjects\\javaIO\\src\\com\\bridgelabz\\IO")).filter(Files::isRegularFile).forEach(System.out::println);

            new File("C:\\Users\\Lenovo\\IdeaProjects\\javaIO\\src\\com\\bridgelabz\\IO\\EmployeePayroll").mkdir();
        } catch (IOException e) {
            System.out.println("Some Error");
        }
    }
}