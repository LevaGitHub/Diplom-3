package praktikum.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import praktikum.ApiBaseRequest;
import praktikum.model.User;

import static praktikum.Constants.*;

public class UserHelper extends ApiBaseRequest {

    @Step("Отправка запроса на создание пользователя")
    public ValidatableResponse create(User user) {
        return sendBaseRequest()
                .body(user.getUserDataForCreateUpdate())
                .when()
                .post(AUTH_USER_METHOD_PATH)
                .then().log().all()
                ;
    }

    @Step("Получение токенов из запроса")
    public User extractTokenFromResponse(User user, ValidatableResponse response) {
        user.setAccessToken((response.extract().path("accessToken")));
        user.setRefreshToken(response.extract().path("refreshToken"));
        return user;
    }


    @Step("Отправка запроса на логин")
    public ValidatableResponse login(User user) {
        return sendBaseRequest()
                .body(user.getUserDataForCreateUpdate())
                .when()
                .post(API_LOGIN_METHOD_PATH)
                .then().log().all()
                ;
    }


    @Step("Отправка запроса на удаление пользователя")
    public ValidatableResponse  delete(String token) {
        return sendBaseRequest()
                .header("Authorization",token)
                .when()
                .delete(DELETE_USER_METHOD_PATH)
                .then().log().all()
                ;
    }
}
