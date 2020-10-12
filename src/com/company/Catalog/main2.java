package com.company.Catalog;

import java.io.*;
import java.util.ArrayList;

public class main2 {
    public static void main(String[] args) {
        String path1 = "M:\\1\\";       //path1 указывает на директорию c файлами
        String path2 = "src\\com\\company\\Catalog\\xxx.txt";   // Куда записывать

        String pre = "";

        ArrayList<String> name1 = new ArrayList<String>();
        File dir = new File(path1);
        try(FileOutputStream outfile = new FileOutputStream(path2)) {
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
        ArrayList<String> name1 = new ArrayList<String>();

        for (File file : dir.listFiles()) {
            if (file.isFile()){
                name1.add(file.getName());
            }
            if (!file.isFile()) {
                readDir(file, bufferedWriter, pre + file.getName() + "\\");
            }
        }
        for (int i = 0; i < name1.size(); i++) {
            bufferedWriter.write(pre + name1.get(i) + "\n");
        }
    }
}
