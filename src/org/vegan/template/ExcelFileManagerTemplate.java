/**
 * 
 */
package org.vegan.template;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




/**
 * Manages Excel file operations.  Allows the client to enter an Excel file and to load the results into a list of value object.
 * This class uses the Template Design Pattern, because most of the code is repetitive, except for a few small lines of code.
 * That customization gets written in a sub class that overrides the processBasedOnCellType method.
 * 
 * Also, this class uses generics, so we can be flexible and add any type of value object that we want.
 * 
 * @author u326406
 *
 */
public abstract class ExcelFileManagerTemplate<T> {

	protected T t;
	protected Cell cell;



	public final List<T> loadFileContentsIntoList(String inputFile, Class<T> cls) throws IOException, InstantiationException, IllegalAccessException{


		List<T> lstValueObject = new ArrayList<>();

		FileInputStream file = new FileInputStream(new File(inputFile));

		//Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);  //TODO:  We might have to parameterize this line, because we may want different lines of code.

		//In order to display all of the values, we need to do the following

		//1.  Create a rowIterator, which can be produced from the sheet object.
		//2.  Produce a Row object, which can be produced from the rowIterator's hasNext() method.
		//3.  Create a cellIterator, which can be produced from the Row object's cellIterator() method.
		//4.  Create a Cell object, which can be produced from the cellIterator's next() method.

		//Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();  // loop through each row.
		while (rowIterator.hasNext())
		{
			Row row = rowIterator.next();
			//For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();  // for each row, loop through each column.

			//Note:  if you instantiate a type, then you will get a cannot instantiate type t error. 
			//T t = new T();  //generates a compiler error.  
			T t = cls.newInstance();  //Create a new instance of the Type instead.

			while (cellIterator.hasNext())  // loop through each cell in the row.
			{
				//Process each cell.
				Cell cell = cellIterator.next();

				//Template Design Pattern  
				//The code below needs to be custom built based on the type of data that exist in the column.
				//       This makes the processing difficult to reuse.  My vision would be to create a template design pattern that 
				//       Would make this method the template and the processBasedOnCellType method that gets customized.
				//Check the cell type and format accordingly
				setMappingObjects(t, cell);
				processBasedOnCellType();  // This is the piece that varies, so the subclass will figure out how this works.
			}
			lstValueObject.add(t);
		}

		//TODO:  Try to use Java 7's auto close feature.
		//clean up.
		file.close();
		workbook.close();

		//Remove the first column, because we don't want to see the header.
		lstValueObject.remove(0);  //TODO:  This code assumes we are removing the header, which should be at the top of the Excel file.

		return lstValueObject;
	}


	/**
	 * Method performs the customization for mapping data types of each Excel cell and ensures that the data from the
	 * Excel file gets mapped to the proper column using the appropriate value object.
	 * 
	 * @param t  A generic data type that enables the client to choose any Value Object.
	 * @param cell  Represents the cell from an Excel file.
	 */
	//protected abstract void processBasedOnCellType();
	protected void processBasedOnCellType() {
		//TODO:  See if we can replace this code with a factory.
		//cell.getCellType() returns numbers such as 1 or 0.
		switch (cell.getCellType())
		{
		case Cell.CELL_TYPE_NUMERIC:  // this equals 0.
			mapNumericColumns();
			break;
		case Cell.CELL_TYPE_STRING:  // this equals 1.
			mapStringColumns();
			break;
		}

	}

	protected abstract void setMappingObjects(T t, Cell cell);
	protected abstract void mapNumericColumns();
	protected abstract void mapStringColumns();

}
