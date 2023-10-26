package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    // Страница восстановления пароля
    // Кликабельная надпись Войти
    private final By btnLogin = By.xpath("//a[text()='Войти']");


    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
    }

}
