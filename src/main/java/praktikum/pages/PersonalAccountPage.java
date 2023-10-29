package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private WebDriver driver;
    private static final String PERSONAL_ACCOUNT_PAGE_NAME = "Форма личный кабинет. ";

    // Личный кабинет
    // Надпись В этом разделе вы можете изменить свои персональные данные
    private static final By LBL_PERSONAL_DATA = By.xpath("//p[text()='В этом разделе вы можете изменить свои" +
            " персональные данные']");
    // Кнопка Конструктор
    private static final By BTN_CONSTRUCTOR = By.xpath("//p[text()='Конструктор']");
    // Объект Логотип
    private static final By IMG_LOGO = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");
    // Кликабельная надпись Выход
    private static final By BTN_LOGOUT = By.xpath("//button[text()='Выход']");


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(PERSONAL_ACCOUNT_PAGE_NAME + "Проверка отображения надписи Личный кабинет")
    public boolean checkDisplayedLblPersonalData(){
        return driver.findElement(LBL_PERSONAL_DATA).isDisplayed();
    }

    @Step(PERSONAL_ACCOUNT_PAGE_NAME + "Клик на кнопку Конструктор")
    public void clickBtnConstructor() {
        driver.findElement(BTN_CONSTRUCTOR).click();
    }

    @Step(PERSONAL_ACCOUNT_PAGE_NAME + "Клик на логотип StellarBurgers")
    public void clickImgLogo() {
        driver.findElement(IMG_LOGO).click();
    }

    @Step(PERSONAL_ACCOUNT_PAGE_NAME + "Проверка отображения кнопки Выход")
    public void clickBtnLogout() {
        driver.findElement(BTN_LOGOUT).click();
    }

}
