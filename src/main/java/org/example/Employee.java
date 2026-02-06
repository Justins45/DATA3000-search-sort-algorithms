package org.example;

public class Employee {

  private int  _id;
  private String _name;
  private double _hours_worked;
  private double _hourly_rate;
  private double _deduction_province;
  private double _deduction_federal;
  private double _education_allowance;


  public Employee(int id,
                  String name,
                  double hours_worked,
                  double hourly_rate,
                  double deduction_province,
                  double deduction_federal,
                  double education_allowance) {
    this._id = id;
    this._name = name;
    this._hours_worked = hours_worked;
    this._hourly_rate = hourly_rate;
    this._deduction_province = deduction_province;
    this._deduction_federal = deduction_federal;
    this._education_allowance = education_allowance;
  }

  // GETTERS
  public int GetID() {
    return this._id;
  }
  public String GetName() {
    return this._name;
  }
  public double GetHoursWorked() {
    return this._hours_worked;
  }
  public double GetHourlyRate() {
    return this._hourly_rate;
  }
  public double GetDeductionProvince() {
    return this._deduction_province;
  }
  public double GetDeductionFederal() {
    return this._deduction_federal;
  }
  public double GetEducationAllowance() {
    return this._education_allowance;
  }

  // SETTERS
  public void SetID(int new_id) {
    this._id = new_id;
  }
  public void SetName(String new_name) {
    this._name = new_name;
  }
  public void SetHoursWorked(double new_hours_worked) {
    this._hours_worked = new_hours_worked;
  }
  public void SetHourlyRate(double new_hourly_rate) { this._hourly_rate = new_hourly_rate; }
  public void SetDeductionProvince(double new_deduction_p) {
    this._deduction_province = new_deduction_p;
  }
  public void SetDeductionFederal(double new_deduction_f) {
    this._deduction_federal = new_deduction_f;
  }
  public void SetEducationAllowance(double new_edu_allowance) {
    this._education_allowance = new_edu_allowance;
  }

  // METHODS

  public double CalcHourlySalary() {
    // implement hourly salary
    return 0.0;
  }




}
