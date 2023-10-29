import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.GuiTestBase;
import praktikum.api.UserGenerator;
import praktikum.api.UserHelper;
import praktikum.model.User;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import praktikum.pages.PersonalAccountPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static praktikum.Constants.BASE_URI;
import static praktikum.Constants.LOGIN_METHOD_PATH;

public class NavigationTest extends GuiTestBase {

    private User userData;
    private MainPage objMainPage;
    private final UserGenerator userGenerator = new UserGenerator();
    private final UserHelper userHelper = new UserHelper();

    @Before
    @DisplayName("Test data")
    @Description("Подготовка тестовых данных")
    public void prepareTestData() {
        userData = userGenerator.getRandom();
        userHelper.create(userData);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(BASE_URI + LOGIN_METHOD_PATH);
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setInpEmail(userData.getEmail());
        objLoginPage.setInpPassword(userData.getPassword());
        objLoginPage.clickBtnLogin();
        objMainPage = new MainPage(driver);
    }

    @After
    @DisplayName("Delete User")
    @Description("Удаление созданных тестовых данных")
    public void deleteTestData() {
        ValidatableResponse loginUserResponse = userHelper.login(userData);
        userData = userHelper.extractTokenFromResponse(userData, loginUserResponse);
        userHelper.delete(userData.getAccessToken());
    }


    @Test
    @DisplayName("Move to Personal Account")
    @Description("Проверка возможности перехода в личный кабинет с главной страницы")
    public void moveToPersonalAccountSuccess() {
        objMainPage.clickBtnPersonalAccount();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        assertTrue(objPersonalAccountPage.checkDisplayedLblPersonalData());

    }


    @Test
    @DisplayName("Move to Main Page by click button")
    @Description("Проверка возможности перехода на главную страницу после нажатия кнопки Конструктор")
    public void moveToMainPageFromPersonalAccountButtonConstructorSuccess() {
        objMainPage.clickBtnPersonalAccount();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickBtnConstructor();
        assertTrue(objMainPage.checkDisplayedMenuIngredients());
    }


    @Test
    @DisplayName("Move to Main Page by click logo")
    @Description("Проверка возможности перехода на главную страницу после нажатия на логотип")
    public void moveToMainPageFromPersonalAccountImgLogoSuccess() {
        objMainPage.clickBtnPersonalAccount();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickImgLogo();
        assertTrue(objMainPage.checkDisplayedMenuIngredients());
    }
}
