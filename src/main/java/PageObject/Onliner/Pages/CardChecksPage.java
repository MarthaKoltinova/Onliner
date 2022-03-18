package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CardChecksPage extends CardPage {

    public CardChecksPage(WebDriver driver) {
        super(driver);
    }

    public CardChecksPage verifyThatItemIs(String value) {
        logger.debug("Check item in the page");
        Assert.assertEquals(getName(), value);
        return this;
    }
}
