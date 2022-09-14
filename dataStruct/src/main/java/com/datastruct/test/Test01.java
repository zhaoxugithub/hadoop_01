package com.datastruct.test;

import java.util.*;

public class Test01 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        char[] charArray = countAndSay(n - 1).toCharArray();
        int j = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            i = j;
            int total = 0;
            while (j < charArray.length && charArray[i] == charArray[j]) {
                total++;
                j++;
            }
            sb.append(total + "" + charArray[i]);
            if (j == charArray.length) {
                break;
            }
        }
        return sb.toString();
    }

    public int lengthOfLastWord(String s) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {

            }
        }
        if (s.length() == 0) {
            return 0;
        }


        return 0;
    }

    public static void test3() {
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

    public void test2() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(60);
        queue.add(5);
        queue.add(8);
        queue.add(2);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }


    //实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
    public boolean isUnique(String astr) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                return false;
            }
            map.put(chars[i], 1);
        }
        return true;
    }

    //给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        char[] chars = s1.toCharArray();
        for (char aChar : chars) {
            if (map1.containsKey(aChar)) {
                map1.replace(aChar, map1.get(aChar) + 1);
            } else {
                map1.put(aChar, 1);
            }
        }
        Map<Character, Integer> map2 = new HashMap<>();
        char[] chars1 = s2.toCharArray();
        for (char c : chars1) {
            if (map2.containsKey(c)) {
                map2.replace(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }
        for (Character character : map1.keySet()) {
            if (map2.get(character) == null || !map1.get(character).equals(map2.get(character))) return false;
        }

        for (Character character : map2.keySet()) {
            if (map1.get(character) == null || !map1.get(character).equals(map2.get(character))) return false;
        }
        return true;
    }


    //URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/string-to-url-lcci
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    //给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
    //
    //回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
    //
    //回文串不一定是字典当中的单词。
    //`````
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean canPermutePalindrome(String s) {

        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (set.contains(aChar)) {
                set.remove(aChar);
            } else {
                set.add(aChar);
            }
        }
        return set.size() <= 1;
    }

    //字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        char[] firstChar = first.toCharArray();
        char[] secondChar = second.toCharArray();
        int indexFirst = 0;
        int indexSecond = 0;
        int result = 0;
        while (indexFirst < firstChar.length && indexSecond < secondChar.length) {
            if (firstChar[indexFirst] != secondChar[indexSecond]) {
                result++;
                if (firstChar.length > secondChar.length) {
                    indexFirst++;
                } else if (firstChar.length < secondChar.length) {
                    indexSecond++;
                } else {
                    indexFirst++;
                    indexSecond++;
                }
            } else {
                indexFirst++;
                indexSecond++;
            }
        }
        while (indexFirst < firstChar.length) {
            result++;
            indexFirst++;
        }
        while (indexSecond < secondChar.length) {
            result++;
            indexSecond++;
        }
        return result <= 1;
    }

    //字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
    //
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/compress-string-lcci
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String compressString(String S) {
        if (null == S || "".equals(S)) {
            return S;
        }
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int preIndex = 0;
        int nextIndex = 0;
        int count = 0;
        while (nextIndex < chars.length) {
            if (chars[nextIndex] == chars[preIndex]) {
                count++;
                nextIndex++;
            } else {
                sb.append(chars[preIndex]).append(count);
                count = 0;
                preIndex = nextIndex;
            }
        }
        sb.append(chars[preIndex]).append(nextIndex - preIndex);
        return S.length() > sb.length() ? sb.toString() : S;
    }

    /*
    [
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
a[0][0] --> a[0][3]
a[1][0] --> a[0][2]
a[2][0] ---> a[0][1]
a[3][0] ---> a[0][0]

     */
    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix[0].length; i++) {
        }
    }

    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return solution(n - 1) + solution(n - 2);
    }

    public int solutionFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int result[] = new int[n + 1];
            result[0] = 0;
            result[1] = 1;
            result[2] = 2;
            for (int i = 3; i <= n; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
            return result[n];
        }
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < total; i++) {
            Integer key = sc.nextInt();
            Integer value = sc.nextInt();
            /*下面这段代码可以被替换
            if(map.containsKey(key)){
                Integer newValue = map.get(key)+value;
                map.put(key,newValue);
            }else{
                map.put(key,value);
            }
            */
            map.merge(key, value, Integer::sum);

        }
        map.keySet().stream().sorted().forEach(k -> System.out.println(k + " " + map.get(k)));
        Stack<String> stack = new Stack<String>();
//        stack.push()
        StringBuilder stringBuilder = new StringBuilder();
    }

    public int max(int[] nums, int start, int end) {
        int max = 0;
        for (int i = start; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public void test2(int[] nums, int k) {


        for (int i = 0; i < nums.length; i++) {
            if (k + i == nums.length + 1) {
                break;
            }
            int max = max(nums, i, k + i);

        }

    }

    public static void test31(int num) {
        int total = 0;
        for (int i = 2; i <= num; i++) {
            int sqi = (int) Math.sqrt(i);
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int k = 1; k <= sqi; k++) {
                int rand = i / k;
                int yu = i % k;
                if (yu != 0 || rand == i) {
                    continue;
                }
                sum = sum + rand + k;
                list.add(rand);
                list.add(k);
            }
            if (sum + 1 == i) {
                System.out.println("num=" + i + ",detail =" + Arrays.toString(list.toArray()) + "sum =" + list.stream().reduce(Integer::sum).get());
                total++;
            }
        }
        System.out.println(total);
    }

    public static String[] permutation(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            String str = ""+ch;
            for (char ch2 : chs) {
                if (ch != ch2) {
                    str += ch2;
                }
            }
            list.add(str);
        }

        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")));
    }
}
