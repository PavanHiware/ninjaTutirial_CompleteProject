package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class proportiesFileLoader {

	public String getProporty(String requiredProporty) throws IOException {
		File file = new File("C:\\Users\\2110883\\project\\ninjaTutorialsWebsite\\confiFiles\\confi_proporties_File");
		FileInputStream fis =new FileInputStream(file);
		Properties pro =  new Properties();
		
		pro.load(fis);
		String proporty = pro.getProperty(requiredProporty);
//		System.out.println(proporty);
		return proporty;
					
	}
}
