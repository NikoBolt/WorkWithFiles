package com.company.Catalog;

//import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String path1 = "M:\\1\\";       //path1 указывает на директорию c файлами
        File dir = new File(path1);

        String pre = "";

        try(FileOutputStream outfile = new FileOutputStream("src\\com\\company\\Catalog\\xxx.txt")) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outfile));

            readDir(dir, bufferedWriter, pre);

            bufferedWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDir(File dir, BufferedWriter bufferedWriter, String pre) throws IOException {
        for (File file : dir.listFiles()) {
            bufferedWriter.write(pre + file.getName() + "\n");
            if (!file.isFile()) {
                readDir(file, bufferedWriter, pre + file.getName() + "\\");
            }
        }
    }
}
