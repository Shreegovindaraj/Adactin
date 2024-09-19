package org.pom;

import org.Base.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Book_Hotel extends Base_Class {
    WebDriver driver;

    public Book_Hotel(WebDriver driver) {
        this.driver = driver;
    }
//    Locators
    public By firstName = By.id("first_name");
    public  By lastName = By.id("last_name");
    public  By eadDress = By.xpath("//textarea[@id='address']");
    public By eCreditCard = By.xpath("//input[@id='cc_num']");
    public By eCreditCardType = By.xpath("//select[@id='cc_type']");
    public By sMonth = By.xpath("//select[@id='cc_exp_month']");
    public  By eSelectYear = By.xpath("//select[@id='cc_exp_year']");
    public By eSelectCvv = By.xpath("//input[@id='cc_cvv']");
    public By bookNowBtn = By.xpath("//input[@id='book_now']");

//    Action
    public void enterFirstname(String firstname){
        driver.findElement(firstName).sendKeys(firstname);
    }
    public void enterLastname(String lastname){
        driver.findElement(lastName).sendKeys(lastname);
    }
    public void enterAddress(String address){
        driver.findElement(eadDress).sendKeys(address);
    }
    public void selectCredit(String creditcard){
        driver.findElement(eCreditCard).sendKeys(creditcard);
    }
    public void selectCreditCardTYpe(String creditcardtype){
        driver.findElement(eCreditCardType).sendKeys(creditcardtype);
    }
    public void selectMonth(String month){
        driver.findElement(sMonth).sendKeys(month);
    }
    public void selectYear(String year){
        driver.findElement(eSelectYear).sendKeys(year);
    }
    public void selectCvv(String cvv){
        driver.findElement(eSelectCvv).sendKeys(cvv);
    }
    public void selectBookNow(){
        driver.findElement(bookNowBtn).click();
    }

}
