package com.company.Downloader;

import java.util.ArrayList;

public class printLog {

    private volatile static printLog uniaueInstance;

    private int start = 0;
    private int stop = 0;
    private int i = 0;
//    private ArrayList arr;
    private int[] arr ;

    private printLog() {}

    public static synchronized printLog getInstance() {
        if (uniaueInstance == null) {
            uniaueInstance = new printLog();
        }
        return uniaueInstance;
    }

    public void setStop(int stop){
        this.stop = stop;
//        arr = new ArrayList();
        arr = new int[stop];
        for (int i = 0; i == stop; i++){
//            arr(i) = 1;
            arr[i] = 3;
        }
        System.out.println("arr size = " + arr.length);
        System.out.println("\n----");
        for (int k = 0; k < arr.length; k++) {
            System.out.print("[" + arr[k] + "]");
        }
        System.out.println("\n----");
    }

    public void logNext(){
        i++;
        System.out.println("Скачано: " + i + " из " + stop);
//        System.out.println("\n----");
//        for (int k = 0; k < arr.length; k++) {
//            System.out.print("[" + arr[k] + "]");
//        }
//        System.out.println("\n----");
    }
    // Другие методы

    public void setDone(int j) {
        arr[j] = 1;
    }
    public void printDone() {
//        System.out.println("[");
//        for (int k = 0; k < arr.length; k++)
//        System.out.print("[" + arr[k] + "]");
//        System.out.println("----");
    }
}


// todo: прикрути набдюдателя