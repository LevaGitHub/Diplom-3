package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    // Главная страница
    // Кнопка Войти а аккаунт
    private final By btnLogin = By.xpath("//button[text()='Войти в аккаунт']");
    // Кнопка Оформить заказ
    private final By btnCreateOrder = By.xpath("//button[text()='Оформить заказ']");
    // Кнопка Личный кабинет
    private final By btnPersonAccount = By.xpath("//p[text()='Личный Кабинет']");
    // Контейнер с ингредиентами
    private final By cntBurgerIngredients = By.xpath("//div[contains(@class, " +
            "'BurgerIngredients_ingredients__menuContainer')]");
    // Вкладка Булки
    private final By tabBun = By.xpath("//span[text() = 'Булки']/..");
    // Вкладка Соусы
    private final By tabSauce = By.xpath("//span[text() = 'Соусы']/..");
    // Вкладка Начинки
    private final By tabMain = By.xpath("//span[text() = 'Начинки']/..");
    // Первый соус в списке ингредиентов - Соус Spicy-X
    private static final By imgSauceSpicyX = By.xpath("//img[@alt='Соус Spicy-X']");
    // Первая начинка в списке ингредиентов - Мясо бессмертных моллюсков Protostomia
    private static final By imgMeatImmortalMollusks = By.xpath("//img[@alt='Мясо бессмертных моллюсков Protostomia']");
    // Первая булка в списке ингредиентов - Флюоресцентная булка R2-D3
    private static final By imgFluorescentBun = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
    }

    public void clickBtnPersonalAccount() {
        driver.findElement(btnPersonAccount).click();
    }

    public boolean checkEnabledBtnLogin(){
        return driver.findElement(btnCreateOrder).isDisplayed();
    }
    public boolean checkDisplayedMenuIngredients(){
        return driver.findElement(cntBurgerIngredients).isDisplayed();
    }

    public void clickTabBun() {
        driver.findElement(tabBun).click();
    }

    public void clickTabSauce() {
        driver.findElement(tabSauce).click();
    }

    public void clickTabMain() {
        driver.findElement(tabMain).click();
    }

    public By getTabLocator(String tabName) throws Exception {
        if (tabName.equals("BUN")) {
            return tabBun;
        } else if (tabName.equals("SAUCE")) {
            return tabSauce;
        } else if (tabName.equals("MAIN")) {
            return tabMain;
        } else {
            throw new Exception("Incorrect tabName!");
        }
    }

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
        return imgSauceSpicyX;
    }

    public By getFirstMainLocator() {
        return imgMeatImmortalMollusks;
    }

    public By getFirstBunLocator() {
        return imgFluorescentBun;
    }

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
