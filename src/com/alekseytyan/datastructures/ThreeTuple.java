package com.alekseytyan.datastructures;

public class ThreeTuple<A,B,C> {
    public final A low;
    public final B high;
    public final C sum;
    public ThreeTuple(A a, B b, C c) {
        low = a;
        high = b;
        sum = c;
    }
    public String toString() {
        return "(" + low + ", " + high + ")";
    }
}
