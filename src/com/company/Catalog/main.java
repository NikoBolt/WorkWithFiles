package com.company.Catalog;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        String path1 = "M:\\1\\";       //path1 указывает на директорию c файлами
        File dir = new File(path1);

        String pre = "";
        ArrayList<String> name1 = new ArrayList<String>();

//        FileOutputStream outfile = new FileOutputStream("xxx.txt");


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
