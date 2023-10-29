package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private  static final String MAIN_PAGE_NAME = "Главная страница. ";
    // Главная страница
    // Кнопка Войти а аккаунт
    private static final By BTN_LOGIN = By.xpath("//button[text()='Войти в аккаунт']");
    // Кнопка Оформить заказ
    private static final By BTN_CREATE_ORDER = By.xpath("//button[text()='Оформить заказ']");
    // Кнопка Личный кабинет
    private static final By BTN_PERSON_ACCOUNT = By.xpath("//p[text()='Личный Кабинет']");
    // Контейнер с ингредиентами
    private static final By CNT_BURGER_INGREDIENTS = By.xpath("//div[contains(@class, " +
            "'BurgerIngredients_ingredients__menuContainer')]");
    // Вкладка Булки
    private static final By TAB_BUN = By.xpath("//span[text() = 'Булки']/..");
    // Вкладка Соусы
    private static final By TAB_SAUCE = By.xpath("//span[text() = 'Соусы']/..");
    // Вкладка Начинки
    private static final By TAB_MAIN = By.xpath("//span[text() = 'Начинки']/..");
    // Первый соус в списке ингредиентов - Соус Spicy-X
    private static final By IMG_SAUCE_SPICY_X = By.xpath("//img[@alt='Соус Spicy-X']");
    // Первая начинка в списке ингредиентов - Мясо бессмертных моллюсков Protostomia
    private static final By IMG_MEAT_IMMORTAL_MOLLUSKS = By.xpath("//img[@alt='Мясо бессмертных моллюсков Protostomia']");
    // Первая булка в списке ингредиентов - Флюоресцентная булка R2-D3
    private static final By IMG_FLUORESCENT_BUN = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(MAIN_PAGE_NAME + "Клик на кнопку Войти в аккаунт")
    public void clickBtnLogin() {
        driver.findElement(BTN_LOGIN).click();
    }

    @Step(MAIN_PAGE_NAME + "Клик на кнопку Личный кабинет")
    public void clickBtnPersonalAccount() {
        driver.findElement(BTN_PERSON_ACCOUNT).click();
    }

    @Step(MAIN_PAGE_NAME + "Проверка отображения кнопки Создать заказ")
    public boolean checkEnabledBtnLogin(){
        return driver.findElement(BTN_CREATE_ORDER).isDisplayed();
    }

    @Step(MAIN_PAGE_NAME + "Проверка отображения области с ингредиентами")
    public boolean checkDisplayedMenuIngredients(){
        return driver.findElement(CNT_BURGER_INGREDIENTS).isDisplayed();
    }

    @Step(MAIN_PAGE_NAME + "Клик на вкладку Булки")
    public void clickTabBun() {
        driver.findElement(TAB_BUN).click();
    }

    @Step(MAIN_PAGE_NAME + "Клик на вкладку Соусы")
    public void clickTabSauce() {
        driver.findElement(TAB_SAUCE).click();
    }

    @Step(MAIN_PAGE_NAME + "Клик на вкладку Начинки")
    public void clickTabMain() {
        driver.findElement(TAB_MAIN).click();
    }

    public By getTabLocator(String tabName) throws Exception {
        if (tabName.equals("BUN")) {
            return TAB_BUN;
        } else if (tabName.equals("SAUCE")) {
            return TAB_SAUCE;
        } else if (tabName.equals("MAIN")) {
            return TAB_MAIN;
        } else {
            throw new Exception("Incorrect tabName!");
        }
    }

    @Step(MAIN_PAGE_NAME + "Проверка выбора вкладки в качестве активной")
    public boolean checkToCurrentTab(By tabName) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.attributeContains(tabName,
                            "class", "current"));
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public By getFirstSauceLocator() {
        return IMG_SAUCE_SPICY_X;
    }

    public By getFirstMainLocator() {
        return IMG_MEAT_IMMORTAL_MOLLUSKS;
    }

    public By getFirstBunLocator() {
        return IMG_FLUORESCENT_BUN;
    }

    @Step(MAIN_PAGE_NAME + "Проверка прокрутки списка ингредиентов")
    public boolean checkScrollingToFirstPositions(By ingredient) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(driver -> {
                        // rectangle 24 x 297
                        return (driver.findElement(ingredient).getRect().y < 300) &&
                                (driver.findElement(ingredient).getRect().y > 100);
                    });
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }


}
