package com.datastruct.oldcode.ch05;


import java.util.LinkedList;
import java.util.Queue;

//二叉搜索树
public class BST<E extends Comparable<E>> {

    private class Node {

        public E data;
        public Node left, right;

        public Node(E e) {
            data = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * 树结构添加元素的第一种方法
     * @param e
     *
    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        if (node.data.equals(e)) {
            return;
        } else if (node.data.compareTo(e) > 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (node.data.compareTo(e) < 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (node.data.compareTo(e) > 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }
*/
    //添加元素方法二:递归

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * @param node 指的是添加的节点位置
     * @param e    指的要添加的节点元素
     * @return
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (node.data.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.data.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }
        if (node.data.equals(e)) {
            return true;
        } else if (node.data.compareTo(e) > 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }


    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        preOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data);
    }


    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.data);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minimum = minimum(root);
        return minimum.data;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        Node minimum = minimum(node.left);
        return minimum;
    }


    /**
     * 寻找二分搜索树的最大元素
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node maximum = maximum(root);
        return maximum.data;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        Node maximum = maximum(node.right);
        return maximum;
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return
     */
    public E removeMin() {
        E minimum = minimum();
        root = removeMin(root);
        return minimum;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax() {
        return null;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        return null;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.data + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        BST<String> bst = new BST<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            bst.add(res.toString());
        }
        return bst.getSize();
    }

}
