package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

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
    //p[text()='Некорректный пароль']
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInpName(String name) {
        driver.findElement(inpName).sendKeys(name);
    }

    public void setInpEmail(String email) {
        driver.findElement(inpEmail).sendKeys(email);
    }

    public void setInpPassword(String password) {
        driver.findElement(inpPassword).sendKeys(password);
    }

    public void clickBtnRegister() {
        driver.findElement(btnRegister).click();
    }

    public boolean checkEnabledLblIncorrectPassword(){
        return driver.findElement(lblIncorrectPassword).isDisplayed();
    }

}
