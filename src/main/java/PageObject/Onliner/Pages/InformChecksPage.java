package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InformChecksPage extends InformPage {

    public InformChecksPage(WebDriver driver) {
        super(driver);
    }

    public InformChecksPage verifyThatTextIs(String value, String value2) {
        logger.debug("Verify text name");
        Assert.assertEquals(getShoppingCardText(), value);
        Assert.assertEquals(getGoToCardText(), value2);
        return this;
    }
}
