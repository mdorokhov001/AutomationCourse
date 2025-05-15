package lesson15.back;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingApiBase {

    private static String baseUrl = "https://restful-booker.herokuapp.com";
    private int bookingId = 2;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = baseUrl;
    }

    public String createToken() {
        String authPayload = "{ \"username\": \"admin\", \"password\": \"password123\" }";
        Response response = given()
                .contentType("application/json")
                .body(authPayload)
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract().response();

        return response.path("token");
    }


    @Test
    @DisplayName("CREATE - Создание нового бронирования с валидными данными")
    @Order(1)
    public void testCreateBookingValidData() {
        String payload = "{\n" +
                "  \"firstname\" : \"John\",\n" +
                "  \"lastname\" : \"Doe\",\n" +
                "  \"totalprice\" : 150,\n" +
                "  \"depositpaid\" : true,\n" +
                "  \"bookingdates\" : {\n" +
                "      \"checkin\" : \"2025-05-05\",\n" +
                "      \"checkout\" : \"2025-05-15\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Response response = given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .extract().response();

        bookingId = response.path("bookingid");
    }

    @Test
    @DisplayName("CREATE - Создание с недостающими обязательными полями")
    @Order(2)
    public void testCreateBookingMissingFields() {
        String payload = "{\n" +
                // пропущены firstname и lastname
                "  \"totalprice\" : 150\n" +
                "}";

        given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/booking")
                .then().statusCode(500);
    }

    @Test
    @DisplayName("CREATE - Создание с некорректными данными")
    @Order(3)
    public void testCreateBookingInvalidData() {
        String payload = "{\n" +
                "  \"firstname\" : \"\",\n" + // некорректное значение (пустое)
                "  \"lastname\" : null,\n" +   // некорректное значение (null)
                "}";

        given()
                .contentType("application/json")
                .body(payload)
                .then().statusCode(400);
    }


    @Test
    @Order(4)
    @DisplayName("GET - Получение конкретного бронирования по ID")
    public void testGetBookingById() {

        given()
                .when()
                .get("/booking/{id}", bookingId)
                .then()
                .statusCode(200)
                .body("firstname", notNullValue());
    }

    @Test
    @DisplayName("GET - Получение несуществующего бронирования")
    @Order(5)
    public void testGetNonExistingBooking() {
        int nonExistingId = 999999;
        given()
                .when()
                .get("/booking/{id}", nonExistingId)
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("GET - Проверка формата ответа (наличие ключей)")
    @Order(6)
    public void testGetBookingResponseFormat() {

        given()
                .when()
                .get("/booking/{id}", bookingId)
                .then()
                .statusCode(200)
                .body("$", hasKey("firstname"))
                .body("$", hasKey("lastname"))
                .body("$", hasKey("totalprice"))
                .body("$", hasKey("depositpaid"))
                .body("$", hasKey("bookingdates"))
                .body("bookingdates", hasKey("checkin"))
                .body("bookingdates", hasKey("checkout"))
                .body("$", hasKey("additionalneeds"));
    }

    @Test
    @DisplayName("UPDATE - Обновление существующего бронирования")
    @Order(7)
    public void testUpdateExistingBooking() {
        String token = createToken();


        String updatePayload = "{\n" +
                "  \"firstname\" : \"UpdatedName\",\n" +
                "  \"lastname\" : \"UpdatedLastName\",\n" +
                "  \"totalprice\" : 200,\n" +
                "  \"depositpaid\" : false,\n" +
                "  \"bookingdates\" : {\n" +
                "      \"checkin\" : \"2025-05-05\",\n" +
                "      \"checkout\" : \"2025-05-15\"\n" +
                "  },\n" +
                "  \"additionalneeds\" : \"Late check-in\"\n" +
                "}";

        given()
                .header("Cookie", "token=" + token)
                .contentType("application/json")
                .body(updatePayload)
                .when().put("/booking/{id}", bookingId)
                .then().statusCode(200);
    }

    @Test
    @DisplayName("DELETE - Удаление существующего бронирования")
    @Order(8)
    public void testDeleteExistingBooking() {
        String token = createToken();

        given()
                .header("Cookie", "token=" + token)
                .when().delete("/booking/{id}", bookingId)
                .then().statusCode(201);
    }

    @Test
    @DisplayName("DELETE - Удаление несуществующего бронирования")
    @Order(9)
    public void testDeleteNonExistingBooking() {
        String token = createToken();
        int nonExistingId = 9999999;

        given()
                .header("Cookie", "token=" + token)
                .when().delete("/booking/{id}", nonExistingId)
                .then().statusCode(405);
    }

}