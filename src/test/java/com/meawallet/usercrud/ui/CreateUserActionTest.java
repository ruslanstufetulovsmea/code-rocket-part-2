package com.meawallet.usercrud.ui;


import com.meawallet.usercrud.core.UserService;
import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.dto.CreateUserInRequest;
import com.meawallet.usercrud.ui.converter.CreateUserInRequestToDomainConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserActionTest {

    @Mock
    private UserInput userInput;
    @Mock
    private UserService userService;
    @Mock
    private CreateUserInRequestToDomainConverter converter;
    @Captor
    private ArgumentCaptor<CreateUserInRequest> captor;

    @InjectMocks
    private CreateUserAction createUserAction;

    @Test
    void shouldReturnCreateUserAsActionName() {
        String expectedResult = "Create user";

        String actualResult = createUserAction.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldCallUserServiceToCreateAUser() {
        CreateUserInRequest request = request();
        when(userInput.getCreateUserInRequest()).thenReturn(request);
        when(converter.convert(request)).thenReturn(user());

        createUserAction.execute();

        verify(userInput).getCreateUserInRequest();
        verify(converter).convert(captor.capture());

        CreateUserInRequest capturedRequest = captor.getValue();
        assertNotNull(capturedRequest);
        assertNotNull(capturedRequest.getAge());
        assertEquals("Test user", capturedRequest.getName());

//        verify(converter, times(3)).convert(any());
//        verify(converter, never()).convert(any());


        verify(userService).createUser(user());
    }


    private CreateUserInRequest request() {
        return new CreateUserInRequest(
                "Test user",
                20
        );
    }

    private User user() {
        return User.builder()
                   .name("Test user")
                   .age(20)
                   .build();
    }
}
