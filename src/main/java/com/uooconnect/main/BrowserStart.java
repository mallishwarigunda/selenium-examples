package com.uooconnect.main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import project.utility.com.BrowserStartUtility;

import java.io.IOException;

public class BrowserStart {
    static WebDriver driver;
    static int sheet1count;
    static BrowserStartUtility startUtility;

    static {
        try {
            startUtility = new BrowserStartUtility();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

       XSSFSheet sheet1 = BrowserStartUtility.workbooks.getSheetAt(0);
       sheet1count = sheet1.getPhysicalNumberOfRows();
        System.out.println(sheet1count);
        String url = startUtility.getDataVlaues(0,1,1);
        System.out.println(url);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        String acturl=driver.getCurrentUrl();
        if(acturl.equals(acturl)) {
             startUtility.setDataValues(0,1,2);
             String status = startUtility.getDataVlaues(0,1,2);
            System.out.println(status);
        }else {
            System.out.println("step failed");
        }

        driver.close();
    }
}
