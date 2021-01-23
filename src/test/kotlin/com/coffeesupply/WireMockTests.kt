package com.coffeesupply

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import java.net.URI


class WireMockTests {
    var server = WireMockServer(8081)

    private fun setup() {
        server.start()
        val okResponse = ResponseDefinitionBuilder().withStatus(200);

        WireMock.configureFor("localhost", 8081)
        WireMock.stubFor(
            WireMock.get("/coffee")
                .willReturn(okResponse)
        )
    }

    @Test
    fun responseStatusTest() {
        setup()

        RestAssured.given().`when`().get(
            URI("http://localhost:8081/coffee")).then().assertThat().statusCode(200)
    }

}