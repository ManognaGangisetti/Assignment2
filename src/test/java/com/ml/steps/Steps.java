package com.ml.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CompendiumPages;

public class Steps {
    WebDriver driver;
    CompendiumPages compendiumevPages;
    @Before
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Given("launching the browser")
    public void launching_the_browser() {
        driver.manage().window().maximize();

        driver.get("https://compendiumdev.co.uk/");

        compendiumevPages=new CompendiumPages(driver);

        System.out.println("Launching the browser");
    }
    @When("opening the compendiumdev page")
    public void opening_the_compendiumdev_page() {
        System.out.println("Opening the compendiumdev page");
    }
    @Then("clicking the contact")
    public void clicking_the_contact() throws InterruptedException {

        compendiumevPages.contactButton();
        System.out.println("Clicking the contact");
    }
    @And("filling the form")
    public void filling_the_form() throws InterruptedException {
        Thread.sleep(2000);
        compendiumevPages.nameForm();

        System.out.println("Filling the form");
    }
    @Then("clicking the submit")
    public void clicking_the_submit() throws InterruptedException {
        compendiumevPages.submit();
        System.out.println("Clicking the submit");

    }
    @And("close browser")
    public void close_browser() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(compendiumevPages.verification());
        System.out.println("Close browser");

    }
    @After
    public void killSession(){
       // driver.quit();
    }

}
