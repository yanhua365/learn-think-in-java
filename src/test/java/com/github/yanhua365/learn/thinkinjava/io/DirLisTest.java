package com.github.yanhua365.learn.thinkinjava.io;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class DirLisTest {
    @Test
    public void canListFileInCurrentDir() {
        //可以列出当前目录下的文件
        List<String> list = Arrays.asList(new DirList().list());
       assertThat(list,hasItem("build.gradle"));
    }
}
