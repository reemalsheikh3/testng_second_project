package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedAirlinesHomePage {

    public UnitedAirlinesHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[role='tablist']>a")
    public List<WebElement> mainMenuNavigation;

    @FindBy(css = "ul[class='app-components-BookTravel-bookTravel__travelNav--3RNBj']>li")
    public List<WebElement> bookTravelMenu;

    @FindBy(xpath = "//label[@for='roundtrip']//span[2]")
    public WebElement roundTripRadioButton;

    @FindBy(xpath = "//label[@for='roundtrip']//span[1]")
    public WebElement roundTripRadioButtonText;

    @FindBy(xpath = "//label[@for='oneway']//span[2]")
    public WebElement oneWayRadioButton;

    @FindBy(xpath = "//label[@for='oneway']//span[1]")
    public WebElement oneWayRadioButtonText;

    @FindBy(css = "#award")
    public WebElement bookWithMilesCheckBox;

    @FindBy(xpath = "//div[@aria-label='Book with miles']//span")
    public WebElement bookWithMilesCheckBoxText;

    @FindBy(css = "#flexibleDates")
    public WebElement flexibleDatesCheckBox;

    @FindBy(xpath = "//div[@aria-label='Flexible dates']//span")
    public WebElement flexibleDatesCheckBoxText;

    @FindBy(css = "#bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(css = "#autocomplete-item-0>button")
    public WebElement autoCompleteFromInputBox;

    @FindBy(css = "#bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement dateInputBox;

    @FindBy(css = "#passengerSelector")
    public WebElement travelerSelector;

    @FindBy(css = "#cabinType")
    public WebElement cabinDropDown;

    @FindBy(css = "button[aria-label='Find flights']")
    public WebElement findFlightsButton;
}
