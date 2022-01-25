package com.uooconnect.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * This class about initialization of ExcelFiles.It is a utility class for the BrowserStart.
 */
public class BrowserStartUtility {
    public static XSSFWorkbook workbooks;
    public BrowserStartUtility() {

        File file = new File("src/main/resources/config/applicationUrls.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            workbooks = new XSSFWorkbook(fis);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (file.exists()) {
                System.out.println("file available");
            } else {
                System.out.println("file not found");
            }
        }
    }
    public String getDataVlaues(int sheetNo, int rowNo, int cellno) {
        return workbooks.getSheetAt(sheetNo).getRow(rowNo).getCell(cellno).getStringCellValue();
    }
}