package PageObject.Onliner.Pages;

import PageObject.BaseGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.stream.Collectors;

public class MobilePhonesPage extends BaseGroup {
    private By results = By.xpath("//div[contains(@class, g)]//a[@class='js-product-title-link']");

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getSearchResults() {
        List<String> data = driver.findElements(results).stream().map(result -> result.getText()).collect(Collectors.toList());
        return data;
    }

}