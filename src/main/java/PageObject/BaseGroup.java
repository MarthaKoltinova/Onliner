package PageObject;

import PageObject.Onliner.Enums.CheckboxItems;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseGroup extends BaseGroupChecks {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);
    private By card = By.cssSelector(".auth-bar__item.auth-bar__item--cart");
    private By item = By.cssSelector(".schema-product__title");

    protected BaseGroup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public BaseGroup clickOnCheckbox(CheckboxItems checkboxItems) {
        logger.debug("Click on checkbox");
        driver.findElement(By.xpath(checkboxItems.getCheckboxItems())).click();
        return this;
    }

    public BaseGroup goToCard() {
        logger.debug("go to card");
        driver.findElement(card).click();
        return this;
    }

    public BaseGroup getItemName() {
        logger.debug("get item Name");
        driver.findElement(item).click();
        return this;
    }

    public BaseGroup clickOnItem() {
        logger.debug("Click on item");
        driver.findElement(item).click();
        return this;
    }


}
