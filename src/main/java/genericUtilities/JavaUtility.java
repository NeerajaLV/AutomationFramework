package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic methods to use java utilities
 * @author neera
 */
public class JavaUtility {
	/**
	 * This method returns current date and time in 'DD-MM-YY hh-mm-ss' format
	 * @return
	 */
	public String getDate() {
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-yy hh-mm-ss");
		String date=f.format(d);
		return date;
	}
}
