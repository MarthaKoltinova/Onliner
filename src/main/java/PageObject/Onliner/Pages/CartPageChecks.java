package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPageChecks extends CartPage {

    public CartPageChecks(WebDriver driver) {
        super(driver);
    }

    public CartPageChecks verifyThatItemIs(String value) {
        logger.debug("Check item in the page");
        Assert.assertEquals(getName(), value);
        return this;
    }
}
