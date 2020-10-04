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
        String path1 = "M:\\1\\";       //path1 указывает на директорию c файлами
        File dir = new File(path1);
        String path2 = "M:\\2\\";       //path2 куда будут перемещены переименованные файлы

        int start = 40;     // номер с которого начинается нумерация файлов
        int stop = 441;     // на какой номер переименовать
        int n = String.valueOf(stop).length(); // количество знаков в числе

        String name = "";   // имя текущего файла
        String st1 = "";    // номер текущего файла

        int k;  // номер нового файла
        int a;  // количество знаков в номере нового файла,
                // чтобы заполнить сколько надо до него нулями

        StringBuilder sb = new StringBuilder(); // собирает номер нового файла
        File newFile;                           // полное имя нового файла

        for ( File file : dir.listFiles()) {    // перебираем в папке все файлы и директории
            if ( file.isFile() ) {                  // если это файл, то работаем с ним. Директории не трогаем
                name = file.getName();              // имя текущего файла
                st1 = name.split(" ")[0];       // выделяем первые цифры
                k = start + stop - Integer.valueOf(st1);    // преобразуем в номер и вычисляем новый номер

                a = String.valueOf(k).length();         // измеряем длинну нового номера
                while (a++ < n) {                   // если новый номер будет короче
                    sb.append("0");             // дописываем нули пока все ровно не будет
                }
                sb.append(k);           // новый номер сформирован

                newFile = new File(path2 + name.replace(st1, sb)); // имя файла собираем заменой номера в имени старого файла

                if (file.renameTo(newFile)) {       // для контроля
                    System.out.println("Файл " + name + " перемещен успешно");
                } else {
                    System.out.println("Файл " + name + " не был перемещен");   // если файл там уже существовал
                }
                sb = new StringBuilder();   // обнуляем
            }
        }


    }
}
