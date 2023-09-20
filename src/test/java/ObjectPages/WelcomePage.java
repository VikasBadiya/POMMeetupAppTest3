package ObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    @FindBy(how = How.XPATH,using = "//*[@id='root']/img")
    @CacheLookup
    WebElement MeetUpLogoLocator;


    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/h1")
    @CacheLookup
    WebElement HeadingMeetUpLocator;


    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/p")
    @CacheLookup
    WebElement DescriptionMeetUpLocator;

    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/p")
    @CacheLookup
    WebElement ImageMeetUpLocator;


    @FindBy(how = How.XPATH,using = "//*[@id='registerButton']")
    @CacheLookup
    WebElement RegisterBtnMeetUpLocator;


    //______________________________________________________
    WebDriver driver;

    public WelcomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement findMeetUpLogoImage(){
        return MeetUpLogoLocator;
    }

    public String getHeadingMeetUp(){
        return HeadingMeetUpLocator.getText();
    }

    public String getDescriptionMeetUpText(){
        return DescriptionMeetUpLocator.getText();
    }

    public WebElement findMeetUpImage(){
        return ImageMeetUpLocator;
    }

    public void RegisterBtnMeetUp(){
        RegisterBtnMeetUpLocator.click();
    }
}