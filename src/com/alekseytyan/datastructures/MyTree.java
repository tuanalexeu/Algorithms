package com.alekseytyan.datastructures;

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

    public MyTree getLeft() {
        return left;
    }

    public void setLeft(MyTree left) {
        this.left = left;
    }

    public MyTree getRight() {
        return right;
    }

    public void setRight(MyTree right) {
        this.right = right;
    }

    public MyTree getParent() {
        return parent;
    }

    public void setParent(MyTree parent) {
        this.parent = parent;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void inOrderTreeWalk(MyTree node) {
        if(node != null) {
            inOrderTreeWalk(node.left);
            // do something with current node
            inOrderTreeWalk(node.right);
        }
    }

    public void alternativeInOrderTreeWalk(MyTree node) {
        // Find the minimum node
        node = minRecursive(node);

        // With each iteration find the next minimum node and do something with it
        node = successor(node);
        while (node != null) {
            node = successor(node);
        }
    }

    public void preOrderTreeWalk(MyTree node) {
        if(node != null) {
            // do something with current node
            preOrderTreeWalk(node.left);
            preOrderTreeWalk(node.right);
        }
    }

    public void preOrderTreeWalkIterative(MyTree node) {
        Stack<MyTree> nodes = new SimpleStack<>();
        nodes.push(node);

        while (!nodes.isEmpty()) {
            MyTree current = nodes.pop();
            System.out.println(current.getKey());
            if(current.right != null) {
                nodes.push(current.right);
            }
            if (current.left != null) {
                nodes.push(current.left);
            }
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
        if(node == null || node.key == key) {
            return node;
        }
        if(key < node.key) {
            return searchIterative(node.left, key);
        } else {
            return searchIterative(node.right, key);
        }
    }

    public MyTree searchIterative(MyTree node, int key) {
        while (node != null && key != node.key) {
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
        if(node.right != null) {
            return minRecursive(node);
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
            return maxRecursive(node);
        }
        MyTree current = node.parent;

        while (current != null && node == current.left) {
            node = current;
            current = current.parent;
        }
        return current;
    }

    public int sumRecursive(MyTree root) {
        int sum = root.key;

        if(root.left != null) {
            sum += sumRecursive(root.left);
        }
        if(root.right != null) {
            sum += sumRecursive(root.right);
        }
        return sum;
    }

    public int sumDeep(MyTree root) {
        Stack<MyTree> nodes = new SimpleStack<>();
        nodes.push(root);

        int sum = 0;

        while (!nodes.isEmpty()) {
            MyTree current = nodes.pop();
            sum += current.key;

            if(current.right != null) {
                nodes.push(current.right);
            }
            if(current.left != null) {
                nodes.push(current.left);
            }
        }
        return sum;
    }

    public int sumWide(MyTree root) {
        Queue<MyTree> nodes = new SimpleQueue<>();
        nodes.add(root);

        int sum = 0;

        while (!nodes.isEmpty()) {
            MyTree current = nodes.remove();
            sum += current.key;

            if(current.left != null) {
                nodes.add(current.left);
            }
            if(current.right != null) {
                nodes.add(current.right);
            }
        }
        return sum;
    }

    public void insert(MyTree root, MyTree node) {
        MyTree curParent = null;
        MyTree cur = root;

        while (cur != null) {
            curParent = cur;
            if(node.key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        node.parent = curParent;

        if(curParent == null) {
            root = node;
        } else if(node.key < curParent.key) {
            curParent.left = node;
        } else {
            curParent.right = node;
        }
    }

    public void insertRecursive(MyTree node, MyTree z) {
        if(node == null) {
            node = z;
        } else {
            if(z.key < node.key) {
                insertRecursive(node.left, z);
            } else {
                insertRecursive(node.right, z);
            }
        }
    }

    public void delete(MyTree root, MyTree z) {
        if(z.left == null) {
            transplant(root, z, z.right);
        } else if(z.right == null) {
            transplant(root, z, z.left);
        } else {
            MyTree y = minRecursive(z.right);
            if(y.parent != z) {
                transplant(root, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(root, z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    // Вместо successor ищем predecessor
    public void alternativeDelete(MyTree root, MyTree z) {
        if(z.left == null) {
            transplant(root, z, z.right);
        } else if(z.right == null) {
            transplant(root, z, z.left);
        } else {
            MyTree y = maxRecursive(z.left);
            if(y.parent != z) {
                transplant(root, y, y.left);
                y.left = z.left;
                y.left.parent = y;
            }
            transplant(root, z, y);
            y.right = z.right;
            y.right.parent = y;
        }
    }

    public void transplant(MyTree root, MyTree u, MyTree v) {
        if(u.parent == null) {
            root = v;
        } else if(u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }

        if(v != null) {
            v.parent = u.parent;
        }
    }


}
