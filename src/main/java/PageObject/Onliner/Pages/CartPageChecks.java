package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPageChecks extends CartPage {

    public CartPageChecks(WebDriver driver) {
        super(driver);
    }

    public CartPageChecks verifyProductNameInCart(String value, String value2) {
        logger.debug("Verify title name");
        Assert.assertEquals(value, value2);
        return this;
    }

}
