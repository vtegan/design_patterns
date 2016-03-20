/**
 * 
 */
package org.vegan.model;

/**
 * @author tegan
 *
 */
public class Employee {
	
	private int empId;
	private String name;
	private double salary;
	
	public Employee(int empId, String name, double salary) {
	
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	
	
	public Employee() {
		
	}
	

	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	// getters


	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}
