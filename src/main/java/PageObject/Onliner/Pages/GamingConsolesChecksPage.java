package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GamingConsolesChecksPage extends BasePage {
    private By inCard = By.cssSelector(".button-style.button-style_base-alter.button-style_primary.product-aside__button.product-aside__button_narrow.product-aside__button_cart.button-style_primary");

    public GamingConsolesChecksPage(WebDriver driver) {
        super(driver);
    }

    public GamingConsolesChecksPage verifyThatTextIs(String value) {
        logger.debug("Check that status of the button is changed");
        Assert.assertEquals(driver.findElement(inCard).getText(), value);
        return this;
    }
}
