package com.alekseytyan.datastructures;

import java.util.HashSet;

public class LinkedList {

    private Node head;

    public static class Node {

        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public void insert(String data) {
        Node new_node = new Node(data);

        if(head == null) {
            head = new_node;
        } else {
            Node curNode = head;

            while (curNode.next != null) {
                curNode = curNode.next;
            }

            curNode.next = new_node;
        }
    }

    public static void printList(LinkedList list) {
        Node curNode = list.head;

        System.out.print("Linked list: ");

        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
    }

    public boolean isCyclic() {
        Node fast = head;
        Node slow = head;

        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void reverse() {
        Node pointer = head;
        Node previous = null;
        Node current = null;

        while (pointer != null) {
            current = pointer;
            pointer = pointer.next;

            current.next = previous;
            previous = current;
            head = current;
        }
    }

    public void reverseIteratively() {
        Node current = head;
        Node previous = null;
        Node forward = null;

        while (current.next != null) {
            forward = current.next;
            current.next = previous;
            previous = current;

            current = forward;
        }

        head = current;
        head.next = previous;
    }

    public void removeDuplicates() {
        HashSet<String> hs = new HashSet<>();

        Node current = head;
        Node previous = null;

        while (current != null) {
            String curval = current.getData();

            if(hs.contains(curval)) {
                previous.next = current.next;
            } else {
                hs.add(curval);
                previous = current;
            }

            current = current.next;
        }
    }

    public Node findMiddle() {
        if(head == null) {
            return null;
        } else {
            Node cur = head;
            Node middle = head;
            int length = 1;

            while (cur.next != null) {

                length++;
                cur = cur.next;

                if(length % 2 == 1) {
                    middle = middle.next;
                }
            }

            if(length % 2 == 1) {
                middle = middle.next;
            }

            return middle;
        }
    }

    public Node getThirdFromEnd() {
        Node third = head;

        while (third.next.next != null) {
            third = third.next;
        }

        return third;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.insert("4");
        list.insert("5");
        list.insert("6");
        list.insert("7");
        list.insert("8");
        list.insert("9");

        System.out.println(list.findMiddle());

    }
}
