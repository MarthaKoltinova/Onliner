package Task7;

import BaseObjects.BaseTest;
import PageObject.BaseGroup;
import PageObject.BaseGroupChecks;
import PageObject.Onliner.Enums.*;
import PageObject.Onliner.Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task7 extends BaseTest {

    @BeforeMethod
    public void preconditions() {
        get(HomePage.class)
                .open(property.getProperty("url"));
    }

    @Test(priority = 1)
    public void searchInCatalog() {
        logger.info("Test searchInCatalog started");
        get(HomePage.class)
                .clickOnMenu(Menu.CATALOG);
        get(CatalogPage.class)
                .clickOnTabCategory(Category.ELECTRONICS)
                .clickOnTabSubCategory(SubCategory.MOBILE_PHONES)
                .clickOnItem(Group.PHONES);
        get(BaseGroupChecks.class)
                .verifyThatTitleIs("Мобильные телефоны");
        get(MobilePhonesPage.class)
                .clickOnCheckbox(CheckboxItems.HONOR);
        get(BaseGroupChecks.class)
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
        get(LoginPageChecks.class)
                .verifyThatTitleIs("Регистрация");
        get(LoginPage.class)
                .enterEmail("12345");
        get(LoginPageChecks.class)
                .verifyThatEmailHintIs("Некорректный e-mail");
        get(LoginPage.class)
                .enterPassword(1234)
                .enterRepeatPassword(111111111);
        get(LoginPageChecks.class)
                .verifyThatPasswordHintsIs("Минимум 8 символов")
                .verifyThatRepeatPasswordHintsIs("Пароли не совпадают");
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
        get(BaseGroupChecks.class)
                .verifyThatTitleIs("Игровые приставки");
        get(BaseGroup.class)
                .getItemName();
        get(GamingConsolesPage.class)
                .clickOnItem(1);
        get(ProductPage.class)
                .addItemToCard();
        get(InformPageChecks.class)
                .verifyThatTextOfShoppingCartIs("Продолжить покупки")
                .verifyThatTextOfGoToCartIs("Перейти в корзину");
        get(InformPage.class)
                .clickContinueShopping();
        get(ProductPageChecks.class)
                .verifyTextOfTheCartButton("В корзине");
        get(GamingConsolesPage.class)
                .goToCart();
        get(BaseGroupChecks.class)
                .verifyProductNameInCart();
        logger.info("Test addItemToCart finished");
    }
}

