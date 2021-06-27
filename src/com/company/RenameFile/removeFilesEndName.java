package com.company.RenameFile;

import java.io.File;

public class removeFilesEndName {
    public static void main(String[] args) {
        String path1 = "E:\\1\\";       //path1 указывает на директорию c файлами
        File dir = new File(path1);
        String path2 = "E:\\2\\";       //path2 куда будут перемещены переименованные файлы

        String name = "";   // имя текущего файла
        String target = " — Mozilla Firefox";   // что надо удалить из имени файла
        String replacement = "";   // на что заменить

        File newFile;                           // полное имя нового файла


        for ( File file : dir.listFiles()) {    // перебираем в папке все файлы и директории
            if ( file.isFile() ) {                  // если это файл, то работаем с ним. Директории не трогаем
                name = file.getName();              // имя текущего файла

                newFile = new File(path2 + name.replace(target, replacement)); // замена в имени нового файла

                if (file.renameTo(newFile)) {       // для контроля
                    System.out.println("+ Файл " + name + " переименован успешно");
                } else {
                    System.out.println("- - Файл " + name + " не был переименован");   // если файл там уже существовал
                }
            }
        }
    }
}
