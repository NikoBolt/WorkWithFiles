package com.company.RenameFile;

import java.io.File;
import java.util.HashMap;

public class main2 {

    // Замена имен файлов
    //  с 040.jpg - 441.jpg
    //    041.jpg - 440.jpg
    //    042.jpg - 439.jpg
    //    ...
    //    399.jpg - 82.jpg
    //    400.jpg - 81.jpg

    public static void main(String[] args) {
        String path1 = "M:\\1";     //path1 указывает на директорию c файлами
        String path2 = "M:\\2\\";   //path2 куда будут перемещены переименованные файлы

        int start = 40;     // номер с которого начинается нумерация файлов
        int stop = 100;     // на файле с каким номером закончить

        HashMap<Integer, File> map = new HashMap<Integer, File>();

        String st1 = "";
        String st2 = "";

        File dir = new File(path1);
        for ( File file : dir.listFiles()) {
            st1 = file.getName().substring(0, 3);
            if ( file.isFile() ) {
                map.put(Integer.valueOf(st1),file);
            }
        }

        for (int i = start; i < stop+1; i++) {
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

            File file = map.get(i);
            File newFile = new File(path2 + map.get(i).getName().replace(st1 , st2));

            System.out.println(map.get(i).getName());
            System.out.println(st1);
            System.out.println(st2);

            if (file.renameTo(newFile)) {
                System.out.println("Файл перемещен успешно");
            } else {
                System.out.println("Файл не был перемещен");
            }
        }
    }
}
