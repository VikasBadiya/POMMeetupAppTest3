package TestScenarios;

import ObjectPages.RegistrationPage;
import ObjectPages.WelcomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationPageTest {
    WebDriver driver;
    WebDriverWait wait;
    WelcomePage WPage;
    RegistrationPage RPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WPage = new WelcomePage(driver);
        RPage = new RegistrationPage(driver);
        driver.get("https://qameetup.ccbp.tech/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    //Test the UI of the Registration Page
    @Test(priority = 1)
    public void TestUIRegistrationPage(){
        //Navigate to the URL https://qameetup.ccbp.tech/
        //Click the "Register" button to navigate to the Registration page.
        WPage.RegisterBtnMeetUp();

        //Verify if the App logo is displayed - use Assertions,
        //If the App logo is not displayed, print "App logo is not displayed"

        Assert.assertTrue(WPage.findMeetUpLogoImage().isDisplayed(),"App logo is not displayed");

        //Wait and verify if the Register image is displayed - use Assertions,
        //If the Register image is not displayed, print "Register image is not displayed"

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[1]/img")));

        Assert.assertTrue(RPage.findRegistrationImage().isDisplayed(),"App logo is not displayed");

        //Verify the Heading text of the page - use Assertions
        //Expected text: Let us join
        //If the Heading text does not match the expected text, print "Heading text does not match"

        Assert.assertEquals(RPage.getHeadingRegistration(),"Let us join","Heading text does not match");

        //Verify the Name label text - use Assertions,
        //Expected text: NAME
        //If the Label text does not match the expected text, print "Name label text does not match"

        Assert.assertEquals(RPage.getLabelText(0),"NAME","Name label text does not match");

        //Verify the Topics label text - use Assertions,
        //Expected text: TOPICS
        //If the Label text does not match the expected text, print "Topics label text does not match"
        Assert.assertEquals(RPage.getLabelText(1),"TOPICS","Topics label text does not match");
        //Close the browser window.

    }
    //Test the Functionality of the Registration Page with empty name field

    @Test(priority = 2)
    public void TestFunctionalityRPageEmptyName(){
        //Navigate to the URL https://qameetup.ccbp.tech/
        //Click the "Register" button to navigate to the Registration page
        WPage.RegisterBtnMeetUp();
          //Click the "Register Now" button.
        RPage.clickOnRegisterNowBtn();

        //Verify the error message - use Assertions,
        //Expected text: Please enter your name
        //If the error message does not match the expected text, print "Error text with empty input field does not match"

        Assert.assertEquals(RPage.getErrorMessageText(),"Please enter your name","Error text with empty input field does not match");
        //Close the browser window.

    }

    @DataProvider(name= "dataSet")
    public Object[][]DataSet(){
        return new Object[][]{{"Jack","ARTS_AND_CULTURE","Arts and Culture"},{"Jerry","CAREER_AND_BUSINESS","Career and Business"},{"John","EDUCATION_AND_LEARNING","Education and Learning"},{"Jim","FASHION_AND_BEAUTY","Fashion and Learning"},{"Jane","GAMES","Games"}};

    }

    //Test the Functionality of the Registration Page with valid inputs
    @Test(priority = 3,dataProvider = "dataSet")
    public void TestFunctionalityRegistrationValidInput(String name ,String value,String text){
//        Navigate to the URL https://qameetup.ccbp.tech/
//        Click the "Register" button to navigate to the Registration page

        WPage.RegisterBtnMeetUp();
        //Enter the name in the "NAME" field
        RPage.enterNameField(name);

        //Select the corresponding option from the "TOPICS" dropdown.

        RPage.selectTopic(value);
        //Click the "Register Now" button.
        RPage.clickOnRegisterNowBtn();

        //Verify the navigation to the Welcome page - use Assertions,
        //Expected URL: https://qameetup.ccbp.tech/
        wait.until(ExpectedConditions.urlToBe("https://qameetup.ccbp.tech/"));

        //If the current URL does not match the expected URL, print "URLs do not match"
        Assert.assertEquals(driver.getCurrentUrl(),"https://qameetup.ccbp.tech/","URLs do not match");

        //Verify the Heading text of the page - use Assertions
        //Expected text: Hello <name>
        //If the Heading text does not match the expected text, print "Heading text does not match"

        Assert.assertEquals(RPage.getHelloName(),"Hello "+name,"Heading text does not match");

        //Verify the Description text of the page - use Assertions
        //Expected text: Welcome to <topic>
        //If the Description text does not match the expected text, print "Description text does not match"
        Assert.assertEquals(RPage.getWelcomeTopic(),"Welcome to "+text,"Description text does not match");
        //Close the browser window.




    }


}
