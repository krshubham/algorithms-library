package com.shubham.prep.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

/**
 * A binary heap is represented as an array where the root is at A[0], A is the name of the array
 * A[(i-1)/2] returns the parent
 * A[(2*i) + 1] returns the left child
 * A[(2*i) + 2] returns the right child
 */
public class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> heapArray; //Array to store our heap
    private int capacity; //Maximum possible size of the min heap
    private int heapSize; //Current number of elements in the heap

    public MinHeap(int capacity) {
        heapSize = 0;
        this.capacity = capacity;
        heapArray = new ArrayList<>(capacity);
    }

    private int parent(int idx) {
        return (idx - 1)/2;
    }

    private int left(int idx) {
        return (2*idx) + 1;
    }

    private int right(int idx) {
        return (2*idx) + 2;
    }

    public void insert(T val) {
        if(heapSize >= capacity) {
            System.out.println("Overflow");
            return;
        }
        heapSize++;
        heapArray.add(heapSize - 1, val);
        int i = heapSize - 1;
        while(i != 0 && heapArray.get(i).compareTo(heapArray.get(parent(i))) < 0) {
            Collections.swap(heapArray, i, parent(i));
            i = parent(i);
        }
    }

    public Optional<T> peek() {
        if(heapSize <= 0) {
            return Optional.empty();
        }
        if(heapSize == 1) {
            return Optional.of(heapArray.get(0));
        }
        return Optional.of(heapArray.get(0));
    }
}
