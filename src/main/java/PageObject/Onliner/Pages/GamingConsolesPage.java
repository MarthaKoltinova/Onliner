package PageObject.Onliner.Pages;

import PageObject.BaseGroup;
import PageObject.Onliner.Enums.Items;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamingConsolesPage extends BaseGroup {
    private By inCard = By.cssSelector(".button-style.button-style_base-alter.button-style_primary.product-aside__button.product-aside__button_narrow.product-aside__button_cart.button-style_primary");
    private By card = By.cssSelector(".auth-bar__item.auth-bar__item--cart");

    public GamingConsolesPage(WebDriver driver) {
        super(driver);
    }

    public GamingConsolesPage clickOnItem(Items items) {
        logger.debug("Click on item");
        driver.findElement(By.cssSelector(items.getItems())).click();
        return this;
    }

    public GamingConsolesPage goToCard() {
        logger.debug("go to card");
        driver.findElement(card).click();
        return this;
    }

}
