package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelUtil {

    // Get a cell's content
    public XSSFCell getCell(int row, int column, int sheetIndex, String filepath) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filepath);
             Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            return (XSSFCell) sheet.getRow(row).getCell(column);
        }
    }

    // Get the number of rows in a sheet
    public int getRowSize(String filepath, int sheetIndex) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filepath);
             Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            return sheet.getLastRowNum() + 1; // Adjust for 0-based index
        }
    }
}