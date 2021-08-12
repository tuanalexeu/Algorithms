package com.alekseytyan.algorithms.problems.other;

public class RectangleOverlap {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Rectangle {
        private final Point topLeft;
        private final Point bottomRight;

        public Rectangle(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        public boolean isOverLapping(Rectangle other) {
            if(this.topLeft.x > other.bottomRight.x
                    || this.bottomRight.x < other.topLeft.x
                    || this.topLeft.y < other.bottomRight.y
                    || this.bottomRight.y > other.topLeft.y) {
                return false;
            }
            return true;
        }
    }
}
