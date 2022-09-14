package com.datastruct.atguigu.sparsearray;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        SparseArray sparseArray = new SparseArray();
        int[][] readOriginArrays = sparseArray.getArray("readSparseArray", "C:\\Users\\Administrator\\Desktop\\spare.txt");
        sparseArray.setArrayValue(readOriginArrays, "spareArr");
        sparseArray.toShow("sparseArr");
        System.out.println("-----------");

        sparseArray.toOriginArr();
        sparseArray.toShow("origin");

        System.out.println("---------------------------");
        sparseArray.toSparseArr();
        sparseArray.toShow("sparseArr");
    }
}
