package pages;
import com.SeleniumActions.SeleniumActions;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompendiumPages {
    WebDriver driver;
    SeleniumActions seleniumActions;
    public CompendiumPages(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='cssmenu']/ul/li[2]/a[text()='Contact']")
    WebElement contact;
    @FindBy(xpath = "//input[@name='name']")
    WebElement name;
    @FindBy(xpath = "//input[@name='email']")
    WebElement email;
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement message;
    @FindBy(xpath = "//div[@role='checkbox']")
    WebElement checkbox;
    @FindBy(xpath = "//div[@role='button']")
    WebElement submit;
    @FindBy(xpath = "//div[@class='SuccessMessage']")
    WebElement verify;
    public void contactButton(){
        seleniumActions.clickOnElement(contact);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
    }

    public void nameForm(){
        seleniumActions.EnterValueOnTextfield(name,"manu");
        seleniumActions.EnterValueOnTextfield(email,"manogna@gmail.com");
        seleniumActions.EnterValueOnTextfield(message,"$$$$$$$$$$$$$MONEY$$$$$$$$$$$$$");
        seleniumActions.clickOnElement(checkbox);
    }
    public void submit() throws InterruptedException {
        Thread.sleep(2000);
        seleniumActions.javascriptExcecutorClick(submit);

    }
    public boolean verification(){
       return verify.isDisplayed();

    }

}