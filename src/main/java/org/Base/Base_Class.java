package org.Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class Base_Class {

    public static WebDriver driver;

    public void initializeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    // Method to capture a screenshot
    public static void takeScreenshot(String fileName) {
        // Cast driver to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Take screenshot and store it as a file
        File source = ts.getScreenshotAs(OutputType.FILE);
        // Define the destination path
        File destination = new File("./screenshots/" + fileName + ".png");
        try {
            // Copy the screenshot to the destination path
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    }



/*public static void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();  // Use specific browser driver
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();  // Use FirefoxDriver
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();  // Use EdgeDriver
        } else {
            throw new IllegalArgumentException("Browser not found");
        }
    }
    public static void openApplication(String url) {  // Correct type for String
        driver.get(url);  // Use get() with a String parameter for the URL
    }

    */



