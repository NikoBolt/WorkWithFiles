package com.company.Downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader implements Runnable {
    int stop = 100;
    String num;
    String url0;
    String dest;

    int magicNumber;

    public Downloader(String num, String url0, String dest, int magicNumber){
        this.num = num;
        this.url0 = url0;
        this.dest = dest;
        this.magicNumber = magicNumber;
    }

    @Override
    public void run() {
        System.out.println(dest + 1);
        if (num.equals("-1")){
            new File(dest).mkdirs();
            String url;
            String filename;

            try {
                for (int i = 1; i <= 9; i++) {
                    url = url0 + "0" + i + ".jpg";
                    filename = dest + "0" + i + ".jpg";
                    System.out.println(dest + 2);
                    downloadUsingNIO(url, filename);
                    System.out.println(num + " - " + i);
                }
                for (int i = 10; i <= stop; i++) {
                    url = url0 + i + ".jpg";
                    filename = dest + i + ".jpg";
                    downloadUsingNIO(url, filename);
                    System.out.println(num + " - " + i);
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("\n=> скачал: " + num + "\n");
                printLog.getInstance().logNext();
            }
        } else {
            String url1 = url0 + /*"0" +*/ num + "/";

            String filePreName = dest + "№"+ (Integer.parseInt(num) + magicNumber) + "/";
//        String filePreName =  dest + (Integer.parseInt(num) + " Параллели " + num + "-5" ) + "/";
            new File(filePreName).mkdirs();
            String url;
            String filename;

            try {
                for (int i = 1; i <= 9; i++) {
                    url = url1 + "0" + i + ".jpg";
                    filename = filePreName + "0" + i + ".jpg";
                    downloadUsingNIO(url, filename);
                    System.out.println(num + " - " + i);
                }
                for (int i = 10; i <= stop; i++) {
                    url = url1 + i + ".jpg";
                    filename = filePreName + i + ".jpg";
                    downloadUsingNIO(url, filename);
                    System.out.println(num + " - " + i);
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("\n=> скачал: " + num + "\n");
                printLog.getInstance().logNext();
            }
        }
    }
    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
}


