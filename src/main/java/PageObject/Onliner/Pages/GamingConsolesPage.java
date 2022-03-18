package PageObject.Onliner.Pages;

import PageObject.BaseGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamingConsolesPage extends BaseGroup {
    private By inCard = By.cssSelector(".button-style.button-style_base-alter.button-style_primary.product-aside__button.product-aside__button_narrow.product-aside__button_cart.button-style_primary");

    public GamingConsolesPage(WebDriver driver) {
        super(driver);
    }

    public String getText() {
        return driver.findElement(inCard).getText();
    }
}
