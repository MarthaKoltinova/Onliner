package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InformChecksPage extends BasePage {
    private By continueShopping = By.cssSelector(".button-style.button-style_auxiliary.button-style_base-alter.product-recommended__button.helpers_hide_tablet");
    private By goToCard = By.cssSelector(".button-style.button-style_another.button-style_base-alter.product-recommended__button");

    public InformChecksPage(WebDriver driver) {
        super(driver);
    }

    public InformChecksPage verifyThatTextIs(String value, String value2) {
        logger.debug("Verify text name");
        Assert.assertEquals(driver.findElement(continueShopping).getText(), value);
        Assert.assertEquals(driver.findElement(goToCard).getText(), value2);
        return this;
    }
}
