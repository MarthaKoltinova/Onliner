package PageObject.Onliner.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public By registration = By.linkText("Зарегистрироваться на Onlíner");
    private By email = By.xpath("//input[@type='email']");
    private By password = By.xpath("//input[@type='password']");
    private By passwordRepeat = By.xpath("//*[@autocomplete='repeatPassword']//input");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToRegistration() {
        logger.debug("go to registration");
        click(registration);
        return this;
    }

    public LoginPage enterWrongEmail() {
        logger.debug("enter wrong email");
        click(email);
        driver.findElement(email).sendKeys("12345");
        return this;
    }

    public LoginPage enterWrongPassword() {
        logger.debug("enter wrong password");
        click(password);
        driver.findElement(password).sendKeys("1234");
        logger.debug("enter wrong repeat password");
        click(passwordRepeat);
        driver.findElement(passwordRepeat).sendKeys("113456789123");
        return this;
    }
}
