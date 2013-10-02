package com.github.yanhua365.learn.thinkinjava.io;

import java.io.File;

public class DirList {

    public String[] list() {
        File path = new File(".");

        return  path.list();
    }
}
