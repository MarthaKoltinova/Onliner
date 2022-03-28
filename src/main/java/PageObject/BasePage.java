package PageObject;

import PageObject.Onliner.Enums.Menu;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);
    private By entrance = By.cssSelector(".auth-bar__item.auth-bar__item--text");
    private By cart = By.cssSelector(".auth-bar__item.auth-bar__item--cart");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected BasePage click(By element) {
        logger.debug("Click on " + element);
        driver.findElement(element).click();
        return this;
    }

    public BasePage clickOnMenu(Menu menu) {
        logger.debug("Click on menu tab");
        driver.findElement(By.partialLinkText(menu.getMenu())).click();
        return this;
    }

    public BasePage clickOnEntrance() {
        logger.debug("Click on tab entrance ");
        driver.findElement(entrance).click();
        return this;
    }

    public BasePage goToCart() {
        logger.debug("go to cart");
        driver.findElement(cart).click();
        return this;
    }

}