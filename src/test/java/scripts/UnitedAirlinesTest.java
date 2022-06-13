package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.security.Key;

public class UnitedAirlinesTest extends Base{

    @Test(priority = 1, description = "Test Case 1: Validate Main menu navigation items")
        public void testMainMenuNavDisplay(){
        driver.get("https://www.united.com/en/us");

        for (WebElement navItem : unitedAirlinesHomePage.mainMenuNavigation) {
            Assert.assertTrue(navItem.isDisplayed());
        }
    }

    @Test(priority = 2, description = "Test Case 2: Validate Book travel menu navigation items")
        public void testBookTravelMenu(){
        driver.get("https://www.united.com/en/us");
        for (WebElement travelMenuItems : unitedAirlinesHomePage.bookTravelMenu) {
            Assert.assertTrue(travelMenuItems.isDisplayed());
        }
    }

    @Test(priority = 3, description = "Test Case 3: Validate Round-trip and One-way radio buttons")
    public void testRoundTripAndOneWayRadioButtons(){
        driver.get("https://www.united.com/en/us");
        Waiter.waitUntilTextToBePresentInElement(driver, 30, unitedAirlinesHomePage.roundTripRadioButtonText, "Roundtrip");
        Assert.assertEquals(unitedAirlinesHomePage.roundTripRadioButtonText.getText(), "Roundtrip");
        Assert.assertTrue(unitedAirlinesHomePage.roundTripRadioButton.isEnabled());
        Assert.assertTrue(unitedAirlinesHomePage.roundTripRadioButton.isSelected());
        Assert.assertEquals(unitedAirlinesHomePage.oneWayRadioButtonText.getText(), "One-way");
        Assert.assertTrue(unitedAirlinesHomePage.oneWayRadioButton.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.oneWayRadioButton.isSelected());
        actions.click(unitedAirlinesHomePage.oneWayRadioButton).perform();
        Waiter.pause(2);
        Assert.assertTrue(unitedAirlinesHomePage.oneWayRadioButton.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.roundTripRadioButton.isSelected());
    }

    @Test(priority = 4, description = "Test Case 4: Validate Book with miles and Flexible dates checkboxes")
    public void testMilesAndDatesCheckBoxes(){
        driver.get("https://www.united.com/en/us");

        Assert.assertEquals(unitedAirlinesHomePage.bookWithMilesCheckBoxText.getText(), "Book with miles");
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());
        Assert.assertEquals(unitedAirlinesHomePage.flexibleDatesCheckBoxText.getText(), "Flexible dates");
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());
        actions.click(unitedAirlinesHomePage.bookWithMilesCheckBox).perform();
        actions.click(unitedAirlinesHomePage.flexibleDatesCheckBox).perform();
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected() && unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());
        actions.click(unitedAirlinesHomePage.bookWithMilesCheckBox).perform();
        actions.click(unitedAirlinesHomePage.flexibleDatesCheckBox).perform();
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());
    }

    @Test(priority = 5, description = "Test Case 5: Validate One-way ticket search results from Chicago, IL, US (ORD) to Miami, FL, US (MIA")
    public void testOneWayTicketSearchResults(){
        driver.get("https://www.united.com/en/us");
        actions.click(unitedAirlinesHomePage.oneWayRadioButton).perform();
        unitedAirlinesHomePage.fromInputBox.clear();
        unitedAirlinesHomePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)" + Keys.ENTER);
        unitedAirlinesHomePage.autoCompleteFromInputBox.click();
        unitedAirlinesHomePage.toInputBox.clear();
        unitedAirlinesHomePage.toInputBox.sendKeys("Miami, FL, US (MIA)" + Keys.ENTER);
        unitedAirlinesHomePage.autoCompleteFromInputBox.click();
        unitedAirlinesHomePage.dateInputBox.clear();
        unitedAirlinesHomePage.dateInputBox.click();
        unitedAirlinesHomePage.dateInputBox.sendKeys("01/30/2023" + Keys.ENTER);
        unitedAirlinesHomePage.travelerSelector.click();
        unitedAirlinesHomePage.travelerSelector.sendKeys("2" + Keys.ENTER);
        unitedAirlinesHomePage.cabinDropDown.click();
        unitedAirlinesHomePage.cabinDropDown.sendKeys("First" +Keys.ENTER);
        unitedAirlinesHomePage.findFlightsButton.click();
        Waiter.waitUntilTextToBePresentInElement(driver, 15, unitedAirlinesResultsPage.header2ChicagoToMiamiResults, "Depart: Chicago, IL, US to Miami, FL, US");
        Assert.assertEquals(unitedAirlinesResultsPage.header2ChicagoToMiamiResults.getText(), "Depart: Chicago, IL, US to Miami, FL, US");
    }


}
