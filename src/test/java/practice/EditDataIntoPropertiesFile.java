package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EditDataIntoPropertiesFile {

	public static void main(String[] args) throws IOException {
		//Read
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		//update
		pro.setProperty("application", "vtiger");
		//store
		FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\CommonData.properties");
		pro.store(fos, null);
		fis.close();

	}

}
