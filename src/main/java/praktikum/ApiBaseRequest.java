package praktikum;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static praktikum.Constants.API_PREFIX;
import static praktikum.Constants.BASE_URI;

public class ApiBaseRequest {

    protected RequestSpecification sendBaseRequest() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(API_PREFIX)
                ;
    }
}
