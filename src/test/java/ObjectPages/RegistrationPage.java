package ObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {

    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div[1]/img")
    @CacheLookup
    WebElement RegistrationImageLocator;

    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div[2]/h1")
    @CacheLookup
    WebElement RegistrationHeadingLocator;

    @FindBy(how = How.CLASS_NAME,using = "CustomLabel-sc-sr3jcr-8 bvreQc")
    @CacheLookup
    List<WebElement> ListLabelNames;

    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div[2]/form/button")
    @CacheLookup
    WebElement RegisterNowBtnLocator;



    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div[2]/form/p")
    @CacheLookup
    WebElement ErrorMessageLocator;

    @FindBy(how = How.XPATH,using = "//*[@id='name']")
    @CacheLookup
    WebElement NameFieldLocator;


    @FindBy(how = How.ID, using = "topic")
    public WebElement logStatusList;
    public Select selectLogStatus() {
        return new Select(logStatusList);
    }


    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/h1")
    @CacheLookup
    WebElement HelloNameLocator;

    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/p")
    @CacheLookup
    WebElement TopicSelectLocator;





    //______________________________________________________
    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement findRegistrationImage(){
        return RegistrationImageLocator;

    }

    public String getHeadingRegistration(){
        return RegistrationHeadingLocator.getText();
    }

    public String getLabelText(int index){
        return ListLabelNames.get(index).getText();
    }

    public void clickOnRegisterNowBtn(){
        RegisterNowBtnLocator.click();
    }

    public String getErrorMessageText(){
        return ErrorMessageLocator.getText();
    }

    public void enterNameField(String name){
        NameFieldLocator.sendKeys(name);
    }


    public void selectTopic(String value){
        selectLogStatus().selectByValue(value);
    }

    public String getHelloName(){
        return HelloNameLocator.getText();
    }

    public String getWelcomeTopic(){
        return TopicSelectLocator.getText();
    }
}
