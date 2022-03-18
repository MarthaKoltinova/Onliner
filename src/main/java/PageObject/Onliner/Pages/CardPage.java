package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;

public class CardPage extends BasePage {

    public CardPage(WebDriver driver) {
        super(driver);
    }

    public String getName() {
        return driver.findElement(product).getText();
    }
}
