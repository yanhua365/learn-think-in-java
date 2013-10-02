package com.github.yanhua365.learn.thinkinjava.io;

import java.io.File;

public class DirList {

    private final File dir;

    public DirList(String dir) {
        this.dir = new File(dir);
    }

    public DirList(File dir) {
        this.dir = dir;
    }

    public DirList() {
        this.dir = new File(".");
    }

    public String[] list() {
        return  dir.list();
    }
}
