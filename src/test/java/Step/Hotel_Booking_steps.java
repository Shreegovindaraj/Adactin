package Step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Base.Base_Class;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pom.*;

import java.time.Duration;

import static org.Base.Base_Class.driver;

public class Hotel_Booking_steps {
    Login_Page loginPage;
    Search_Hotel searchHotelPage;
    Book_Hotel bookHotel;
    Booking_Confirm BookingConfirm;
    Booking_Itinerary BookingItinerary;

    @Given("I am on the Adactin Hotel login page")
    public void i_am_on_the_adactin_hotel_login_page() {
        driver.get("https://adactinhotelapp.com/");
        loginPage = new Login_Page(driver);
        searchHotelPage = new Search_Hotel(driver);
        bookHotel = new Book_Hotel(driver);
        BookingConfirm = new Booking_Confirm(driver);
        BookingItinerary = new Booking_Itinerary(driver);
    }

    @When("I log in with username {string} and password {string}")
    public void i_log_in_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I verifies the new page contains expected URL")
    public void iVerifiesTheNewPageContainsExpectedURL() {
        String currentUrl = driver.getCurrentUrl();
        boolean contains = currentUrl.contains("SearchHotel.php");
        Assert.assertTrue(currentUrl,contains);
    }

    @And("I verifies the new page contains expected text")
    public void iVerifiesTheNewPageContainsExpectedText() {
        loginPage.text();
    }
    @And("I verifies log out button is Displayed on the page")
    public void iVerifiesLogOutButtonIsDisplayedOnThePage() {
        WebElement logout = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/a[text()='Logout']"));
        boolean displayed = logout.isDisplayed();
        Assert.assertTrue(displayed);
    }
    @When("I search for a hotel with location {string} and hotel {string}")
    public void i_search_for_a_hotel_with_location_and_hotel(String location, String hotel) throws InterruptedException {
        searchHotelPage.selectLocation(location);
        searchHotelPage.selectHotel(hotel);
        Thread.sleep(3000);
    }
    @When("I select the Room Type {string} and Number of Rooms {string}")
    public void iSelectTheRoomTypeAndNumberOfRooms(String type, String rooms) throws InterruptedException {
        searchHotelPage.selectType(type);  // Use the method argument roomType
        searchHotelPage.selectNumberOfRooms(rooms);  // Use the method argument numberOfRooms
        Thread.sleep(3000);
    }
    @Then("I select the Check In Date {string} and Check Out Date {string}")
    public void iSelectTheCheckInDateAndCheckOutDate(String DateIn, String DateOut) throws InterruptedException {
        searchHotelPage.selectCheckIn(DateIn);
        searchHotelPage.selectCheckOut(DateOut);
        Thread.sleep(3000);
    }
    @And("I select the Adults per Room {string} and Children per Room {string}")
    public void iSelectTheAdultsPerRoomAndChildrenPerRoom(String Adults, String Children) throws InterruptedException {
        searchHotelPage.selectAdultPerRoom(Adults);
        searchHotelPage.selectChildPerRoom(Children);
        searchHotelPage.clickSearch();
        searchHotelPage.clickRadioBtn();
        searchHotelPage.clickCtn();
        Thread.sleep(3000);
    }
    @Then("I verifies the new page contains expected book URL")
    public void iVerifiesTheNewPageContainsExpectedBookURL() {
        String bkURL = driver.getCurrentUrl();
        boolean BookURl = bkURL.contains("BookHotel.php");
        Assert.assertTrue(BookURl);
    }
    @When("I enter the firstname {string} and lastname {string}")
    public void iEnterTheFirstNameAndLastName(String firstname, String lastname) throws InterruptedException {
        bookHotel.enterFirstname(firstname);
        bookHotel.enterLastname(lastname);
        Thread.sleep(3000);
    }
    @Then("I enter the Billing Address {string}")
    public void iEnterTheBillingAddress(String address) throws InterruptedException {
        bookHotel.enterAddress(address);
        Thread.sleep(3000);
    }
    @And("I enter the Credit Card No {string}")
    public void iEnterTheCreditCardNo(String creditcard) {
        bookHotel.selectCredit(creditcard);
    }
    @And("I select the Credit Card Type {string}")
    public void iSelectTheCreditCardType(String creditcardtype) {
        bookHotel.selectCreditCardTYpe(creditcardtype);
    }
    @Then("I select the Expiry Date Month {string} and Year {string}")
    public void iSelectTheExpiryDateMonthAndYear(String month, String year) throws InterruptedException {
        bookHotel.selectMonth(month);
        bookHotel.selectYear(year);
        Thread.sleep(3000);
    }
    @And("I enter the CVV Number {string}")
    public void iEnterTheCVVNumber(String cvv) throws InterruptedException {
        bookHotel.selectCvv(cvv);
        bookHotel.selectBookNow();
        Thread.sleep(25000);
    }
    @Then("I verifies the new page contains expected booking URL")
    public void iVerifiesTheNewPageContainsExpectedBookingURL() throws InterruptedException {
        String BookingURl = driver.getCurrentUrl();
        boolean contains = BookingURl.contains("BookingConfirm.php");
        Assert.assertTrue(contains);
        Thread.sleep(3000);
    }
    @And("I retrieve the booking Order No")
    public void iGetTheGetTheBookingOrderNo() {
        BookingConfirm.selectOrder();
        BookingConfirm.clickItinerary();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
    }
    @When("I input the retrieve order no into Search Order ID")
    public void iInputTheRetrieveOrderNoIntoSearchOrderID() {
        String orderNo = BookingConfirm.getOrderNumber();
        BookingItinerary.enterText(orderNo);
        BookingItinerary.selectGo();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(25));
    }
    @Then("I verify the final page and take a screenshot")
    public void iVerifyTheFinalPageAndTakeAScreenshot() {
        Base_Class.takeScreenshot("final_page_screenshot");
    }

}
