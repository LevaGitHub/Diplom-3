package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

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

    public boolean checkEnabledLoginLabel(){
        return driver.findElement(lblLogin).isEnabled();
    }

    public boolean checkEnabledLoginButton(){
        return driver.findElement(btnLogin).isDisplayed();
    }

    public void setInpEmail(String email) {
        driver.findElement(inpEmail).sendKeys(email);
    }

    public void setInpPassword(String password) {
        driver.findElement(inpPassword).sendKeys(password);
    }

    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
    }

}
