package project.utility.com;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class BrowserStartUtility {
   public static XSSFWorkbook workbooks;

    public BrowserStartUtility() throws IOException {

        File file = new File("src/main/resources/config/applicationUrls.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            workbooks = new XSSFWorkbook(fis);
        } catch (
                FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (file.exists()) {
                System.out.println("file available");
            } else {
                System.out.println("file not found");
            }
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        workbooks.write(outputStream);
    }

    public String getDataVlaues(int sheetno, int rowno, int cellno) {
        return workbooks.getSheetAt(sheetno).getRow(rowno).getCell(cellno).getStringCellValue();
    }
    public void setDataValues(int sheetno, int rowno, int cellno) {
      workbooks.getSheetAt(sheetno).getRow(rowno).createCell(cellno).setCellValue("step verified");
    }

}