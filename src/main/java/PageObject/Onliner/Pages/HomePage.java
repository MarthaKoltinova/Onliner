package PageObject.Onliner.Pages;

import PageObject.BasePage;
import PageObject.Onliner.Enums.Menu;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage clickOnMenu(Menu menu) {
        return super.clickOnMenu(menu);
    }

    public HomePage open(String url) {
        logger.debug("Open page " + url);
        driver.get(url);
        return this;
    }

    @Override
    public BasePage clickOnEntrance() {
        return super.clickOnEntrance();
    }
}
