package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CardChecksPage extends BasePage {
    private By product = By.cssSelector(".cart-form__link.cart-form__link_primary.cart-form__link_base-alter");

    public CardChecksPage(WebDriver driver) {
        super(driver);
    }

    public CardChecksPage verifyThatItemIsDisplayed() {
        logger.debug("Check that item is present in the page");
        Assert.assertTrue(driver.findElement(product).isDisplayed());
        return this;
    }
}
