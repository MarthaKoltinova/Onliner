package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InformPageChecks extends InformPage {

    public InformPageChecks(WebDriver driver) {
        super(driver);
    }

    public InformPageChecks verifyThatTextOfShoppingCartIs(String value) {
        logger.debug("Verify text name");
        Assert.assertEquals(getShoppingCartText(), value);
        return this;
    }

    public InformPageChecks verifyThatTextOfGoToCartIs(String value) {
        Assert.assertEquals(getGoToCartText(), value);
        return this;
    }
}
