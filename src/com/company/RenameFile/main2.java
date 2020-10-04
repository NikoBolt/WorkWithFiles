package com.company.RenameFile;

import java.io.File;

public class main2 {

    // Замена имен файлов
    //  с 040.jpg - 441.jpg
    //    041.jpg - 440.jpg
    //    042.jpg - 439.jpg
    //    ...
    //    399.jpg - 82.jpg
    //    400.jpg - 81.jpg
    //    ...
    //    399.jpg - 82.jpg
    //    480.jpg - 001.jpg

    public static void main(String[] args) {
        String path1 = "M:\\1";     //path1 указывает на директорию c файлами
        String path2 = "M:\\2\\";   //path2 куда будут перемещены переименованные файлы

        int start = 40;     // номер с которого начинается нумерация файлов
//        int stop = 480;     // на файле с каким номером закончить
        int stop = 441;     // на файле с каким номером закончить

//        int first = 40;
        int newFirst = 441;
//        int n1 = String.valueOf(start).length();
//        int n2 = String.valueOf(stop).length();
//        int n1 = 3; // количество знаков в числе
        int n = String.valueOf(newFirst).length();

        int a;

        String st1 = "";
        String st2 = "";
        String name = "";

        StringBuilder sb = new StringBuilder();


        File dir = new File(path1);
        File newFile;

        for ( File file : dir.listFiles()) {
            name = file.getName();
            st1 = name.split(" ")[0];

            int k = start + stop - Integer.valueOf(st1);

            if ( file.isFile() ) {
                System.out.println(st1);
                a = String.valueOf(k).length();
                while (a++ < n) {
                    sb.append("0");
                }
                sb.append(k);

//                st2 = String.valueOf(start + stop - Integer.valueOf(st1));
                System.out.println(sb);

                newFile = new File(path2 + name.replace(st1, sb));

                if (file.renameTo(newFile)) {
                    System.out.println("Файл " + name + " перемещен успешно");
                } else {
                    System.out.println("Файл " + name + " не был перемещен");
                }
            }
            sb = new StringBuilder();
        }

    }
}
