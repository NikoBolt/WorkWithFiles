package com.company.Catalog;

public class ReadDirsTest {
    public static void main(String[] args) {
        String path1 = "U:\\1\\";       //path1 указывает на директорию c файлами
        String path2 = "src\\com\\company\\Catalog\\xxx.txt";   // Куда записывать

        new ReadDirs(path1,path2,path1);
    }
}
