package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class proportiesFileLoader {

	public String getProporty(String requiredProporty) throws IOException {
		File file = new File("C:\\Users\\asus\\git\\ninjaTutirial_CompleteProject\\project_code\\src\\main\\resources\\config.properties");
		FileInputStream fis =new FileInputStream(file);
		Properties pro =  new Properties();
		
		pro.load(fis);
		String proporty = pro.getProperty(requiredProporty);
////		System.out.println(proporty);
//		Properties pro = new Properties();
//		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
//			String proporty = pro.getProperty(requiredProporty);
//			if (input == null) {
//				throw new IOException("config.properties file not found in resources");
//			}
			return proporty;

		}
	
}
