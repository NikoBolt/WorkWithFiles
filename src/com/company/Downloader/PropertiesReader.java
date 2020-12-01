package com.company.Downloader;

import java.io.*;
import java.util.HashMap;

public class PropertiesReader {
    //путь к нашему файлу конфигураций
    public static final String PATH_TO_PROPERTIES = "src/com/company/Downloader/config.properties";

    static String  site;
    static String  folder;
    static int start;
    static int stop;
    static int magicNumber;
    static int preNum;

    PropertiesReader () throws NumberFormatException {

//        FileInputStream fileInputStream;
        //инициализируем специальный объект Properties
        //типа Hashtable для удобной работы с данными
//        Properties prop = new Properties();

        try {

            File file = new File(PATH_TO_PROPERTIES);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            HashMap<String, String> map = new HashMap();
            while (line != null) {
                System.out.println(line);
                String key = line.split(" = ")[0];
                String value = line.split(" = ")[1];
                System.out.println(key);
                System.out.println(value);
                map.put(key, value);
                // считываем остальные строки в цикле
                line = bufferedReader.readLine();
            }

            site = map.get("site");
            folder = map.get("folder");
            start = Integer.parseInt(map.get("start"));
            stop = Integer.parseInt(map.get("stop"));
            magicNumber = Integer.parseInt(map.get("magicNumber"));
            preNum = Integer.parseInt(map.get("preNum"));

            printLog.getInstance().setStop(1+stop-start);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        }

    }
}
