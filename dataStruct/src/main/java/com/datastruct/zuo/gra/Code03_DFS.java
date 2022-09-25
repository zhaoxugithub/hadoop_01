package com.datastruct.zuo.gra;

import com.datastruct.zuo.gra.struct.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * ClassName Code03_DFS
 * Description TODO
 * Author 11931
 * Date 2022-09-25:22:45
 * Version 1.0
 **/

// 图的深度遍历
public class Code03_DFS {


    public static void main(String[] args) {

    }

    public static void dfs(Node node) {

        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        // 去重
        HashSet<Node> set = new HashSet<>();

        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (Node next : pop.nexts) {
                // 如果节点没有被遍历过
                if (!set.contains(next)) {
                    // 为什么要把上游节点重新压进去？
                    stack.push(pop);
                    stack.push(next);

                    set.add(next);
                    System.out.println(next);
                    // 为什么需要break？？
                    break;
                }
            }
        }
    }
}
