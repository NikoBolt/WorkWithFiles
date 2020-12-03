package com.company.Downloader;

public class main {
    public static void main(String[] args) {
        try {
            PropertiesReader prop = new PropertiesReader();
//            System.out.println("--" + prop.num + "--");

            int magicNumber = 7; // Сколько символов удалить,
                                // чтоб получить адрес файла без номера
            // 8 - если 1 папка и больше 100 файлов
            //          ries/001.jpg
            // 7 - если меньше 100 файлов
            //          ers/08.jpg


            if (prop.num.equals("1")) {
                System.out.println("6");
                String url1 = prop.site.substring(0, prop.site.length() - magicNumber) + "/";
                String filePreName = prop.folder + "/";
                System.out.println("скачиваю в " + filePreName);

                new Thread(new Downloader(prop.num, url1, filePreName,prop.pages)).start();
            }
            else
                new Manager(prop).run();
        }
        catch (NumberFormatException nfe) {
//            System.out.println("Ошибка в файле " + prop.PATH_TO_PROPERTIES);
            nfe.printStackTrace();
        }
    }
}