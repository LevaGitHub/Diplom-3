package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
