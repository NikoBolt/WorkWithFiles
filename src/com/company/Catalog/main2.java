package com.company.Catalog;

//import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class main2 {
    public static void main(String[] args) {
        String path1 = "U:\\1\\";       //path1 указывает на директорию c файлами
        String path2 = "src\\com\\company\\Catalog\\xxx.txt";   // Куда записывать

        String pre = "";

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
        ArrayList<String> files = new ArrayList<String>();

        for (File file : dir.listFiles()) {     // Проверяем содержимое папки
            if (file.isFile()){                 // Если это файл, то сохраняем в ArrayList
                files.add(file.getName());
            }
            if (!file.isFile()) {               // Если это папка, то рекурсия
                readDir(file, bufferedWriter, pre + file.getName() + "\\");
            }                                   // Выйдя имеем в файле всё содержимое папки
        }
        for (int i = 0; i < files.size(); i++) {    // и дописываем туда файлы
            bufferedWriter.write(pre + files.get(i) + "\n");
        }
    }
}
