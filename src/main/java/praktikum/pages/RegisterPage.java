package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;
    private final String registerPageName = "Форма регистрации. ";

    // Страница регистрации
    // Поле ввода Имя
    private final By inpName = By.xpath("//label[text()='Имя']/../input");
    // Поле ввода Email
    private final By inpEmail = By.xpath("//label[text()='Email']/../input");
    // Поле ввода Пароль
    private final By inpPassword = By.xpath("//label[text()='Пароль']/../input");
    // Кнопка Зарегистрироваться
    private final By btnRegister = By.xpath("//button[text()='Зарегистрироваться']");
    // Надпись Некорректный пароль
    private final By lblIncorrectPassword = By.xpath("//p[text()='Некорректный пароль']");
    // Кликабельный текст Войти
    private final By btnLogin = By.xpath("//a[text()='Войти']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(registerPageName + "Заполнение поля Имя")
    public void setInpName(String name) {
        driver.findElement(inpName).sendKeys(name);
    }

    @Step(registerPageName + "Заполнение поля Email")
    public void setInpEmail(String email) {
        driver.findElement(inpEmail).sendKeys(email);
    }

    @Step(registerPageName + "Заполнение поля Пароль")
    public void setInpPassword(String password) {
        driver.findElement(inpPassword).sendKeys(password);
    }

    @Step(registerPageName + "Клик на кнопку Регистрация")
    public void clickBtnRegister() {
        driver.findElement(btnRegister).click();
    }

    @Step(registerPageName + "Проверка отображения надписи Некорректный пароль")
    public boolean checkEnabledLblIncorrectPassword(){
        return driver.findElement(lblIncorrectPassword).isDisplayed();
    }

    @Step(registerPageName + "Клик на кнопку Войти")
    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
    }

}
