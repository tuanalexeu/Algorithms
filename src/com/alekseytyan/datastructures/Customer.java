package com.alekseytyan.datastructures;

public class Customer implements Comparable<Customer> {
    private final int priority;

    public Customer(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Customer o) {
        return Integer.compare(priority, o.priority);
    }
}
