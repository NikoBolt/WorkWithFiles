package com.company.Downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader implements Runnable {
    private int stop = 99;
    private String num;
//    int num;      // int не подходит, т.к. может быть равен "01"..."059"
    private String url0;
    private String dest;
    private int count = 1;

    private String url;
    private String filename;

    public Downloader(String num, String url0, String dest){
        this.num = num;
        this.url0 = url0;
        this.dest = dest;
    }

    public Downloader(String num, String url0, String dest, int stop){
        this(num, url0, dest);
        this.stop = stop;
    }

    @Override
    public void run() {

        new File(dest).mkdirs();

        if (stop < 10) {
            for1(url0, dest, stop);
        } else {
            if (stop < 100) {
                for1(url0 + "0", dest + "0", 9);
                for1(url0, dest, stop);
            } else {
                if (stop < 1000) {
                    for1(url0 + "00", dest + "00", 9);
                    for1(url0 + "0", dest + "0", 99);
                    for1(url0, dest, stop);
                }
            }
        }
    }

    private void for1(String url1, String dest, int stop){
        try {
            for (; count <= stop; count++) {
                    url = url1 + count + ".jpg";
                    filename = dest + count + ".jpg";
                downloadUsingNIO(url, filename);
                    System.out.println(num + " - " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("\n=> скачал: " + num + "\n");
//            printLog.getInstance().logNext();
//            printLog.getInstance().setDone(Integer.getInteger(num));
//            printLog.getInstance().printDone();
//            System.out.println("======");
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


