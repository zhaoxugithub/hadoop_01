package com.datastruct.test;

import java.io.*;

public class ReadFile {

    private static void readFile(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

    public static void main(String[] args) throws IOException {
        File fileIn = new File("/Users/serenipity/IdeaProjects/hadoop_01/dataStruct/src/main/java/com/datastruct/test/a.ini");
        File fileOut = new File("/Users/serenipity/IdeaProjects/hadoop_01/dataStruct/src/main/java/com/datastruct/test/a.out");
        readFile(fileIn, fileOut);
    }
}
