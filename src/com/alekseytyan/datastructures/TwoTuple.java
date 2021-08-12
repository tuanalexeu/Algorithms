package com.alekseytyan.datastructures;

public class TwoTuple<A,B> {
    private A max;
    private B min;

    public TwoTuple(A max, B min) {
        this.max = max;
        this.min = min;
    }

    public A getMax() {
        return max;
    }

    public B getMin() {
        return min;
    }
}
