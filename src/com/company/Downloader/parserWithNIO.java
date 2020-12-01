package com.company.Downloader;

public class parserWithNIO {
    public static void main(String[] args) {
        try {
            PropertiesReader prop = new PropertiesReader();

            System.out.println(prop.folder);

            if (prop.preNum == 6) {
                new Thread(new Downloader(String.valueOf(-1), prop.site, prop.folder, prop.magicNumber)).start();
            } else {

                for (int i = prop.start; i <= prop.stop; i++) {

                    if (prop.preNum == 8) {
                        if (i < 10)
                            new Thread(new Downloader(String.valueOf(i), prop.site, prop.folder, prop.magicNumber)).start();
                    }
                    if (prop.preNum == 9) {
                        if (i < 10)
                            new Thread(new Downloader("0" + String.valueOf(i), prop.site, prop.folder, prop.magicNumber)).start();
                        else
                            new Thread(new Downloader(String.valueOf(i), prop.site, prop.folder, prop.magicNumber)).start();
                    }
                }
            }
        } catch (NumberFormatException nfe) {
//            System.out.println("Ошибка в файле " + prop.PATH_TO_PROPERTIES);
            nfe.printStackTrace();
        }
    }
}

// TODO: 23.02.2020 менеджер потоков
