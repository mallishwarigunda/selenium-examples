package com.uooconnect.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class opens the browser by taking urls from excel sheet
 */
public class BrowserStart {
    static WebDriver driver;
    static int sheet1count;
    static BrowserStartUtility startUtility = new BrowserStartUtility();

    public static void invokeBrowser() throws InterruptedException {
        /**
         * Getting Excel sheet from the file.
         */
        XSSFSheet sheet1 = BrowserStartUtility.workbooks.getSheetAt(0);
        sheet1count = sheet1.getPhysicalNumberOfRows();
        String url = startUtility.getDataVlaues(0, 1, 1);
        System.out.println(url);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        String acturl = driver.getCurrentUrl();
        /**
         * verifing the url with actual url
         */
        if (acturl.equals(acturl)) {

            System.out.println("url verified");
        } else {
            System.out.println("url failed");
        }
        Thread.sleep(3000);
        driver.close();
    }
}
