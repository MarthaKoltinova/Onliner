package PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


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
}
