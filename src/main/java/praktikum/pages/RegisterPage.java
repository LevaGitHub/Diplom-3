package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;
    private static final String REGISTER_PAGE_NAME = "Форма регистрации. ";

    // Страница регистрации
    // Поле ввода Имя
    private static final By INP_NAME = By.xpath("//label[text()='Имя']/../input");
    // Поле ввода Email
    private static final By INP_EMAIL = By.xpath("//label[text()='Email']/../input");
    // Поле ввода Пароль
    private static final By INP_PASSWORD = By.xpath("//label[text()='Пароль']/../input");
    // Кнопка Зарегистрироваться
    private static final By BTN_REGISTER = By.xpath("//button[text()='Зарегистрироваться']");
    // Надпись Некорректный пароль
    private static final By LBL_INCORRECT_PASSWORD = By.xpath("//p[text()='Некорректный пароль']");
    // Кликабельный текст Войти
    private static final By BTN_LOGIN = By.xpath("//a[text()='Войти']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(REGISTER_PAGE_NAME + "Заполнение поля Имя")
    public void setInpName(String name) {
        driver.findElement(INP_NAME).sendKeys(name);
    }

    @Step(REGISTER_PAGE_NAME + "Заполнение поля Email")
    public void setInpEmail(String email) {
        driver.findElement(INP_EMAIL).sendKeys(email);
    }

    @Step(REGISTER_PAGE_NAME + "Заполнение поля Пароль")
    public void setInpPassword(String password) {
        driver.findElement(INP_PASSWORD).sendKeys(password);
    }

    @Step(REGISTER_PAGE_NAME + "Клик на кнопку Регистрация")
    public void clickBtnRegister() {
        driver.findElement(BTN_REGISTER).click();
    }

    @Step(REGISTER_PAGE_NAME + "Проверка отображения надписи Некорректный пароль")
    public boolean checkEnabledLblIncorrectPassword(){
        return driver.findElement(LBL_INCORRECT_PASSWORD).isDisplayed();
    }

    @Step(REGISTER_PAGE_NAME + "Клик на кнопку Войти")
    public void clickBtnLogin() {
        driver.findElement(BTN_LOGIN).click();
    }

}
