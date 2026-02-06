package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  static void main() {

    // ==================================================================================
    /*
     * Main Functionality Check list
     *
     *  (1) Get data from txt file
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

    // (2) Sort data by name & by salary (using the sorting methods)


    // (3) compare sorting algorithms times and print to console

    // (4) write data to 2 csv files (sortedemployeeBySalary.csv & sortedemployeeByName.csv)

    // (5) prompt user for name to search csv files for.

  }
}

/**
 * ReadFile function
 *<p>
 * Takes in a string of the file name, and return an output of a List of <Employee> objects
 *</p>
 *
 * @param file_name
 * @return List<Employee>
 */
// TODO: COMMENT THI SHIT
static List<Employee> ReadFile(String file_name) {

  List<Employee> result_empl = new ArrayList<>();


  try (Stream<String> lines = Files.lines(Paths.get(file_name))) {

    List<String> result_str = lines.toList();
    
  for (String item : result_str) {
    result_empl.add(EmployeeStringParser(item));
  }
    
    

  } catch (IOException e) {
    System.err.println("Error reading file: " + e.getMessage());
    e.printStackTrace();
  }

  return result_empl;
}


/**
 * Employee String Parser
 *
 * @param Comma separated String
 * @return Employee
 */

static Employee EmployeeStringParser(String s) {
  String[] parts = s.split(",");

  int id = Integer.parseInt(parts[0]);


  return new Employee(id, );
}