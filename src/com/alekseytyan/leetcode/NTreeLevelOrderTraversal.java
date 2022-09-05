package com.alekseytyan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 104]
 */
public class NTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(Node root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        divideIntoLevels(root, 0, map);
        return new ArrayList<>(map.values());
    }

    private static void divideIntoLevels(Node root, int level, Map<Integer, List<Integer>> map) {
        if(root == null) {
            return;
        }

        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.value);

        if(root.children != null) {
            root.children.forEach(c -> divideIntoLevels(c, level + 1, map));
        }
    }

    public static void main(String[] args) {
        Node input = prepareInput();
        List<List<Integer>> output = levelOrder(input);
        System.out.println(output);
    }

    private static Node prepareInput() {
        Node node2 = new Node(2);

        Node node14 = new Node(14);
        Node node11 = new Node(11, List.of(node14));
        Node node7 = new Node(7, List.of(node11));
        Node node6 = new Node(6);
        Node node3 = new Node(3, List.of(node6, node7));

        Node node12 = new Node(12);
        Node node8 = new Node(8, List.of(node12));
        Node node4 = new Node(4, List.of(node8));

        Node node13 = new Node(13);
        Node node9 = new Node(9, List.of(node13));
        Node node10 = new Node(10);
        Node node5 = new Node(5, List.of(node9, node10));

        return new Node(1, List.of(node2, node3, node4, node5));
    }
}

class Node {
    public int value;
    public List<Node> children;

    public Node(int value) {
        this(value, null);
    }

    public Node(int value, List<Node> children) {
        this.value = value;
        this.children = children;
    }
}
