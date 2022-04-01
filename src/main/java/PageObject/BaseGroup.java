package PageObject;

import PageObject.Onliner.Enums.CheckboxItems;
import PageObject.Onliner.Enums.Links;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BaseGroup extends BasePage {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);
    protected WebDriverWait wait;
    private By results = By.xpath("//div[contains(@class, g)]//a[@class='js-product-title-link']");
    private By statusResults = By.cssSelector(".service-offers__status.ng-scope.service-offers__status_error");
    public By countOfSearchResults = By.xpath("//*[@class='service-interaction__inner-container']");
    private By title = By.tagName("h1");
    private By publicationTime = By.xpath("//div[contains(@class, g)]//a[@class='link-getlast']");
    private String productPattern = ("(//*[class='.schema-product__title'])[%s]");

    public BaseGroup(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public BaseGroup clickOnCheckbox(CheckboxItems checkboxItems) {
        logger.debug("Click on checkbox");
        driver.findElement(By.xpath(checkboxItems.getCheckboxItems())).click();
        return this;
    }

    public BaseGroup getTitleByIndex(int index) {
        logger.debug("get title by index");
        driver.findElement(By.xpath(String.format(productPattern, index))).getText();
        return this;
    }

    public BaseGroup clickOnItem(int index) {
        logger.debug("Click on item");
        driver.findElement(By.xpath(String.format(productPattern, index))).click();
        return this;
    }

    public List<String> getSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(results));
        List<String> data = driver.findElements(results).stream().map(result -> result.getText()).collect(Collectors.toList());
        return data;
    }

    public List<String> getTimeOfResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(publicationTime));
        List<String> data = driver.findElements(publicationTime).stream().map(result -> result.getText()).collect(Collectors.toList());
        return data;
    }

    public BaseGroup getTitle() {
        logger.debug("get title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        driver.findElement(title).getText();
        return this;
    }

    public Integer findElementsCount(By element) {
        logger.debug("Find elements count " + element);
        Assert.assertTrue(driver.findElements(element).size() > 1);
        return driver.findElements(element).size();
    }

    public By getStatusResults() {
        return statusResults;
    }

    public List<String> getStatusOfResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusResults));
        List<String> data = driver.findElements(statusResults).stream().map(result -> result.getText()).collect(Collectors.toList());
        return data;
    }

    public BaseGroup clickLink(Links links) {
        logger.debug("Click on link");
        driver.findElement(By.linkText(links.getLinks())).click();
        return this;
    }
}
