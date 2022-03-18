package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformPage extends BasePage {
    private By continueShopping = By.cssSelector(".button-style.button-style_auxiliary.button-style_base-alter.product-recommended__button.helpers_hide_tablet");
    private By goToCard = By.cssSelector(".button-style.button-style_another.button-style_base-alter.product-recommended__button");

    public InformPage(WebDriver driver) {
        super(driver);
    }

    public String getShoppingCardText() {
        return driver.findElement(continueShopping).getText();
    }

    public String getGoToCardText() {
        return driver.findElement(goToCard).getText();
    }

    public InformPage clickContinueShopping() {
        logger.debug("Click continue shopping");
        driver.findElement(continueShopping).click();
        return this;
    }
}
