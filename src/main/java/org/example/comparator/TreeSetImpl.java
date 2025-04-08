package org.example.comparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetImpl {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>(new PreserveInsertionComp());
        numbers.add(5);
        numbers.add(0);
        numbers.add(10);
        numbers.add(12);
        numbers.add(1);
        numbers.add(1);
        System.out.println(numbers);
    }

    static class PreserveInsertionComp implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2){
            return i1.compareTo(i2);
        }
    }
}
