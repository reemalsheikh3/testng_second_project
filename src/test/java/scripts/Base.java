package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.UnitedAirlinesHomePage;
import pages.UnitedAirlinesResultsPage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    UnitedAirlinesHomePage unitedAirlinesHomePage;
    Actions actions;
    UnitedAirlinesResultsPage unitedAirlinesResultsPage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        unitedAirlinesHomePage = new UnitedAirlinesHomePage(driver);
        actions = new Actions(driver);
        unitedAirlinesResultsPage = new UnitedAirlinesResultsPage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}

