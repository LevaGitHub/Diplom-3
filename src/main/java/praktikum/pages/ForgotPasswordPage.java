package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private static final String FORGOT_PASSWORD_PAGE_NAME = "Форма восстановления пароля. ";

    // Страница восстановления пароля
    // Кликабельная надпись Войти
    private final By btnLogin = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(FORGOT_PASSWORD_PAGE_NAME + "Клик на кнопку Войти")
    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
    }

}
