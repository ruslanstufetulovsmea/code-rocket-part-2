package com.meawallet.usercrud.core;

import com.meawallet.usercrud.database.UserRepository;
import com.meawallet.usercrud.domain.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@MockitoSettings
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService victim;

    @Mock
    private User user;

    @Test
    void shouldThrowExceptionIfUserNotFound() {
        when(repository.findUserById(1)).thenReturn(Optional.empty());

        var exception = assertThrows(IllegalArgumentException.class, () -> victim.getUserById(1));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void shouldReturnUserIfFound() {
        when(repository.findUserById(1)).thenReturn(Optional.of(user));

        var actual = victim.getUserById(1);

        assertNotNull(actual);
    }
}
