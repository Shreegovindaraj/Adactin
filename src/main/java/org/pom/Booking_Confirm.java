package org.pom;

import org.Base.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Booking_Confirm extends Base_Class {
    WebDriver driver;
    private String orderNo;
    public  Booking_Confirm(WebDriver driver){
        this.driver = driver;
    }
    public By getOrderNo = By.xpath("//input[@id='order_no']");
    public By itinerary = By.xpath("//input[@id='my_itinerary']");

    public void selectOrder(){
        WebElement order = driver.findElement(getOrderNo);
        orderNo = order.getAttribute("value");
        System.out.println("Order NO :"+ orderNo);
    }
    public String getOrderNumber() {
        return orderNo;
    }
    public void clickItinerary(){
        driver.findElement(itinerary).click();
    }
}
