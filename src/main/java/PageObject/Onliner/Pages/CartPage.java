package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public By product = By.cssSelector(".cart-form__link.cart-form__link_primary.cart-form__link_base-alter");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getName() {
        return driver.findElement(product).getText();
    }
}
