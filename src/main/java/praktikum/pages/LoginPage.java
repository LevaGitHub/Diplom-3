package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private static final String LOGIN_PAGE_NAME = "Форма авторизации. ";

    // Страница логина
    // Надпись Вход
    private final static By LBL_LOGIN = By.xpath("//div[contains(@class,'Auth_login')]/h2");
    // Кнопка Войти
    private final static By BTN_LOGIN = By.xpath("//button[text()='Войти']");
    // Поле ввода Email
    private final static By INP_EMAIL = By.xpath("//label[text()='Email']/../input");
    // Поле ввода Пароль
    private final static By INP_PASSWORD = By.xpath("//label[text()='Пароль']/../input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(LOGIN_PAGE_NAME + "Проверка доступности надписи Вход")
    public boolean checkEnabledLoginLabel(){
        return driver.findElement(LBL_LOGIN).isEnabled();
    }

    @Step(LOGIN_PAGE_NAME + "Проверка доступности кнопки Войти")
    public boolean checkEnabledLoginButton(){
        return driver.findElement(BTN_LOGIN).isDisplayed();
    }

    @Step(LOGIN_PAGE_NAME + "Заполнение поля Email")
    public void setInpEmail(String email) {
        driver.findElement(INP_EMAIL).sendKeys(email);
    }

    @Step(LOGIN_PAGE_NAME + "Заполнение поля Пароль")
    public void setInpPassword(String password) {
        driver.findElement(INP_PASSWORD).sendKeys(password);
    }

    @Step(LOGIN_PAGE_NAME + "Клик на кнопку Войти")
    public void clickBtnLogin() {
        driver.findElement(BTN_LOGIN).click();
    }

}
