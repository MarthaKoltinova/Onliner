package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MobilePhonesChecksPage extends MobilePhonesPage {

    public MobilePhonesChecksPage(WebDriver driver) {
        super(driver);
    }

    public MobilePhonesChecksPage checkSearchResults(String expected) {
        getSearchResults().forEach(actual -> {
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }
}
