package com.meawallet.usercrud.itest;

import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.meawallet.usercrud.out.dto.GetQuoteOutResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateUserIntegrationTest extends BaseIntegrationTest {

    @MockBean(reset = MockReset.NONE)
    private RestTemplate restTemplate;

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/createdUserSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldCreateUser() throws Exception {
        when(restTemplate.getForEntity("https://api.quotable.io/random", GetQuoteOutResponse.class)).thenReturn(response());

        mvc.perform(post("/users")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content("{\n"
                           + "  \"name\" : \"test\",\n"
                           + "  \"age\" : 20\n"
                           + "}"))
           .andExpect(status().isCreated());

    }

    private ResponseEntity<GetQuoteOutResponse> response() {
        var body = new GetQuoteOutResponse("123",
                "some quote",
                "me",
                List.of(),
                "123",
                123,
                LocalDate.now(),
                LocalDate.now());
        return ResponseEntity.ok(body);
    }
}
