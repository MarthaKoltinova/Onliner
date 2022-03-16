package Task7;

import BaseObjects.BaseTest;
import PageObject.Onliner.Enums.*;
import PageObject.Onliner.Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task7 extends BaseTest {

    @BeforeMethod
    public void preconditions() {
        get(HomePage.class)
                .open(property.getProperty("url"));
    }

    @Parameters({"str"})
    @Test(priority = 1)
    public void searchInCatalog() {
        logger.info("Test searchInCatalog started");
        get(HomePage.class)
                .clickOnMenu(Menu.CATALOG);
        get(CatalogPage.class)
                .clickOnTabCategory(Category.ELECTRONICS)
                .clickOnTabSubCategory(SubCategory.MOBILE_PHONES)
                .clickOnItem(Group.PHONES);
        get(MobilePhonesPage.class)
                .verifyTitle("Мобильные телефоны");
        get(MobilePhonesPage.class)
                .clickOnCheckbox(CheckboxItems.HONOR);
        get(MobilePhonesPage.class)
                .sleep(10);
        get(MobilePhonesPage.class)
                .checkSearchResults("HONOR");
        logger.info("Test searchInCatalog finished");
    }

    @Test(priority = 2)
    public void catalogSearch() {
        logger.info("Test pageResults  started");
        get(HomePage.class)
                .clickOnEntrance();
        get(LoginPage.class)
                .goToRegistration();
        get(LoginChecksPage.class)
                .verifyThatTitleIs("Регистрация");
        get(LoginPage.class)
                .enterWrongEmail();
        get(LoginChecksPage.class)
                .verifyThatHintIsDisplayed();
        get(LoginPage.class)
                .enterWrongPassword();
        get(LoginChecksPage.class)
                .verifyThatHintsIsDisplayed();
        logger.info("Test catalogSearch finished");
    }

    @Test(priority = 3)
    public void addItemToCart() {
        logger.info("Test addItemToCart  started");
        get(HomePage.class)
                .clickOnMenu(Menu.CATALOG);
        get(CatalogPage.class)
                .clickOnTabCategory(Category.ELECTRONICS)
                .clickOnTabSubCategory(SubCategory.VIDEO_GAMES)
                .clickOnItem(Group.GAMING_CONSOLES);
        get(GamingConsolesPage.class)
                .verifyTitle("Игровые приставки");
        get(GamingConsolesPage.class)
                .clickOnItem(Items.FIRST_ITEM_CONSOLES);
        get(Item.class)
                .addItemToCard();
        get(InformChecksPage.class)
                .verifyThatTextIs("Продолжить покупки", "Перейти в корзину");
        get(InformPage.class)
                .clickContinueShopping();
        get(GamingConsolesChecksPage.class)
                .verifyThatTextIs("В корзине");
        get(GamingConsolesPage.class)
                .goToCard();
        get(CardChecksPage.class)
                .verifyThatItemIsDisplayed();
        logger.info("Test addItemToCart finished");
    }
}

