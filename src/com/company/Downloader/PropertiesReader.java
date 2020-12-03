package com.company.Downloader;

import java.io.*;
import java.util.HashMap;

public class PropertiesReader {
    //путь к нашему файлу конфигураций
    private static final String PATH_TO_PROPERTIES = "src/com/company/Downloader/config.properties";
    private String path = PATH_TO_PROPERTIES;

    static String  site;
    static String  folder;
    static int start;
    static int stop;
    static String num;
    static int pages;

    PropertiesReader() throws NumberFormatException {
        read();
    }

    PropertiesReader(String path_to_prorerties) throws NumberFormatException {
        path = path_to_prorerties;
        read();
    }

    private void read (){
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            HashMap<String, String> map = new HashMap();
            while (line != null) {
                String key = line.split(" = ")[0];
                String value = line.split(" = ")[1];
                System.out.println(key + " = " + value);

                map.put(key, value);
                // считываем остальные строки в цикле
                line = bufferedReader.readLine();
            }

            site = map.get("site");
            folder = map.get("folder");
            start = Integer.parseInt(map.get("start"));
            stop = Integer.parseInt(map.get("stop"));
//            preNum = Integer.parseInt(map.get("preNum"));
            num = map.get("num");
            pages = Integer.parseInt(map.get("pages"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + path + " не обнаружен");
            e.printStackTrace();
        }
    }
}
