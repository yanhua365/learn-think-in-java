package com.github.yanhua365.learn.thinkinjava.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: yanhua
 * Date: 13-10-3
 * Time: 上午11:26
 * 遍历文件目录
 */
public class DirWalker {
    private final File dir;

    public DirWalker(File dir) throws FileNotFoundException {
       if(!dir.exists()){
           throw new FileNotFoundException();
       }
       this.dir = dir;

    }

    public List<DirEntry> walk() {
        List<DirEntry> result = new ArrayList<DirEntry>();
        recurseWalk(this.dir, result);
        return result;
    }

    private void recurseWalk(File dir, List<DirEntry> result){
        String dirPath = dir.getPath();
        List<String> dirNames = new ArrayList<String>();
        List<String> fileNames = new ArrayList<String>();

        File[] files = dir.listFiles();

        if(files == null){
            //dir is exists,so files can not be null.Is nessary to do this check?
            System.out.println(dir.getPath() + " maybe is not exists ,its listFiles() return null value.");
            return;
        }

        for(File file : files){
            if(file.isDirectory()){
                dirNames.add(file.getName());
            }else{
                fileNames.add(file.getName());
            }
        }

        Collections.sort(dirNames, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(fileNames, String.CASE_INSENSITIVE_ORDER);

        DirEntry currentDirEntry = new DirEntry(dirPath, dirNames, fileNames);
        result.add(currentDirEntry);

        for(String subDirName : currentDirEntry.getDirNames()){
            recurseWalk(new File(currentDirEntry.getDirPath() +File.separator + subDirName),result);
        }
    }


    public static class DirEntry{
        private String dirPath;
        private List<String> dirNames = new ArrayList<String>();
        private List<String> fileNames = new ArrayList<String>();

        public DirEntry(String dirPath, List<String> dirNames, List<String> fileNames) {
            this.dirPath = dirPath;

            this.dirNames.addAll(dirNames);
            this.fileNames.addAll(fileNames);
        }

        public String getDirPath() {
            return dirPath;
        }

        public List<String> getDirNames() {
            return Collections.unmodifiableList(this.dirNames);
        }

        public List<String> getFileNames() {
            return Collections.unmodifiableList(this.fileNames);
        }
    }
}
