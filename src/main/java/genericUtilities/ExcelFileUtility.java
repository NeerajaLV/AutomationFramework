package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to use excel file 
 * @author neera
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel file and return value to the caller
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheet, int row, int col) throws EncryptedDocumentException, IOException
	{
		FileInputStream rfise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(rfise);
		String value=book.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		return value;
	}
	public void writeDataToExcelFile(String sheet, int row, int col, String value) throws EncryptedDocumentException, IOException {
		FileInputStream wfise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(wfise);
		book.getSheet(sheet).createRow(row).createCell(col).setCellValue(value);
		FileOutputStream fose=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		book.write(fose);
		book.close();
	}
}
