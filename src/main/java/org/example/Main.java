package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Scanner;

public class Main {
  static void main() {

    // ==================================================================================
    /*
     * Main Functionality Check list
     *
     *  (1) Get data from txt file                                                   ✅
     *  (2) sort Data by name AND by salary                                          ✅
     *  (3) display time to complete for each data                                   ✅
     *  (4) write data to csv files (sortedemployeeBySalary & sortedemployeeByName)  ✅
     *  (5) prompt user to enter name to search for                                  ✅
     */
    // ==================================================================================

    // (1) Get Data from txt files
    // Gets employee list WITHOUT repeats
    List<Employee> employees_unsorted_no_repeat = List.copyOf(ReadFile(
            "employeesWithoutRepeat.txt"));
    // Gets employee list WITH repeats
    List<Employee> employees_unsorted_w_repeat = List.copyOf(ReadFile(
            "employeesWithRepeat.txt"));

    // (2) Sort data by name & by salary (using the sorting methods)

    // Sort by Name (Quick Sort) - WITHOUT repeats
    long name_norp_time_start = System.currentTimeMillis();

    List<Employee> name_sorted_norp = QuickSort.Sort(employees_unsorted_no_repeat);

    long name_norp_time_end = System.currentTimeMillis();
    long name_norp_time_total = name_norp_time_end - name_norp_time_start;

    // Sort by Name (Quick Sort) - WITH repeats
    long name_wrp_time_start = System.currentTimeMillis();

    List<Employee> name_sorted_wrp = QuickSort.Sort(employees_unsorted_w_repeat);

    long name_wrp_time_end = System.currentTimeMillis();
    long name_wrp_time_total = name_wrp_time_end - name_wrp_time_start;

    // Sort by Salary (Selection Sort) - WITHOUT repeats
    long salary_norp_time_start = System.currentTimeMillis();

    List<Employee> salary_sorted_norp = QuickSort.Sort(employees_unsorted_no_repeat);

    long salary_norp_time_end = System.currentTimeMillis();
    long salary_norp_time_total = salary_norp_time_end - salary_norp_time_start;

    // Sort by Salary (Selection Sort) - WITH repeats
    long salary_wrp_time_start = System.currentTimeMillis();

    List<Employee> salary_sorted_wrp = QuickSort.Sort(employees_unsorted_w_repeat);

    long salary_wrp_time_end = System.currentTimeMillis();
    long salary_wrp_time_total = salary_wrp_time_end - salary_wrp_time_start;


    // (3) compare sorting algorithms times and print to console
    DisplayTimeResults(name_norp_time_total, salary_norp_time_total, false);
    DisplayTimeResults(name_wrp_time_total, salary_wrp_time_total, true);


    // (4) write data to 2 csv files (sortedemployeeBySalary.csv & sortedemployeeByName.csv)

    // Write to file - Sorted by name
    // TODO: uncomment when return method works
    // WriteTOCSV("sortedemployeeByName", name_sorted_norp);

    // Write to file - Sorted by salary
    // TODO: uncomment when return method works
    // WriteTOCSV("sortedemployeeBySalary", salary_sorted_norp);


    // (5) prompt user for name to search csv files for.
     Scanner scanner = new Scanner(System.in);
     System.out.println("Please enter an Employee name to search for....");
     String input = scanner.nextLine();


     BinarySearch.Search(input, name_sorted_norp);
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

  /**
   * Display Time Results
   *<p>
   * Displays time results for a time comparison of a quick sort algorithm and a selection
   * sort algorithm
   *</p>
   *
   * @param quick_sort Quick sort time of completion
   * @param selection_sort Selection sort time of completion
   * @param with_repeats T/F if list has repeats
   */
  public static void DisplayTimeResults(long quick_sort, long selection_sort,
                                        boolean with_repeats) {

    // simple temporary variable for displaying with or without repeats in the list
    String temp_var = (with_repeats) ? " " : " NO ";

    System.out.println(
            "====================================================================================");
    System.out.println("Race WITH" + temp_var + "REPEATS");
    System.out.println("Time to complete Quick Sort is: " + quick_sort + "ms");
    System.out.println("Time to complete Selection Sort is: " + selection_sort + "ms");
    System.out.println(
            "------------------------------"); // divider
    if (quick_sort > selection_sort) {
      System.out.println("Quick sort is the faster Sorting algorithm this time around!");
    } else if (quick_sort < selection_sort) {
      System.out.println("Selection sort is the faster Sorting algorithm this time around!");
    } else {
      System.out.println("Looks like we have a tie for the faster sorting algorithm!");
    }
    System.out.println(
            "====================================================================================");
    System.out.println(" "); // end of function spacer
  }


  /**
   * Write to CSV file
   *
   * <p>
   *   Writes a list of employees to a .csv file
   * </p>
   *
   * @param file_name no .csv needed
   * @param content list of Employees
   */
  public static void WriteTOCSV(String file_name, List<Employee> content) {
    // Write to file (includes .csv into the file name)
    try (PrintWriter writer = new PrintWriter(new FileWriter(file_name + ".csv"))) {

      // Format decimals to 2 places and not 17 character strings
      DecimalFormat df = new DecimalFormat("0.00");

      // Write data rows
      for (Employee e : content) {
        // Convert Employee data to a single string with a comma to separate all te values
        String sb = e.GetID() + "," +
                e.GetName() + "," +
                df.format(e.GetHourlyRate()) + "," +
                df.format(e.GetHoursWorked()) + "," +
                df.format(e.GetDeductionProvince()) + "," +
                df.format(e.GetDeductionFederal()) + "," +
                df.format(e.GetEducationAllowance()) + ",";

        // push to file
        writer.println(sb);
      }
    } catch (IOException e) {
      // System catch all for any file writing errors
      System.err.println("Error Writing CSV file: " + e.getMessage());
      e.printStackTrace();
    }
    System.out.println("CSV file created successfully");
  }

}

