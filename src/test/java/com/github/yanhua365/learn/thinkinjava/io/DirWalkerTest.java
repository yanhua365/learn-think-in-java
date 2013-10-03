package com.github.yanhua365.learn.thinkinjava.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * User: yanhua
 * Date: 13-10-3
 * Time: 上午11:27
 */
public class DirWalkerTest {

    public static final String SEP = File.separator;
    String rootPath = null;

    @Before
    public void setUp() {
        rootPath = "."+SEP+"src" + SEP + "test" + SEP + "resources" + SEP + "fixture" + SEP + "io" + SEP + "dir_stub";
    }

    @Test
    public void shouldWalkInTheDir() throws FileNotFoundException {
        File dir = new File(rootPath);
        DirWalker walker = new DirWalker(dir);
        List<DirWalker.DirEntry> entryList = walker.walk();

        DirWalker.DirEntry rootEntry = entryList.get(0);
        assertThat(rootEntry.getDirPath(), is(rootPath));
        assertThat(rootEntry.getDirNames(), is(Arrays.asList(new String[]{"dir1","dir2"})));
        assertThat(rootEntry.getFileNames(), is(Arrays.asList(new String[]{"hello_file.txt", "Kao.txt"})));


        DirWalker.DirEntry dir1Entry = entryList.get(1);
        assertThat(dir1Entry.getDirPath(), is(rootPath + SEP + "dir1"));
        assertThat(dir1Entry.getDirNames(), is(Arrays.asList(new String[]{"empty_dir"})));
        assertThat(dir1Entry.getFileNames(), is(Arrays.asList(new String[]{"file11.txt", "file12.txt"})));
    }


    @Test
    public void shouldWalkInTheEmptyDir() throws FileNotFoundException {
        String emptyDirPath = rootPath + SEP + "dir1" + SEP + "empty_dir";
        File dir = new File(emptyDirPath);
        DirWalker walker = new DirWalker(dir);
        List<DirWalker.DirEntry> entryList = walker.walk();

        DirWalker.DirEntry rootEntry = entryList.get(0);
        assertThat(rootEntry.getDirPath(), is(emptyDirPath));
        assertTrue(rootEntry.getDirNames().isEmpty());
    }
}
