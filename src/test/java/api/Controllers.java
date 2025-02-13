package api;

import api.models.CreateUserRequest;
import api.models.EditUserRequest;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Controllers {

    @Step("Создание пользователя")
    public ValidatableResponse createUser(CreateUserRequest body) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .post("user")
                .then().log().all();
    }

    @Step("Редактирование пользователя")
    public ValidatableResponse editUser(EditUserRequest body, String username) {
        return given().log().all()
                .contentType(ContentType.JSON).pathParam("username", username)
                .body(body)
                .put("user/{username}")
                .then().log().all();
    }

    @Step("Получение пользователя по username")
    public ValidatableResponse getUserByUsername(String username) {
        return given().log().all()
                .contentType(ContentType.JSON).pathParam("username", username)
                .get("user/{username}")
                .then().log().all();
    }
    @Step("Удаление пользователя по username")
    public ValidatableResponse delUserByUsername(String username) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .delete("user/{username}")
                .then().log().all();
    }
}
