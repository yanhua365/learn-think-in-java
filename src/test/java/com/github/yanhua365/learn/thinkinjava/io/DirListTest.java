package com.github.yanhua365.learn.thinkinjava.io;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class DirListTest {
    @Test
    public void shouldListFilsInCurrentDirWithNoDir() {
        List<String> list = Arrays.asList(new DirList().list());
        assertThat(list,hasItem("build.gradle"));
    }

    @Test
    public void shouldListFilsInTheDir() {
        List<String> list = Arrays.asList(new DirList("./src").list());
        assertThat(list,hasItem("main"));
        assertThat(list,hasItem("test"));

        File dir = new File("./src");
        list = Arrays.asList(new DirList(dir).list());
        assertThat(list,hasItem("main"));
        assertThat(list,hasItem("test"));
    }

    @Test
    public void shouldListFilesInCaseInsensitiveOrder() {
        //可以列出当前目录下的文件
        List<String> list = Arrays.asList(new DirList().list());
        List<String> originalList = new ArrayList<String>();
        originalList.addAll(list);

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        assertThat(list, equalTo(originalList));
    }


    @Test
    public void shouldListFilesMatchThePattern() {
        //可以列出当前目录下的文件
        List<String> list = Arrays.asList(new DirList("./src","^m.*n$").list());
        assertThat(list, hasItem("main"));
    }
}
