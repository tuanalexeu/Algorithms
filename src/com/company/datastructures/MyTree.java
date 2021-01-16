package com.company.datastructures;

public class MyTree {
    MyTree left, right;
    int value;


    public MyTree(MyTree left, MyTree right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public MyTree(int value) {
        this.value = value;
    }

    public static int sumRecursive(MyTree root) {
        int sum = root.value;

        if(root.left != null) {
            sum += sumRecursive(root.left);
        }
        if(root.right != null) {
            sum += sumRecursive(root.right);
        }
        return sum;
    }

    public static int sumDeep(MyTree root) {
        SimpleStack<MyTree> stack = new SimpleStack<>();
        stack.push(root);
        int sum = 0;

        while (!stack.isEmpty()) {
            MyTree node = stack.pop();
            sum += node.value;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }

    public static int sumWide(MyTree root) {
        SimpleQueue<MyTree> stack = new SimpleQueue<>();
        stack.add(root);
        int sum = 0;

        while (!stack.isEmpty()) {
            MyTree node = stack.remove();
            sum += node.value;
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return sum;
    }
}
