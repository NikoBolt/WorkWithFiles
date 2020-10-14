package com.company.Catalog;

public class ReadDirsTest {
    public static void main(String[] args) {
        String path1 = "M:\\1\\";       //path1 указывает на директорию c файлами
        String path2 = "src\\com\\company\\Catalog\\xxx.txt";   // Куда записывать

        ReadDirs rd3 = new ReadDirs(path1,path2,path1);
        System.out.println(rd3.toString());

        // Чтение директории в память
        // и запись из памяти в файл
        ReadDirs rd = new ReadDirs(path1,path2,path1);
        rd.readPackage();
        System.out.println(rd.toString());
        rd.writePaskage();

        // Чтение директории и запись в файл
        ReadDirs rd2 = new ReadDirs(path1,path2,path1);
        rd2.readWritePackage();
        System.out.println(rd2.toString()); // в памяти ничего нет


    }
}