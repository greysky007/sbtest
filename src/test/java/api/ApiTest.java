package api;

import api.models.CreateUserRequest;
import api.models.EditUserRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    private static Controllers controllers;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        controllers = new Controllers();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/positiveCreateTestData.csv", numLinesToSkip = 1)
    public void positiveUserCreation(int id, String username, String firstName, String lastName,
                                     String email, String password, String phone, int userStatus, int expectedStatus) {
        CreateUserRequest userBody = CreateUserRequest.builder()
                .userStatus(userStatus)
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .id(id)
                .password(password)
                .phone(phone).email(email).build();
        controllers.createUser(userBody).statusCode(expectedStatus);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/negativeCreateTestData.csv", numLinesToSkip = 1)
    public void negativeUserCreation(int id, String username, String firstName, String lastName,
                                     String email, String password, String phone, int userStatus, int expectedStatus) {
        CreateUserRequest userBody = CreateUserRequest.builder()
                .userStatus(userStatus)
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .id(id)
                .password(password)
                .phone(phone).email(email).build();
        controllers.createUser(userBody).statusCode(expectedStatus);

    }

    @Test
    public void positiveUserEdit() {
        CreateUserRequest userBody = CreateUserRequest.builder()
                .userStatus(3)
                .firstName(DataHelp.generateValidFirstName())
                .lastName(DataHelp.generateValidLastName())
                .username(DataHelp.generateValidUserName())
                .id(DataHelp.generateValidId())
                .password(DataHelp.generateValidPass())
                .phone(DataHelp.generateValidPhone())
                .email(DataHelp.generateValidEmail()).build();
        controllers.createUser(userBody).statusCode(200);

        EditUserRequest userEditBody = EditUserRequest.builder()
                .userStatus(6)
                .firstName(DataHelp.generateValidFirstName())
                .lastName(DataHelp.generateValidLastName())
                .username(DataHelp.generateValidUserName())
                .id(DataHelp.generateValidId())
                .password(DataHelp.generateValidPass())
                .phone(DataHelp.generateValidPhone())
                .email(DataHelp.generateValidEmail()).build();

        controllers.editUser(userEditBody, userBody.getUsername()).statusCode(200);

    }

    @Test
    public void negativeUserEditWithNull() {
        CreateUserRequest userBody = CreateUserRequest.builder()
                .userStatus(3)
                .firstName(DataHelp.generateValidFirstName())
                .lastName(DataHelp.generateValidLastName())
                .username(DataHelp.generateValidUserName())
                .id(DataHelp.generateValidId())
                .password(DataHelp.generateValidPass())
                .phone(DataHelp.generateValidPhone())
                .email(DataHelp.generateValidEmail()).build();
        controllers.createUser(userBody).statusCode(200);

        EditUserRequest userEditBody = EditUserRequest.builder()
                .userStatus(0)
                .firstName(null)
                .lastName(null)
                .username(null)
                .id(0)
                .password(null)
                .phone(null)
                .email(null).build();

        controllers.editUser(userEditBody, userBody.getUsername()).statusCode(400);

    }

    @Test
    public void positiveGetUserByUserName() {
        CreateUserRequest userBody = CreateUserRequest.builder()
                .userStatus(3)
                .firstName(DataHelp.generateValidFirstName())
                .lastName(DataHelp.generateValidLastName())
                .username(DataHelp.generateValidUserName())
                .id(DataHelp.generateValidId())
                .password(DataHelp.generateValidPass())
                .phone(DataHelp.generateValidPhone())
                .email(DataHelp.generateValidEmail()).build();
        controllers.createUser(userBody).statusCode(200);

        controllers.getUserByUsername(userBody.getUsername()).statusCode(200)
                .body("id", equalTo(userBody.getId()))
                .body("username", equalTo(userBody.getUsername()))
                .body("firstName", equalTo(userBody.getFirstName()))
                .body("lastName", equalTo(userBody.getLastName()))
                .body("email", equalTo(userBody.getEmail()))
                .body("password", equalTo(userBody.getPassword()))
                .body("phone", equalTo(userBody.getPhone()))
                .body("userStatus", equalTo(userBody.getUserStatus()));
    }
    @Test
    public void negativeGetUserByUserNameIfUserNameIsNotExist() {
        CreateUserRequest userBody = CreateUserRequest.builder()
                .userStatus(3)
                .firstName(DataHelp.generateValidFirstName())
                .lastName(DataHelp.generateValidLastName())
                .username(DataHelp.generateValidUserName())
                .id(DataHelp.generateValidId())
                .password(DataHelp.generateValidPass())
                .phone(DataHelp.generateValidPhone())
                .email(DataHelp.generateValidEmail()).build();
        controllers.createUser(userBody).statusCode(200);

        controllers.delUserByUsername(userBody.getUsername()).statusCode(200);
        controllers.getUserByUsername(userBody.getUsername()).statusCode(404);

    }
    @Test
    public void positiveDelUserByUserName() {
        CreateUserRequest userBody = CreateUserRequest.builder()
                .userStatus(3)
                .firstName(DataHelp.generateValidFirstName())
                .lastName(DataHelp.generateValidLastName())
                .username(DataHelp.generateValidUserName())
                .id(DataHelp.generateValidId())
                .password(DataHelp.generateValidPass())
                .phone(DataHelp.generateValidPhone())
                .email(DataHelp.generateValidEmail()).build();
        controllers.createUser(userBody).statusCode(200);

        controllers.delUserByUsername(userBody.getUsername()).statusCode(200);

    }
    @Test
    public void negativeDelUserByUserNameIfUserNameIsNotExist() {
        CreateUserRequest userBody = CreateUserRequest.builder()
                .userStatus(3)
                .firstName(DataHelp.generateValidFirstName())
                .lastName(DataHelp.generateValidLastName())
                .username(DataHelp.generateValidUserName())
                .id(DataHelp.generateValidId())
                .password(DataHelp.generateValidPass())
                .phone(DataHelp.generateValidPhone())
                .email(DataHelp.generateValidEmail()).build();
        controllers.createUser(userBody).statusCode(200);

        controllers.delUserByUsername(userBody.getUsername()).statusCode(200);
        controllers.delUserByUsername(userBody.getUsername()).statusCode(404);

    }
}