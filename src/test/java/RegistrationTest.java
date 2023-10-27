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
import praktikum.pages.RegisterPage;

import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.assertTrue;
import static praktikum.Constants.BASE_URI;
import static praktikum.Constants.REGISTER_METHOD_PATH;

public class RegistrationTest extends GuiTestBase {

    private User userData;
    private RegisterPage objRegisterPage;
    private final UserGenerator userGenerator = new UserGenerator();
    private final UserHelper userHelper = new UserHelper();


    @Before
    @DisplayName("Test data")
    @Description("Подготовка тестовых данных")
    public void prepareTestData() {
        userData = userGenerator.getRandom();
        driver.get(BASE_URI + REGISTER_METHOD_PATH);
        objRegisterPage = new RegisterPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After
    @DisplayName("Delete User")
    @Description("Удаление созданных тестовых данных")
    public void deleteTestData() {
        if (!Objects.isNull(userData.getAccessToken())) {
            System.out.println(userData.getAccessToken());
            userHelper.delete(userData.getAccessToken());
        }
    }

    @Test
    @DisplayName("Registering a user")
    @Description("Регистрация пользователя с валидными данными")
    public void registrationSuccess() {
        objRegisterPage.setInpName(userData.getName());
        objRegisterPage.setInpEmail(userData.getEmail());
        objRegisterPage.setInpPassword(userData.getPassword());
        objRegisterPage.clickBtnRegister();
        LoginPage objLoginPage = new LoginPage(driver);
        assertTrue(objLoginPage.checkEnabledLoginLabel());
        assertTrue(objLoginPage.checkEnabledLoginButton());

        ValidatableResponse loginUserResponse = userHelper.login(userData);
        userData = userHelper.extractTokenFromResponse(userData, loginUserResponse);
    }

    @Test
    @DisplayName("Registering a user with an incorrect password")
    @Description("Регистрация пользователя с невалидным значением в поле Пароль")
    public void registerIncorrectPasswordFail() {
        objRegisterPage.setInpName(userData.getName());
        objRegisterPage.setInpEmail(userData.getEmail());
        // Некорректным считается пароль, длина котоого < 6 символов
        userData.setPassword(userData.getPassword().substring(0, 4));
        objRegisterPage.setInpPassword(userData.getPassword());
        objRegisterPage.clickBtnRegister();
        assertTrue(objRegisterPage.checkEnabledLblIncorrectPassword());
    }

}
