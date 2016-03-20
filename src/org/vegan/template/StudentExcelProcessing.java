/**
 * 
 */
package org.vegan.template;

import org.apache.poi.ss.usermodel.Cell;
import org.vegan.model.Student;

/**
 * @author u326406
 *
 */
public class StudentExcelProcessing extends ExcelFileManagerTemplate<Student> implements INumericColumns, IStringColumns {
	
	

	@Override
	public void mapStringColumns() {
		if(cell.getColumnIndex() == 1)  // column 1 in Excel file.
			t.setFirstName(cell.getStringCellValue());
		else if (cell.getColumnIndex() == 2)  // column 3 in the Excel file.
			t.setLastName(cell.getStringCellValue());
		else if (cell.getColumnIndex() == 3)
			t.setYear(cell.getStringCellValue());
		else if (cell.getColumnIndex() == 4)
			t.setMajor(cell.getStringCellValue());
		
	}

	@Override
	public void mapNumericColumns() {
		if(cell.getColumnIndex() == 0)  // column 1 in Excel file.
			t.setId((int) cell.getNumericCellValue());
		else if (cell.getColumnIndex() == 5)  // column 3 in the Excel file.
			t.setGpa(cell.getNumericCellValue());
	}

	@Override
	protected void setMappingObjects(Student stu, Cell cell) {
		super.t = stu;
		super.cell = cell;
		
	}

}
