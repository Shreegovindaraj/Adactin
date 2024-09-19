package org.pom;

import org.Base.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page extends Base_Class {
    WebDriver driver;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    public By usernameField = By.xpath("//input[@id='username']");
    public By passwordField = By.xpath("//input[@id='password']");
    public By loginButton = By.xpath("//input[@id='login']");
    public By actualText = By.xpath("//input[@id='username_show']");

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void text(){
        driver.findElement(actualText).getText();
    }
}


