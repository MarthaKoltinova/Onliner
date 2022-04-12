package Task7;

import BaseObjects.BaseTest;
import PageObject.BaseGroupChecks;
import PageObject.BasePageChecks;
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
    public void searchInMobileCatalog() {
        logger.info("Test searchInMobileCatalog started");
        get(HomePage.class)
                .clickOnMenu(Menu.CATALOG);
        get(BasePageChecks.class)
                .verifyThatTitleOfTabIs("Каталог Onlíner");
        get(CatalogPage.class)
                .clickOnTabCategory(Category.ELECTRONICS)
                .clickOnTabSubCategory(SubCategory.MOBILE_PHONES)
                .clickOnItem(Group.PHONES);
        get(BasePageChecks.class)
                .verifyThatTitleOfTabIs("Мобильный телефон купить в Минске");
        get(BaseGroupChecks.class)
                .verifyThatTitleIs("Мобильные телефоны");
        get(MobilePhonesPage.class)
                .clickOnCheckbox(CheckboxItems.HONOR);
        get(BaseGroupChecks.class)
                .checkSearchResults("HONOR");
        get(MobilePhonesPage.class)
                .clickOnDropDownList()
                .chooseKindOfProductByPriceType("Дорогие");
        logger.info("Test searchInMobileCatalog finished");
    }

    @Test(priority = 2)
    public void verifyRegistration() {
        logger.info("Test verifyRegistration  started");
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
                .verifyThatPasswordHintsIs("Минимум 8 символов");
        logger.info("Test verifyRegistration finished");
    }

    @Test(priority = 3)
    public void addGamingConsolesItemToCart() {
        logger.info("Test addGamingConsolesItemToCart  started");
        get(HomePage.class)
                .clickOnMenu(Menu.CATALOG);
        get(BasePageChecks.class)
                .verifyThatTitleOfTabIs("Каталог Onlíner");
        get(CatalogPage.class)
                .clickOnTabCategory(Category.ELECTRONICS)
                .clickOnTabSubCategory(SubCategory.VIDEO_GAMES)
                .clickOnItem(Group.GAMING_CONSOLES);
        get(BaseGroupChecks.class)
                .verifyThatTitleIs("Игровые приставки");
        String text = String.valueOf(get(GamingConsolesPage.class).getTitleByIndex(1));
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
        get(CartPageChecks.class)
                .verifyProductNameInCart(text);
        logger.info("Test addGamingConsolesItemToCart finished");
    }

    @Test(priority = 4)
    public void servicesTest() {
        logger.info("Test services started");
        get(HomePage.class)
                .clickOnMenu(Menu.SERVICES);
        get(BasePageChecks.class)
                .verifyThatTitleOfTabIs("Заказы на услуги");
        get(OrdersPage.class)
                .clickOnCheckbox(CheckboxItems.UNFULFILLED);
        get(OrderPageChecks.class)
                .verifyStatusOfResultsIs("Не выполнен");
        OrdersPage ordersPage = new OrdersPage(driver);
        get(OrderPageChecks.class)
                .checkThatCountOfElementsMoreThan(ordersPage.countOfSearchResults,1);
        get(OrderPageChecks.class)
                .verifyStatusBelowPriceIs("Не выполнен");
        logger.info("Test services finished");
    }

    @Test(priority = 5)
    public void forumTest() {
        logger.info("Test forum started");
        get(HomePage.class)
                .clickOnMenu(Menu.FORUM);
        get(BasePageChecks.class)
                .verifyThatTitleOfTabIs("Форум onliner.by - Главная страница");
        get(ForumPage.class)
                .clickLink(Links.NEW);
        get(ForumPageChecks.class)
                .verifyThatTitleIs("Новое за 24 часа")
                .checkThatCountOfThemesMoreThan(1);
        get(ForumPage.class)
                .clickLastPage();
        get(ForumPageChecks.class)
                .verifyThatTimeOfPublicationLessThan24Hour("дн");
        logger.info("Test forum finished");
    }
}

