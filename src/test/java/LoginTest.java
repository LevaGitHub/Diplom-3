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
import praktikum.pages.ForgotPasswordPage;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import praktikum.pages.RegisterPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static praktikum.Constants.*;


public class LoginTest extends GuiTestBase {

    private User userData;
    private final UserGenerator userGenerator = new UserGenerator();
    private final UserHelper userHelper = new UserHelper();

    private void loginToLoginPage() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setInpEmail(userData.getEmail());
        objLoginPage.setInpPassword(userData.getPassword());
        objLoginPage.clickBtnLogin();
    }

    @Before
    @DisplayName("Test data")
    @Description("Подготовка тестовых данных")
    public void prepareTestData() {
        userData = userGenerator.getRandom();
        userHelper.create(userData);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
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
    @DisplayName("Login by button in Main Window")
    @Description("Проверка возможности логина через кнопку на главной странице")
    public void loginButtonMainWindow() {
        driver.get(BASE_URI);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickBtnLogin();
        loginToLoginPage();
        assertTrue(objMainPage.checkEnabledBtnLogin());
    }

    @Test
    @DisplayName("Login by button 'Personal Area' in Main Window")
    @Description("Проверка возможности логина через кнопку 'Личный кабинет' на главной странице")
    public void loginPersonAreaMainWindow() {
        driver.get(BASE_URI);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickBtnPersonalArea();
        loginToLoginPage();
        assertTrue(objMainPage.checkEnabledBtnLogin());
    }

    @Test
    @DisplayName("Login by button Login by form Register")
    @Description("Проверка возможности логина через кнопку 'Войти' на странице регистрации")
    public void loginButtonByFormRegister() {
        driver.get(BASE_URI + REGISTER_METHOD_PATH);
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.clickBtnLogin();
        loginToLoginPage();
        MainPage objMainPage = new MainPage(driver);
        assertTrue(objMainPage.checkEnabledBtnLogin());
    }

    @Test
    @DisplayName("Login by button Login by form Forgot Password")
    @Description("Проверка возможности логина через кнопку 'Войти' на странице восстановления пароля")
    public void loginButtonByFormForgotPassword() {
        driver.get(BASE_URI + FORGOT_PASSWORD_METHOD_PATH);
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        objForgotPasswordPage.clickBtnLogin();
        loginToLoginPage();
        MainPage objMainPage = new MainPage(driver);
        assertTrue(objMainPage.checkEnabledBtnLogin());
    }

}