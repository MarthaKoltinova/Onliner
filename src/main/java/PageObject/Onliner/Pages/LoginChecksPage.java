package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginChecksPage extends BasePage {
    private By title = By.cssSelector(".auth-form__title.auth-form__title_big.auth-form__title_condensed-default");
    private By wrongEmail = By.xpath("//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']");
    private By wrongPassword = By.xpath("//div[@class='auth-form__description auth-form__description_primary auth-form__description_tiny auth-form__description_condensed-other']");
    private By wrongRepeatPassword = By.xpath("//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']");
    public LoginChecksPage(WebDriver driver) {
        super(driver);
    }
    public LoginChecksPage verifyThatTitleIs(String value) {
        logger.debug("Verify title name");
        Assert.assertEquals(driver.findElement(title).getText(), value);
        return this;
    }
    public LoginChecksPage verifyThatHintIsDisplayed() {
        logger.debug("hint incorrect email");
        Assert.assertTrue((driver.findElement(wrongEmail).isDisplayed()));
        return this;
    }

    public LoginChecksPage verifyThatHintsIsDisplayed() {
        logger.debug("hint incorrect password");
        Assert.assertTrue((driver.findElement(wrongPassword).isDisplayed()));
        logger.debug("hint incorrect repeat password");
        Assert.assertTrue((driver.findElement(wrongRepeatPassword).isDisplayed()));
        return this;
    }
}
