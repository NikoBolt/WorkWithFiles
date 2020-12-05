package com.company.Downloader;

public class Manager implements Runnable {

    int magicNumber = 8; // Сколько символов удалить,
            // чтоб получить адрес файла без номера
            //      // 8 - если 1 папка и больше 100 файлов
            // если папка не одна
            //  8 - номера папок < 10
            //  9 - > 10


    String site = "";   // Сайт с которого качать
    String folder = ""; // Папка в которую записывать
    int start = 1;      // Номер папки с которой начать
    int stop = 1;       // Номер папки на которой закончить
    String num = "";        // сколько всего папок

    public Manager(PropertiesReader prop) {
        site = prop.site;
        folder = prop.folder;
        start = prop.start;
        stop = prop.stop;
        int count = stop - start + 1;
        num = String.valueOf(count);
        if (count<10) magicNumber = 8;
        else magicNumber = 9;

        printLog.getInstance().setStop(1 + stop - start);
        System.out.println(prop.folder);
    }

    @Override
    public void run() {
        String url1 = site.substring(0, site.length() - magicNumber); // отрезаю конец от адреса
        String url2;
        String filePreName = "";

        if (stop < 10 ) { // Если номер папок меньше 10
            for (int i = start; i <= stop; i++) {

                url2 = url1 + i + "/";            // добавляю нужный конец адреса
                filePreName = folder + "№"+ i + "/";    // добавляю папку
                System.out.println("скачиваю в " + filePreName);
                new Thread(new Downloader(""+ i, url2, filePreName)).start();
            }
        } else if (stop < 100 ) {
            for (int i = start; i <= 9; i++) {
                url2 = url1 + "0" + i + "/";            // добавляю нужный конец адреса
                filePreName = folder + "№" + "0" + i + "/";    // добавляю папку
                new Thread(new Downloader("" + i, url2, filePreName)).start();
            }
            for (int i = 10; i <= stop; i++) {
                url2 = url1 + i + "/";            // добавляю нужный конец адреса
                filePreName = folder + "№"+ i + "/";    // добавляю папку
                new Thread(new Downloader("" + i, url2, filePreName)).start();
            }
        }
    }
}

// TODO: 23.02.2020 менеджер потоков