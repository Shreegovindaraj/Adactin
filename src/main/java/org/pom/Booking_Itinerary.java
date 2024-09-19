package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Booking_Itinerary {
    WebDriver driver;

    public Booking_Itinerary(WebDriver driver){
        this.driver = driver;
    }
    public By ordertText = By.xpath("//input[@id='order_id_text']");
    public By clickGo = By.xpath("//input[@id='search_hotel_id']");

    public void enterText(String orderNo){
        driver.findElement(ordertText).sendKeys(orderNo);
    }
    public void selectGo(){
        driver.findElement(clickGo).click();
    }

}
