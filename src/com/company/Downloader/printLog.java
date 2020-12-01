package com.company.Downloader;

public class printLog {

    private volatile static printLog uniaueInstance;

    private int start = 0;
    private int stop = 0;
    private int i = 0;

    private printLog() {}

    public static synchronized printLog getInstance() {
        if (uniaueInstance == null) {
            uniaueInstance = new printLog();
        }
        return uniaueInstance;
    }

    public void setStop(int stop){
        this.stop = stop;
    }

    public void logNext(){
        i++;
        System.out.println("Скачано: " + i + " из " + stop);
    }
    // Другие методы

}
