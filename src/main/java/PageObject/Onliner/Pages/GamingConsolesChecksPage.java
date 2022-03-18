package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GamingConsolesChecksPage extends GamingConsolesPage {

    public GamingConsolesChecksPage(WebDriver driver) {
        super(driver);
    }

    public GamingConsolesChecksPage verifyTextOfTheCardButton(String value) {
        logger.debug("Check that status of the button is changed");
        Assert.assertEquals(getText(), value);
        return this;
    }

}
