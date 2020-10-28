package com.company.TxtFile;

import java.io.*;
import java.util.HashMap;

public class main2 {
    // Читает файл,
    // заменяет номера на другие, на меньшее на 1,


    private static String path1 = "src\\com\\company\\TxtFile\\xxx.txt";
    private static String path2 = "src\\com\\company\\TxtFile\\yyy.txt";
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File(path1);
        BufferedWriter bufferedWriter = null;
        FileOutputStream outfile = new FileOutputStream(path2);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outfile));

        try /*(*//*FileInputStream fis = new FileInputStream(path1);*//* *//*FileOutputStream outfile = new FileOutputStream(path2);*//*)*/ {

            File file = new File(path1);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outfile));

            String line = bufferedReader.readLine();
//            HashMap<Integer, String[]> map = new HashMap();
//            int key;
//            String value[] = new String[2];

            while (line != null) {
//                System.out.println(line);
//                String key = line.split(" = ")[0];
                Integer key1 = Integer.parseInt(line);
//                String value = line.split(" = ")[1];
                line = bufferedReader.readLine();
//                value[0] = bufferedReader.readLine();
//                value[0] = bufferedReader.readLine();
//                value[0] = bufferedReader.readLine();
//                value[1] = bufferedReader.readLine();

//                System.out.println(key1);
//                System.out.println(value[0] + "\n" + value[1]);
//                map.put(585 - key1, value);
//                sb.append("" + (585 - key1) + "\n" + value[0].replace(" - Россия 24", "" + "\n"));
                // считываем остальные строки в цикле

//                bufferedWriter.write(sb.toString());
//                bufferedWriter.write("" + (585 - key1) + "\n" + value[0].replace(" - Россия 24", "") + "\n");

                System.out.println(key1);
                System.out.println(line);

                bufferedWriter.write("" + (key1-1) + "\n" + line + "\n");

                line = bufferedReader.readLine();
            }

//            361 - 224
//            360 - 225
//             1 - 584
//            2 - 583



//            System.out.println(sb);
//            bufferedWriter.flush();

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
