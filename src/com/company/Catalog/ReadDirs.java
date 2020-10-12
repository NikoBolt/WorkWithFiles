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
    public ReadDirs(String path, String out) {
        File dir = new File(path);
        try(FileOutputStream outfile = new FileOutputStream(out)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outfile));
            readDir(dir, bufferedWriter, "");
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ReadDirs(String path, String out, String pre) {
        pre = path;
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
}
