package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private WebDriver driver;

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

    public boolean checkDisplayedLblPersonalData(){
        return driver.findElement(lblPersonalData).isDisplayed();
    }

    public void clickBtnConstructor() {
        driver.findElement(btnConstructor).click();
    }

    public void clickImgLogo() {
        driver.findElement(imgLogo).click();
    }

    public void clickBtnLogout() {
        driver.findElement(btnLogout).click();
    }


}
