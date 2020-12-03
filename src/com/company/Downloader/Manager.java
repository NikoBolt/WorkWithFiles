package com.company.Downloader;

public class Manager implements Runnable {
//    PropertiesReader prop;

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
//    int preNum = 5;     // Сколько символов удалено
//    int preNum = 5;     // Сколько символов удалить с конца сайта
    String num = "";        // сколько всего папок

    public Manager(PropertiesReader prop) {
//        this.prop = prop;

        site = prop.site;
        folder = prop.folder;
        start = prop.start;
        stop = prop.stop;
//        preNum = prop.preNum;
        num = prop.num;

        printLog.getInstance().setStop(1 + stop - start);
        System.out.println(prop.folder);

        System.out.println("7");
    }

    @Override
    public void run() {
        System.out.println("8");

        String url1 = site.substring(0, site.length() - magicNumber); // отрезаю конец от адреса
        String url2;
        String filePreName = "";



        if (stop < 10 ) { // Если номер папок меньше 10
            for (int i = start; i <= stop; i++) {

                url2 = url1 + i + "/";            // добавляю нужный конец адреса
                filePreName = folder + "№"+ i + "/";    // добавляю папку
                System.out.println("скачиваю в " + filePreName);
                new Thread(new Downloader(""+ i, url2, filePreName)).start();
//                new Thread(new Downloader(String.valueOf(i), site, filePreName)).start();
            }
        } else if (stop < 100 ) {   // Если число папок больше 10, то придется дописывать нули

            System.out.println("9");

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
        System.out.println("10");
    }
}

// TODO: 23.02.2020 менеджер потоков