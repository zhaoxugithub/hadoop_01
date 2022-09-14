package com.datastruct.atguigu.sparsearray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SparseArray {

    private int[][] originArr;

    private int[][] sparseArr;

    public SparseArray() {
    }

    public int[][] getArray(String fileSource, String fileDir) throws IOException {
        if ("readOriginArray".equals(fileSource)) {
            return getOriginArray(fileDir);
        } else {
            return getSparseArray(fileDir);
        }
    }


    public void setArrayValue(int[][] array, String type) {
        if ("origin".equals(type)) {
            originArr = array;
        } else {
            sparseArr = array;
        }
    }


    public int[][] getSparseArray(String fileDir) throws IOException {

        FileReader fileReader = new FileReader(fileDir);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> lineList = new ArrayList<String>();
        while ((line = bufferedReader.readLine()) != null) {
            lineList.add(line);
        }
        int[][] sparseArray = new int[lineList.size()][3];
        int lineNumber = 0;
        for (String eachLine : lineList) {
            String[] split = eachLine.split("\t");
            sparseArray[lineNumber][0] = Integer.parseInt(split[0]);
            sparseArray[lineNumber][1] = Integer.parseInt(split[1]);
            sparseArray[lineNumber][2] = Integer.parseInt(split[2]);
            lineNumber++;
        }
        bufferedReader.close();
        fileReader.close();
        return sparseArray;
    }

    public int[][] getOriginArray(String fileDir) throws IOException {
        FileReader fileReader = new FileReader(fileDir);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        List<String> lineList = new ArrayList<String>();
        while ((line = bufferedReader.readLine()) != null) {
            lineList.add(line);
        }
        int colLength = lineList.get(0).split("\t").length;
        int[][] originArray = new int[lineList.size()][colLength];
        int lineNumber = 0;

        for (String eachLine : lineList) {
            String[] split = eachLine.split("\t");
            for (int i = 0; i < split.length; i++) {
                originArray[lineNumber][i] = Integer.parseInt(split[i]);
            }
            lineNumber++;
        }

        bufferedReader.close();
        fileReader.close();
        return originArray;
    }


    //转成稀疏数组
    public void toSparseArr() {
        int row = 0;
        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr[0].length; j++) {
                if (originArr[i][j] != 0) {
                    row++;
                    sparseArr[row][0] = i;
                    sparseArr[row][1] = j;
                    sparseArr[row][2] = originArr[i][j];

                }
            }
        }
        sparseArr[0][0] = originArr.length;
        sparseArr[0][1] = originArr[1].length;
        sparseArr[0][2] = row;
    }

    //转成原始数组
    public void toOriginArr() {
        originArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            originArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
    }

    //遍历数组
    public void toShow(String type) {
        if ("origin".equals(type)) {
            toShow(originArr);
        } else {
            toShow(sparseArr);
        }
    }

    private void toShow(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (j == array[0].length - 1) {
                    System.out.print(array[i][j]);
                } else {
                    System.out.print(array[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

}
