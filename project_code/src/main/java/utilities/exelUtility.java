package utilities;

import java.io.IOException;

public class exelUtility {
	public String path;

	public exelUtility(String path) {
		this.path = path;
	}

	public void updateResult(String testCaseStatus, int testRunNum) throws IOException {
		
		XLutility exelUtility = new XLutility(path);
		int row = exelUtility.getRowCount("Sheet1");
		int col = exelUtility.getCellCount("Sheet1", 0);

		for (int r = 0; r <= row; r++) {
			for (int c = 0; c < col; c++) {
				String exelHeading = exelUtility.getCellData("Sheet1", r, c);
				
				if (exelHeading.equalsIgnoreCase("Test Result")) {
					exelUtility.testResult("Sheet1", r  + 1 + testRunNum, c, testCaseStatus);
				}
//				else if (exelHeading.equalsIgnoreCase("passed")) {
//					r++;
//					exelUtility.testResult("Sheet1", r + 1 , c, testCaseStatus);
//					
//				}
			}
			

			
		}
	}
}
