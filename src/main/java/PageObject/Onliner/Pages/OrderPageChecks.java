package PageObject.Onliner.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class OrderPageChecks extends OrdersPage{

    public OrderPageChecks(WebDriver driver) {
        super(driver);
    }

    public OrderPageChecks verifyStatusOfResultsIs(String expected) {
        getStatusOfResults().forEach(actual -> {
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

    public Integer checkThatCountOfElementsMoreThanOne(By element) {
        logger.debug("Find elements count " + element);
        Assert.assertTrue(driver.findElements(element).size() > 1);
        return driver.findElements(element).size();
    }

    public OrderPageChecks verifyStatusBelowPriceIs(String expected) {
        WebElement price = driver.findElement(By.className("service-offers__price"));
        Assert.assertEquals(driver.findElement(with(getStatusResults()).below(price)), expected);
        return this;
    }
}
