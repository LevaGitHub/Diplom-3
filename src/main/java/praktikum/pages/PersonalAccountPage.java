package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private WebDriver driver;
    private final String personalAccountPageName = "Форма личный кабинет. ";

    // Личный кабинет
    // Надпись В этом разделе вы можете изменить свои персональные данные
    private final By lblPersonalData = By.xpath("//p[text()='В этом разделе вы можете изменить свои" +
            " персональные данные']");
    // Кнопка Конструктор
    private final By btnConstructor = By.xpath("//p[text()='Конструктор']");
    // Объект Логотип
    private final By imgLogo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");
    // Кликабельная надпись Выход
    private final By btnLogout = By.xpath("//button[text()='Выход']");


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(personalAccountPageName + "Проверка отображения надписи Личный кабинет")
    public boolean checkDisplayedLblPersonalData(){
        return driver.findElement(lblPersonalData).isDisplayed();
    }

    @Step(personalAccountPageName + "Клик на кнопку Конструктор")
    public void clickBtnConstructor() {
        driver.findElement(btnConstructor).click();
    }

    @Step(personalAccountPageName + "Клик на логотип StellarBurgers")
    public void clickImgLogo() {
        driver.findElement(imgLogo).click();
    }

    @Step(personalAccountPageName + "Проверка отображения кнопки Выход")
    public void clickBtnLogout() {
        driver.findElement(btnLogout).click();
    }

}
