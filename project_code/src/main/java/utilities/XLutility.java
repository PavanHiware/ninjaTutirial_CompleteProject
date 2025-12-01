package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutility {
	public FileInputStream fileinput;
	public OutputStream fileoutput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path = null;

	public XLutility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {
		fileinput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fileinput.close();
		return rowCount;

	}

	public int getCellCount(String sheetName, int rowNo) throws IOException {
		fileinput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		int coloumCount = row.getLastCellNum();
		workbook.close();
		fileinput.close();
		return coloumCount;

	}

	public String getCellData(String sheetName, int rowNo, int colNo) throws IOException {
		fileinput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		cell = row.getCell(colNo);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}

		workbook.close();
		fileinput.close();

		return data;

	}

	public void testResult(String sheetName, int rowNo, int colNo, String result) throws IOException {
		fileinput = new FileInputStream(path);

		workbook = new XSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		cell = row.getCell(colNo);

		style = workbook.createCellStyle();
		if (result.equalsIgnoreCase("Passed")) {
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		} else if (result.equalsIgnoreCase("Failed")) {
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		} else {
			style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		}
		
		cell.setCellValue(result);
		cell.setCellStyle(style);
		fileoutput = new FileOutputStream(path);
		workbook.write(fileoutput);
		workbook.close();
		fileinput.close();
		fileoutput.close();

	}
}
