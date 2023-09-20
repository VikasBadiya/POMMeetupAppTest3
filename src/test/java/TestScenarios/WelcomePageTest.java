package TestScenarios;

import ObjectPages.WelcomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WelcomePageTest {
    WebDriver driver;
    WelcomePage WPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WPage = new WelcomePage(driver);
        driver.get("https://qameetup.ccbp.tech/");

    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    //Test the UI of the Welcome Page
    public void TestWelcomePageUI(){
        //Navigate to the URL https://qameetup.ccbp.tech/
        //Verify if the App logo is displayed - use Assertions,
        //If the App logo is not displayed, print "App logo is not displayed"
        Assert.assertTrue(WPage.findMeetUpLogoImage().isDisplayed(),"App logo is not displayed");

        //Verify the Heading text of the page - use Assertions
        //Expected text: Welcome to Meetup
        //If the Heading text does not match the expected text, print "Welcome to Meetup"

        Assert.assertEquals(WPage.getHeadingMeetUp(),"Welcome to Meetup","Welcome to Meetup");


        //Verify the Description text of the page - use Assertions
        //Expected text: Please register for the topic
        //If the Description text does not match the expected text, print "Description text does not match"

       Assert.assertEquals(WPage.getDescriptionMeetUpText(),"Please register for the topic","Description text does not match");

       //Verify if the Meetup image is displayed - use Assertions,
        //If the Meetup image is not displayed, print "Meetup image is not displayed"
        //Close the browser window.

        Assert.assertTrue(WPage.findMeetUpImage().isDisplayed(),"Meetup image is not displayed");
    }

    //Test the Functionality of the Welcome Page

    @Test(priority = 2)
    public void TestFunctionalityWelcomePage(){
        //Navigate to the URL https://qameetup.ccbp.tech/
        //Click the "Register" button.
        WPage.RegisterBtnMeetUp();
        //Verify the navigation to the registration page - use Assertions,
        //Expected URL: https://qameetup.ccbp.tech/register
        //If the current URL does not match the expected URL, print "URLs do not match"
        //Close the browser window.
        Assert.assertEquals(driver.getCurrentUrl(),"https://qameetup.ccbp.tech/register","URLs do not match");

    }


}
