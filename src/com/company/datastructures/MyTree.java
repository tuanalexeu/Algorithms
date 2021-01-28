package com.company.datastructures;

public class MyTree {
    MyTree left, right;
    int key;


    public MyTree(MyTree left, MyTree right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

    public MyTree(int key) {
        this.key = key;
    }

    public MyTree searchRecursive(MyTree node, int key) {
        if(node == null || key == node.key) {
            return node;
        }

        if(key < node.key) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    public MyTree searchIterative(MyTree node, int key) {
        while(node != null && key != node.key) {
            if(key < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public static int sumRecursive(MyTree root) {
        int sum = root.key;

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
            sum += node.key;
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
            sum += node.key;
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
