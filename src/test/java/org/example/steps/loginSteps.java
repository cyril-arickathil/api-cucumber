package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.RestAssured;

public class loginSteps {

    @Given("user performs login")
    public void user_performs_login() {
        String TOKEN;
        System.out.println("-------------- running steps --------------");
        String requestBody ="""
        {
            "email": "cyril_test@fake.com",
            "password": "faketest"
        }
        """;
        var responseBody = RestAssured.given().header("Content-Type","application/json").body(requestBody).when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        TOKEN = responseBody.getBody().jsonPath().get("token");
        System.out.println("TOKEN : "+TOKEN);
    }

    @Then("check this")
    public void checkThis() {
        System.out.println("------------ check this ------------");
        var response = RestAssured.given().when().get("https://reqres.in/api/users/2").getBody().asString();
        System.out.println("response: "+response);
        //response.log();

    }
}
