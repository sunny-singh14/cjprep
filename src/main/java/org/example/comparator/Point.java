package org.example.comparator;

public class Point implements Comparable<Point> {
    int x;

    public Point(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Point p && x == p.x;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(Point other) {
        return Integer.compare(this.x, other.x);
    }
}
