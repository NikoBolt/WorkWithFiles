package com.company.RenameFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class main {

    // Замена имен файлов
    //  с 001.jpg - 480.jpg
    //    002.jpg - 479.jpg
    //    ...
    //    399.jpg - 82.jpg
    //    400.jpg - 81.jpg

    public static void main(String[] args) {
        String path1 = "C:\\Path\\1\\"; //path1 указывает на директорию c файлами
        String path2 = "C:\\Path\\2\\"; //path2 куда будут перемещены переименованные файлы

        File dir = new File(path1);
        List<File> lst = new ArrayList<>();
        for ( File file : dir.listFiles() ){
            if ( file.isFile() )
                lst.add(file);
        }

        File file;
        File newFile;
        String st1 = "";
        String st2 = "";

        // имена файлов начинаются с 001 и заканчиваются 400
        for (int i = 1; i < 401; i++) {
            if (i<10) {
                st1 = "00" + i;
                st2 = "" + (481 - i);
            } else if (i<100) {
                st1 = "0" + i;
                st2 = "" + (481 - i);
            } else if (i < 1000) {
                st1 = "" + i;
                st2 = "" + (481 - i);
            }

            // в lst нумерация начинается с 0
            file = lst.get(i-1);
            newFile = new File(path2 + lst.get(i-1).getName().toString().replace(st1 , st2));

            System.out.println(lst.get(i-1).getName());

            if (file.renameTo(newFile)) {
                System.out.println("Файл перемещен успешно");
            } else {
                System.out.println("Файл не был перемещен");
            }
        }
    }
}
