package PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class BaseGroupChecks extends BaseGroup {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);
    protected WebDriverWait wait;

    public BaseGroupChecks(WebDriver driver) {
        super(driver);
    }

    public BaseGroupChecks verifyThatTitleIs(String value) {
        logger.debug("Verify title name");
        Assert.assertEquals(getTitle(), value);
        return this;
    }

    public BaseGroupChecks checkSearchResults(String expected) {
        getSearchResults().forEach(actual -> {
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

    public BaseGroupChecks checkTimeOfResults(String expected) {
        getTimeOfResults().forEach(actual -> {
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertFalse(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

    public BaseGroupChecks checkStatusOfResults(String expected) {
        getStatusOfResults().forEach(actual -> {
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

    public BaseGroupChecks checkStatusBelowPrice(String expected) {
        WebElement price = driver.findElement(By.className("service-offers__price"));
        Assert.assertEquals(driver.findElement(with(getStatusResults()).below(price)), expected);
        return this;
    }
}
