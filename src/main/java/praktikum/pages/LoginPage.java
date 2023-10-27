package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private final String loginPageName = "Форма авторизации. ";

    // Страница логина
    // Надпись Вход
    private final By lblLogin = By.xpath("//div[contains(@class,'Auth_login')]/h2");
    // Кнопка Войти
    private final By btnLogin = By.xpath("//button[text()='Войти']");
    // Поле ввода Email
    private final By inpEmail = By.xpath("//label[text()='Email']/../input");
    // Поле ввода Пароль
    private final By inpPassword = By.xpath("//label[text()='Пароль']/../input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(loginPageName + "Проверка доступности надписи Вход")
    public boolean checkEnabledLoginLabel(){
        return driver.findElement(lblLogin).isEnabled();
    }

    @Step(loginPageName + "Проверка доступности кнопки Войти")
    public boolean checkEnabledLoginButton(){
        return driver.findElement(btnLogin).isDisplayed();
    }

    @Step(loginPageName + "Заполнение поля Email")
    public void setInpEmail(String email) {
        driver.findElement(inpEmail).sendKeys(email);
    }

    @Step(loginPageName + "Заполнение поля Пароль")
    public void setInpPassword(String password) {
        driver.findElement(inpPassword).sendKeys(password);
    }

    @Step(loginPageName + "Клик на кнопку Войти")
    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
    }

}
