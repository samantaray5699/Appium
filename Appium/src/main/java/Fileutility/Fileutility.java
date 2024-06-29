package Fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {

	public String getdataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\adity\\eclipse-workspace\\Appium\\src\\main\\resources\\CommonData.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String value= pobj.getProperty(key);
		return value;
	}
}
