package com.github.yanhua365.learn.thinkinjava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList {

    private final File dir;
    private final String pattern;

    public DirList(String dir) {
        this(new File(dir));
    }

    public DirList(File dir) {
        this(dir, ".*");
    }

    public DirList() {
        this(new File("."));
    }

    public DirList(File dir, String pattern) {
        this.dir = dir;
        this.pattern = pattern;
    }

    public DirList(String dir, String pattern) {
        this(new File(dir), pattern);
    }

    public String[] list() {
        return  dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Pattern p = Pattern.compile(pattern);
                return p.matcher(name).matches();
            }
        });
    }
}
