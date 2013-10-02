package com.github.yanhua365.learn.thinkinjava.io;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class DirLisTest {
    @Test
    public void canListFileInCurrentDir() {
        List<String> list = Arrays.asList(new DirList().list());
       assertThat(list,hasItem("build.gradle"));
    }
}
