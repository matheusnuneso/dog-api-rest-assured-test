package io.github.matheusnuneso;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class BreedTests extends BaseTest {

    @Test
    public void shouldReturnAllBreedsSuccessfully(){
        given()
            .spec(requestSpec())
        .when()
            .get("/breeds/list/all")
        .then()
            .assertThat()
                .statusCode(200)
                .body("status", is("success"))
                .body("message", is(notNullValue()));
    }

    @Test
    public void shouldReturnRandomImageSuccessfully(){
        given()
            .spec(requestSpec())
        .when()
            .get("/breeds/image/random")
        .then()
            .assertThat()
                .statusCode(200)
                .body("status", is("success"))
                .body("message", matchesPattern("https?://.*"));
    }

    @Test
    public void shouldReturnAllImagesWhenValidBreedIsProvided(){
        String validBreed = "bulldog";
        String path = "/breed/"+ validBreed +"/images";

        given()
            .spec(requestSpec())
        .when()
            .get(path)
        .then()
            .assertThat()
            .statusCode(200)
            .body("status", is("success"))
            .body("message", everyItem(matchesPattern("https?://.*")));
    }

    @Test()
    public void shouldReturnNotFoundWhenInvalidBreedIsProvided(){
        String invalidBreed = "invalidBreed";
        String path = "/breed/"+ invalidBreed +"/images";

        given()
            .spec(requestSpec())
        .when()
            .get(path)
        .then()
            .assertThat()
            .statusCode(404)
            .body("status", is("error"))
            .body("message", is("Breed not found (main breed does not exist)"))
            .body("code", is(404));
    }

}
