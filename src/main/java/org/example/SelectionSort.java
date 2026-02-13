package org.example;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

  public static List<Employee> Sort(List<Employee> list) {

    List<Employee> sorted_list = new ArrayList<>(list);
    
    // Outer loop moves through each position in the list
    for (int i = 0; i < sorted_list.size() - 1; i++) {
      // Assume the current index is the smallest salary
      int minIndex = i;

      // Inner loop checks the rest of the list
      for (int j = i + 1; j < sorted_list.size(); j++) {

        // Compare salaries using CalcHourlySalary()
        if (sorted_list.get(j).CalcHourlySalary() <
            sorted_list.get(minIndex).CalcHourlySalary()) {
         // If smaller salary then update minIndex
          minIndex = j;
        }
      }
      // Swap the smallest found employee with current position
      Employee temp = sorted_list.get(i);
      sorted_list.set(i, sorted_list.get(minIndex));
      sorted_list.set(minIndex, temp);
    }
    // Return the sorted list
    return sorted_list;
  }
}
