package org.pom;

import org.Base.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search_Hotel extends Base_Class {
    WebDriver driver;

    public Search_Hotel(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    public By locationDropdown = By.id("location");
    public By hotelsDropdown = By.id("hotels");
    public By roomTypeDropdown = By.id("room_type");
    public By numberOfRoomsDropdown = By.id("hotels");
    public By checkIn = By.id("datepick_in");
    public By checkOut = By.id("datepick_out");
    public By adultsPerRoom = By.id("adult_room");
    public By childPerRoom = By.id("child_room");
    public By searchButton = By.id("Submit");
    public By radioBtn = By.xpath("//input[@id='radiobutton_0']");
    public By ctn = By.xpath("//input[@id='continue']");

    // Actions
    public void selectLocation(String location) {
        driver.findElement(locationDropdown).sendKeys(location);
    }
    public void selectHotel(String hotel) {
        driver.findElement(hotelsDropdown).sendKeys(hotel);
    }
    public void selectType(String type) {
        driver.findElement(roomTypeDropdown).sendKeys(type);
    }
    public void selectNumberOfRooms(String rooms) {
        driver.findElement(numberOfRoomsDropdown).sendKeys(rooms);
    }
    public void selectCheckIn(String DateIn){
        driver.findElement(checkIn).sendKeys(DateIn);
    }
    public void selectCheckOut(String DateOut){
        driver.findElement(checkOut).sendKeys(DateOut);
    }
    public void selectAdultPerRoom(String Adults){
        driver.findElement(adultsPerRoom).sendKeys(Adults);
    }
    public void selectChildPerRoom(String Children){
        driver.findElement(childPerRoom).sendKeys(Children);
    }
    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
    public  void clickRadioBtn(){
        driver.findElement(radioBtn).click();
    }
    public  void clickCtn(){
        driver.findElement(ctn).click();
    }
}
