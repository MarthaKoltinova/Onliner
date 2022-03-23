package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InformPageChecks extends InformPage {

    public InformPageChecks(WebDriver driver) {
        super(driver);
    }

    public InformPageChecks verifyThatTextOfShoppingCardIs(String value) {
        logger.debug("Verify text name");
        Assert.assertEquals(getShoppingCardText(), value);
        return this;
    }

    public InformPageChecks verifyThatTextOfGoToCardIs(String value) {
        Assert.assertEquals(getGoToCardText(), value);
        return this;
    }
}
