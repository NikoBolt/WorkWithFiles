package com.company.Catalog;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.BufferedWriter;
//import java.io.OutputStreamWriter;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;

public class ReadDirs {
    private String path = "";
    private String out = "";
    private String pre = "";
    private StringBuilder sb = new StringBuilder();

    public ReadDirs(String path, String out) {
        this.path = path;
        this.out = out;
        pre = path;
    }
    public ReadDirs(String path, String out, String pre) {
        this(path, out);
        this.pre = pre;
    }

    public String readPackage() {
        File dir = new File(path);
        try {
            readDir(dir, sb, pre);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void writePaskage() {
        try(FileOutputStream outfile = new FileOutputStream(out)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outfile));

            bufferedWriter.write(sb.toString());

            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWritePackage() {
        File dir = new File(path);
        try(FileOutputStream outfile = new FileOutputStream(out)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outfile));

            readDir(dir, bufferedWriter, pre);

            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Из файла в память
    private void readDir(File dir, StringBuilder sb, String pre) throws IOException {
        ArrayList<String> files = new ArrayList<String>();

        for (File file : dir.listFiles()) {     // Проверяем содержимое папки
            if (file.isFile()){                 // Если это файл, то сохраняем в ArrayList
                files.add(file.getName());
            }
            if (!file.isFile()) {               // Если это папка, то рекурсия
                readDir(file, sb, pre + file.getName() + "\\");
            }                                   // Выйдя имеем в файле всё содержимое папки
        }
        for (int i = 0; i < files.size(); i++) {    // и дописываем туда файлы
            sb.append(pre + files.get(i) + "\n");
        }
    }

    // из файла в файл
    private void readDir(File dir, BufferedWriter bufferedWriter, String pre) throws IOException {
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

    public String toString() {
        if (sb.toString().equals("")) return "Сначала надо прочитать содержимое директории";
        return sb.toString();
    }
}