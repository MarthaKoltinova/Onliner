package PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseGroupChecks {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);
    protected WebDriverWait wait;
    private By results = By.xpath("//div[contains(@class, g)]//a[@class='js-product-title-link']");
    private By inCard = By.cssSelector(".button-style.button-style_base-alter.button-style_primary.product-aside__button.product-aside__button_narrow.product-aside__button_cart.button-style_primary");

    protected BaseGroupChecks() {
    }

    public BaseGroupChecks verifyThatTitleIs(String value) {
        logger.debug("Verify title name");
        WebElement title = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(title.getText(), value);
        return this;
    }

    public List<String> getSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(results));
        List<String> data = driver.findElements(results).stream().map(result -> result.getText()).collect(Collectors.toList());
        return data;
    }


    public BaseGroupChecks checkSearchResults(String expected) {
        getSearchResults().forEach(actual -> {
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

    public String getText() {
        return driver.findElement(inCard).getText();
    }

    public BaseGroupChecks verifyTextOfTheCardButton(String value) {
        logger.debug("Check that status of the button is changed");
        Assert.assertEquals(getText(), value);
        return this;
    }
}
