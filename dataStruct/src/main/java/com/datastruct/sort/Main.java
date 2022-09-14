package com.datastruct.sort;



import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int[] generateArray() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public void testSelectionSort() {
        System.out.println("选择排序：");
        int[] array = generateArray();
        System.out.println(Arrays.toString(array));
        new SelectionSort().sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void testBubbleSort() {
        System.out.println("冒泡排序");
        int[] array = generateArray();
        System.out.println(Arrays.toString(array));
        new BubbleSort().sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void testInsertSort() {
        System.out.println("插入排序：");
        int[] array = generateArray();
        System.out.println(Arrays.toString(array));
        new InsertSort().sort3(array);
        System.out.println(Arrays.toString(array));
    }

    public void testGuiBinSort() {
        System.out.println("归并排序：");
        int[] array = generateArray();
        System.out.println(Arrays.toString(array));
        new GuiBinSort().sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void test() {
        int[] array = {1, 2, 2, 3, 3, 4, 4, 4, 5, 5};

        //先找出奇数次的数1^4
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res ^= array[i];
        }

        //找出1^4 的值的最右边的数1
        int temp = res & (~res + 1);
        int one = 0;
        for (int k = 0; k < array.length; k++) {
            if ((temp & array[k]) != 0) {
                one ^= array[k];
            }
        }
        int anotherOne = res ^ one;
        System.out.println(one + "---" + anotherOne);
    }
}
