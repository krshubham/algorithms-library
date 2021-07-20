package com.shubham.prep.misc;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Leetcode729 {
    static class MyCalendar {
        TreeSet<Integer[]> events;
        public MyCalendar() {
            events = new TreeSet<>((a,b) -> {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
        }

        public boolean book(int start, int end) {
            Integer[] entry = new Integer[]{start, end};
            var floor = events.floor(entry);
            if(floor != null && floor[1] > entry[0]) {
                return false;
            }
            var ceil = events.ceiling(entry);
            if(ceil != null && ceil[0] < entry[1]) {
                return false;
            }
            events.add(entry);
            HashSet<Quad> set = new HashSet<>();
            set.add(new Quad(1,2,3,4));
            set.stream()
                    .map(quad -> List.of(quad.a, quad.b, quad.c, quad.d))
                    .collect(Collectors.toList());
            return true;
        }

    }

    static class Quad {
        int a,b,c,d;

        public Quad(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Quad quad = (Quad) o;

            if (a != quad.a) return false;
            if (b != quad.b) return false;
            if (c != quad.c) return false;
            return d == quad.d;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            result = 31 * result + d;
            return result;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
    }
}
