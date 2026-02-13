package org.example;

import java.util.ArrayList;

public class QuickSort {

  public static <T extends Comparable<T>> ArrayList<T> Sort(ArrayList<T> list) {

    // Early Exit
    if (list.size() <= 1) {
      return list;
    }

    // get pivot
    T pivot = list.getLast();

    ArrayList<T> left = new ArrayList<>();
    ArrayList<T> right = new ArrayList<>();

    // sort arrays
    for (int i = 0; i < list.size() - 1; i++) {
      T value = list.get(i);
      // compares selected item to the pivot point (returns 1 larger, 0 same, -1 smaller)
      if (value.compareTo(pivot) <= 0) {
        left.add(value);
      } else {
        right.add(value);
      }
    }

    // restructure array
    ArrayList<T> sorted = new ArrayList<>();
    sorted.addAll(Sort(left));
    sorted.add(pivot);
    sorted.addAll(Sort(right));

    return sorted;
  }
}