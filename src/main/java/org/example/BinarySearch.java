package org.example;

import java.util.List;

public class BinarySearch {

  public static <T> void Search(String name, List<T> list) {
    // Create REVERSE binary search on a sorted array based on name

    // return the index of first occurrence of the name if found multiple times
    // return -1 if name is not found

    int index = -1; // default value (overridden with an index IF found)


    if (index == -1) {
       System.out.println("Sorry... That Employee was not found in our records...");
     } else {
       System.out.println("Hey! That Employee was found at position " + index + " in " +
               "our records!");
     }
  }
}
