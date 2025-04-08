package org.example.comparator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            points.add(new Point(i));
        }
        Set<Point> pointSet = new HashSet<>(points);
        Point point = points.get(5);
        System.out.println(pointSet.contains(point));
        point.x = 50;
        System.out.println(pointSet.contains(point));
    }
}
