package PageObject.Onliner.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginChecksPage extends LoginPage {
    public LoginChecksPage(WebDriver driver) {
        super(driver);
    }

    public LoginChecksPage verifyThatTitleIs(String value) {
        logger.debug("Verify title name");
        Assert.assertEquals(getTitle(), value);
        return this;
    }

    public LoginChecksPage verifyThatEmailHintIs(String value) {
        logger.debug("hint incorrect email");
        Assert.assertEquals(getEmailHint(), value);
        return this;
    }

    public LoginChecksPage verifyThatPasswordHintsIs(String value, String value2) {
        logger.debug("hint incorrect password");
        Assert.assertEquals(getPasswordHint(), value);
        logger.debug("hint incorrect repeat password");
        Assert.assertEquals(getRepeatPasswordHint(), value2);
        return this;
    }
}
