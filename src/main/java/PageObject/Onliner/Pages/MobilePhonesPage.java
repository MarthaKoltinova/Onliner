package PageObject.Onliner.Pages;

import PageObject.BaseGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MobilePhonesPage extends BaseGroup {
    private By results = By.xpath("//div[contains(@class, g)]//a[@class='js-product-title-link']");

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public MobilePhonesPage checkSearchResults(String str) {
        driver.findElements(results).forEach(element -> {
            String actual = element.getText();
            String expected = str;
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

}