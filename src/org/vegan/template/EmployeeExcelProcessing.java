/**
 * 
 */
package org.vegan.template;

import org.apache.poi.ss.usermodel.Cell;
import org.vegan.model.Employee;

/**
 * @author u326406
 *
 */
public class EmployeeExcelProcessing extends ExcelFileManagerTemplate<Employee> implements INumericColumns, IStringColumns {

	/* (non-Javadoc)
	 * @see org.vegan.template.ExcelFileManager#processBasedOnCellType(org.vegan.model.Employee, org.apache.poi.ss.usermodel.Cell)
	 */
	//@Override
	
	
	
	@Override
	public void mapStringColumns() {
		t.setName(cell.getStringCellValue());  // column 2 in the Excel File.
	}



	/**
	 * Custom method that maps the data types in the cells to the column in the Excel spreadsheet.
	 */
	@Override
	public void mapNumericColumns() {
		if(cell.getColumnIndex() == 0)  // column 1 in Excel file.
			t.setEmpId((int) cell.getNumericCellValue());
		else if (cell.getColumnIndex() == 2)  // column 3 in the Excel file.
			t.setSalary(cell.getNumericCellValue());
	}



	@Override
	protected void setMappingObjects(Employee emp, Cell cell) {
		super.t = emp;
		super.cell = cell;
	}

}
