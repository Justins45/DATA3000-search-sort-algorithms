package org.example;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

  public static List<Employee> Sort(List<Employee> list) {

    List<Employee> sorted_list = new ArrayList<>(list);

    for (int i = 0; i < sorted_list.size() - 1; i++) {

      int minIndex = i;

      for (int j = i + 1; j < sorted_list.size(); j++) {

        if (sorted_list.get(j).CalcHourlySalary() <
            sorted_list.get(minIndex).CalcHourlySalary()) {

          minIndex = j;
        }
      }

      Employee temp = sorted_list.get(i);
      sorted_list.set(i, sorted_list.get(minIndex));
      sorted_list.set(minIndex, temp);
    }

    return sorted_list;
  }
}


