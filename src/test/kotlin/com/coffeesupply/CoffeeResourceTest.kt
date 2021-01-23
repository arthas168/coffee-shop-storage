package com.coffeesupply

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class CoffeeResourceTest {

    @Test
    fun testGetAllCoffeesEndpoint() {
        given()
          .`when`().get("/coffee")
          .then()
             .statusCode(200)
    }

}