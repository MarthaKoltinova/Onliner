package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformPage extends BasePage {
    private By continueShopping = By.cssSelector(".button-style.button-style_auxiliary.button-style_base-alter.product-recommended__button.helpers_hide_tablet");

    public InformPage(WebDriver driver) {
        super(driver);
    }

    public InformPage clickContinueShopping() {
        logger.debug("Click continue shopping");
        driver.findElement(continueShopping).click();
        return this;
    }
}
