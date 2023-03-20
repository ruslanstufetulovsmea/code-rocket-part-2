package com.meawallet.usercrud.itest;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.springtestdbunit.annotation.DatabaseOperation.DELETE_ALL;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DatabaseTearDown(value = "classpath:dbunit/empty_dataset.xml", type = DELETE_ALL)
public class FindUserByIdIntegrationTest extends BaseIntegrationTest {

//    @MockBean
//    private GetUserUseCase getUserUseCase;

    @Test
    @DatabaseSetup(value = "classpath:dbunit/findUserByIdSuccess.xml")
    @ExpectedDatabase(value = "classpath:dbunit/findUserByIdSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldFindUserById() throws Exception {
//        when(getUserUseCase.getUser(1)).thenReturn(User.builder().build());

        mvc.perform(MockMvcRequestBuilders.get("/users/1"))
           .andExpect(status().isOk());
    }
}
