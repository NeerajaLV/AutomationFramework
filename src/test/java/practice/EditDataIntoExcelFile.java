package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EditDataIntoExcelFile {

	public static void main(String[] args) throws Throwable {
		//Read File
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fise);
		//update
		Sheet sheet=book.getSheet("Contacts");
		Row row=sheet.createRow(13);
		Cell cell=row.createCell(2);
		cell.setCellValue("Harsha");
		//write
		FileOutputStream fose=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		book.write(fose);
		book.close();
	}

}
