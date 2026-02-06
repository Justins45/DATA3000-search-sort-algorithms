package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
  static void main() {

    // ==================================================================================
    /*
     * Main Functionality Check list
     *
     *  (1) Get data from txt file ✅
     *  (2) sort Data by name AND by salary
     *  (3) display time to complete for each data
     *  (4) write data to csv files (sortedemployeeBySalary & sortedemployeeByName)
     *  (5) prompt user to enter name to search for
     */
    // ==================================================================================

    /*
     * (1)
     * Read file "employeesWithoutRepeat.txt" and populate array with said data.
     *
     * follows the format
     *
     * id, name, hours_worked, hourly_rate, deduction_province, deduction_federal, education_allowance
     *
     */

    List<Employee> employees_unsorted_wo_repeat = List.copyOf(ReadFile(
            "employeesWithoutRepeat.txt"));

    // Displacement of all data for testing
    //for (Employee item : employees_unsorted_wo_repeat) {
    //  System.out.println(item.GetInfo());
    //}

    // (2) Sort data by name & by salary (using the sorting methods)

    // Sort by Name (Quick Sort)
    long name_time_start = System.currentTimeMillis();

    // SORT METHOD HERE

    long name_time_end = System.currentTimeMillis();
    long name_time_total = name_time_end - name_time_start;

    // Sort by Salary (Selection Sort)
    long salary_time_start = System.currentTimeMillis();

    // SORT METHOD HERE

    long salary_time_end = System.currentTimeMillis();
    long salary_time_total = salary_time_end - salary_time_start;


    // (3) compare sorting algorithms times and print to console

    System.out.println("Time to complete Quick Sort: " + name_time_total + "ms");
    System.out.println("Time to complete Selection Sort: " + salary_time_total + "ms");

    if (name_time_total > salary_time_total) {
      System.out.println("Quick sort is the faster Sorting algorithm this time around!");
    } else if (name_time_total < salary_time_total) {
      System.out.println("Selection sort is the faster Sorting algorithm this time around!");
    } else {
      System.out.println("Looks like we have a tie for the faster sorting algorithm!");
    }

    // (4) write data to 2 csv files (sortedemployeeBySalary.csv & sortedemployeeByName.csv)

    // (5) prompt user for name to search csv files for.

  }

  /**
   * ReadFile function
   *<p>
   * Takes in a string for a file name located in the root directory, and returns a List array
   * of Employee objects.
   *</p>
   *
   * @param file_name String with file extension ex: employees.txt
   * @return List of Employee objects
   */
  public static List<Employee> ReadFile(String file_name) {

    // initialize list
    List<Employee> result_empl = new ArrayList<>();

    // get each line into a Steam of Strings for easier retrieval
    try (Stream<String> lines = Files.lines(Paths.get(file_name))) {

      // Set string to a list of strings for iterating
      List<String> result_str = lines.toList();

      for (String item : result_str) {
        // Use Employee String Parser to comma separate each string and return Employee Object
        result_empl.add(EmployeeStringParser(item));
      }

    } catch (IOException e) {
      // System catch all for any file reading errors
      System.err.println("Error reading file: " + e.getMessage());
      e.printStackTrace();
    }

    // return list of employees
    return result_empl;
  }


  /**
   * Employee String Parser
   * <p>
   * Takes in a string of Employee data separated by commas and outputs to a single Employee
   * object
   * </p>
   *
   * @param s comma separated String
   * @return Employee object
   */
  public static Employee EmployeeStringParser(String s) {
    // Separate string into array for parts grabbing
    String[] parts = s.split(",");

    // assign parts to variables for easier reading
    int id = Integer.parseInt(parts[0]);
    String name = parts[1];
    double hours_worked = Double.parseDouble(parts[2]);
    double hourly_rate = Double.parseDouble(parts[3]);
    double deduction_province = Double.parseDouble(parts[4]);
    double deduction_federal = Double.parseDouble(parts[5]);
    double education_allowance = Double.parseDouble(parts[6]);

    // return new Employee object using the split string parts
    return new Employee(id, name, hours_worked, hourly_rate, deduction_province,
            deduction_federal, education_allowance);
  }
}

