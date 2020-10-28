package com.company.TxtFile;

import java.io.*;
import java.util.HashMap;

public class main {

    // Читает файл,
    // заменяет номера на другие в нисходящем порядке,
    // удаляет ненужную информацию

    private static String path1 = "src\\com\\company\\TxtFile\\xxx2.txt";
    private static String path2 = "src\\com\\company\\TxtFile\\yyy.txt";
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException {
        BufferedWriter bufferedWriter = null;
        FileOutputStream outfile = new FileOutputStream(path2);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outfile));

        try {

            File file = new File(path1);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            HashMap<Integer, String[]> map = new HashMap();
            int key;
            String value[] = new String[2];

            while (line != null) {

                Integer key1 = Integer.parseInt(line);

                value[0] = bufferedReader.readLine();
                value[0] = bufferedReader.readLine();
                value[0] = bufferedReader.readLine();
                value[1] = bufferedReader.readLine();

                System.out.println(key1);
                System.out.println(value[0] + "\n" + value[1]);
                map.put(585 - key1, value);
                bufferedWriter.write("" + (585 - key1) + "\n" + value[0].replace(" - Россия 24", "") + "\n");

                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
