package com.company.datastructures;

public class MyTree {

    private MyTree left, right, parent;
    private int key;

    public MyTree(MyTree left, MyTree right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

    public MyTree(MyTree parent, int key) {
        this.parent = parent;
        this.key = key;
    }

    public MyTree(int key) {
        this.key = key;
    }

    public void inOrderTreeWalk(MyTree node) {
        if(node != null) {
            inOrderTreeWalk(node.left);
            // do something with current node
            inOrderTreeWalk(node.right);
        }
    }

    public void preOrderTreeWalk(MyTree node) {
        if(node != null) {
            // do something with current node
            preOrderTreeWalk(node.left);
            preOrderTreeWalk(node.right);
        }
    }

    public void postOrderTreeWalk(MyTree node) {
        if(node != null) {
            postOrderTreeWalk(node.left);
            postOrderTreeWalk(node.right);
            // do something with current node
        }
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

    public MyTree minIterative(MyTree node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public MyTree minRecursive(MyTree node) {
        if(node.left != null) {
            return minRecursive(node.left);
        }
        return node;
    }

    public MyTree maxIterative(MyTree node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public MyTree maxRecursive(MyTree node) {
        if(node.right != null) {
            return maxRecursive(node);
        }
        return node;
    }

    public MyTree successor(MyTree node) {
        if (node.right != null) {
            return minIterative(node.right);
        }
        MyTree current = node.parent;
        while (current != null && node == current.right) {
            node = current;
            current = current.parent;
        }
        return current;
    }

    public MyTree predecessor(MyTree node) {
        if(node.left != null) {
            return maxIterative(node.left);
        }
        MyTree current = node.parent;
        while(current != null && node == current.left) {
            node = current;
            current = current.parent;
        }
        return current;
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
