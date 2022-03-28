package PageObject;

import PageObject.Onliner.Enums.CheckboxItems;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BaseGroup extends BasePage {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);
    protected WebDriverWait wait;
    private By results = By.xpath("//div[contains(@class, g)]//a[@class='js-product-title-link']");
    private String productPattern = ("(//*[class='.schema-product__title'])[%s]");
    private String product = ("(//*[class='.schema-product__title'])");

    public String getText() {
        return text;
    }

    public String text = getItemName();

    protected BaseGroup(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public BaseGroup clickOnCheckbox(CheckboxItems checkboxItems) {
        logger.debug("Click on checkbox");
        driver.findElement(By.xpath(checkboxItems.getCheckboxItems())).click();
        return this;
    }

    public String getItemName() {
        return driver.findElement(By.xpath(product)).getText();
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

}
