package PageObject;

import PageObject.Onliner.Enums.CheckboxItems;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public abstract class BaseGroup {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);


    protected BaseGroup(WebDriver driver) {
        this.driver = driver;
    }

    public BaseGroup verifyTitle(String value) {
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

    public void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
