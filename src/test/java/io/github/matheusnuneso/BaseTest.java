package io.github.matheusnuneso;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    protected static RequestSpecification requestSpec(){
        String baseUri = "https://dog.ceo/api";

        final RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        return requestBuilder
                .addFilter(new RequestLoggingFilter())
                .setBaseUri(baseUri)
                .build();
    }

}
