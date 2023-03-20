package com.meawallet.usercrud.itest;

import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static com.github.springtestdbunit.annotation.DatabaseOperation.DELETE_ALL;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DatabaseTearDown(value = "classpath:dbunit/empty_dataset.xml", type = DELETE_ALL)
public class CreateUserIntegrationTest extends BaseIntegrationTest {

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/createdUserSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldCreateUser() throws Exception {
        var quoteResponse = readJson("quoteResponseSuccess.json");
        var request = readJson("createUserRequest.json");
        var response = readJson("createUserResponseSuccess.json");

        stubQuoteResponse(quoteResponse, 200);

        mvc.perform(post("/users")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(request))
           .andExpect(content().json(response))
           .andExpect(status().isCreated());
    }

    @Test
    void shouldNotCreateUserIfQuoteAPIReturnError() throws Exception {
        stubQuoteResponse("", 400);
        var request = readJson("createUserRequest.json");
        var response = readJson("createUserResponse500Error.json");

        mvc.perform(post("/users")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(request))
           .andExpect(content().json(response))
           .andExpect(status().is5xxServerError());
    }


    @Test
    void shouldNotCreateUserIfValidationException() throws Exception {
        var request = readJson("createUserRequestValidationError.json");
        var response = readJson("createUserResponseValidationError.json");

        mvc.perform(post("/users")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(request))
           .andExpect(content().json(response))
           .andExpect(status().is4xxClientError());
    }

    private static void stubQuoteResponse(String quoteResponse, int status) {
        wireMockServer.stubFor(get(urlEqualTo("/random")).willReturn(
                aResponse()
                        .withStatus(status)
                        .withBody(quoteResponse)
                        .withHeader(HttpHeaders.CONTENT_TYPE, "application/json")
        ));
    }
}
