package org.example;

import java.util.List;

public class BinarySearch {

  /**
   * Public wrapper method.
   * <p>
   * Takes the name string, creates a dummy Employee object, and calls the recursive search.
   * </p>
   *
   * @param name Takes in the name of the Employee you are searching for
   * @param list list of SORTED BY NAME employees
   */
    public static void Search(String name, List<Employee> list) {
        // Create a dummy employee with the name we are searching for.
        // The other values (0, 0.0) don't matter because compareTo only checks Name.
        Employee target = new Employee(0, name, 0, 0, 0, 0, 0);

        // Call the recursive helper
        // We pass 'target' (which is type Employee) to a list of Employees.
        int index = recursiveSearch(list, target, 0, list.size() - 1);

        // Output results
        if (index == -1) {
            System.out.println("Sorry... That Employee '" + name + "' was not found in our records...");
        } else {
            System.out.println("Hey! That Employee '" + name + "' was found at position " + index + " in our records!");
        }
    }

    /**
     * Recursive Binary Search Helper.
     * Finds the FIRST occurrence of the key.
     */
    private static <T extends Comparable<T>> int recursiveSearch(List<T> list, T key, int low, int high) {
        // Base case: not found
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        T midVal = list.get(mid);
        int cmp = midVal.compareTo(key); // returns 1, 0 or -1

        if (cmp < 0) {
            // Key is in the right half
            return recursiveSearch(list, key, mid + 1, high);
        } else if (cmp > 0) {
            // Key is in the left half
            return recursiveSearch(list, key, low, mid - 1);
        } else {
            // Found a match! But is it the FIRST one?
            // Check if we are at index 0 OR if the element before this one is different.
            if (mid == 0 || list.get(mid - 1).compareTo(key) != 0) {
                return mid; // This is the first occurrence
            } else {
                // There is a duplicate to the left, keep searching left
                return recursiveSearch(list, key, low, mid - 1);
            }
        }
    }
}
