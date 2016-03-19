/**
 * 
 */
package org.vegan.template;

import java.io.IOException;
import java.util.List;

import org.vegan.model.Employee;
import org.vegan.model.Student;

/**
 * @author u326406
 *
 */
public class TemplateDemo {
	
	public static String EMPLOYEE_INPUT_FILE = "C:\\design_patterns_files\\Employees.xlsx";
	public static String STUDENT_INPUT_FILE = "C:\\design_patterns_files\\Students.xlsx";

	

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args){
		
		ExcelFileManagerTemplate<Employee> empManager = new EmployeeExcelProcessing();
		ExcelFileManagerTemplate<Student> stuManager = new StudentExcelProcessing();
		
		try {
			//To increase flexibility, the Template uses generics, so we need to send this call an Employee class, 
			//so the class can build lists of Employee objects.
			List<Employee> lstEmp = empManager.loadFileContentsIntoList(EMPLOYEE_INPUT_FILE, Employee.class);
			
			for (Employee employee : lstEmp) {
				System.out.println("Emp id:  " + employee.getEmpId() + ", name:  " + employee.getName() + ", salary:  " + employee.getSalary());
			}
			
			System.out.println("\nProcess Student Data\n");
			//Process student spreadsheet.
			List<Student> lstStu = stuManager.loadFileContentsIntoList(STUDENT_INPUT_FILE, Student.class);
			
			for (Student student : lstStu) {
				System.out.println("Student id:  " + student.getId() + ", " + student.getFirstName() + ", last name:  " + student.getLastName() + ", year:  " + student.getYear() + ", major:  " + student.getGpa());
			}
			
		} catch (IOException | InstantiationException | IllegalAccessException e) {
			System.err.println("We have problems in the Template Demo:  " + e.getMessage());
			e.printStackTrace();
		}

	}

}
