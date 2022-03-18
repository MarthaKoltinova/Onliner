package PageObject;

import PageObject.Onliner.Enums.CheckboxItems;
import PageObject.Onliner.Enums.Items;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public abstract class BaseGroup {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);
    private By card = By.cssSelector(".auth-bar__item.auth-bar__item--cart");

    protected BaseGroup(WebDriver driver) {
        this.driver = driver;
    }

    public BaseGroup verifyThatTitleIs(String value) {
        logger.debug("Verify title name");
        WebElement title = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(title.getText(), value);
        return this;
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

    public void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BaseGroup clickOnItem(Items items) {
        logger.debug("Click on item");
        driver.findElement(By.cssSelector(items.getItems())).click();
        return this;
    }
}
