package com.meawallet.usercrud.in.controller;

import com.meawallet.usercrud.core.port.in.DeleteUserByIdUseCase;
import com.meawallet.usercrud.core.port.in.GetAllUsersUseCase;
import com.meawallet.usercrud.core.port.in.GetUserUseCase;
import com.meawallet.usercrud.core.port.in.SaveUserUseCase;
import com.meawallet.usercrud.core.port.in.UpdateUserUseCase;
import com.meawallet.usercrud.in.converter.CreateUserInRequestToDomainConverter;
import com.meawallet.usercrud.in.converter.UpdateUserInRequestToUserConverter;
import com.meawallet.usercrud.in.converter.UserToCreateUserInResponseConverter;
import com.meawallet.usercrud.in.converter.UserToGetUserInResponseConverter;
import com.meawallet.usercrud.in.dto.CreateUserInRequest;
import com.meawallet.usercrud.in.dto.CreateUserInResponse;
import com.meawallet.usercrud.in.dto.GetUserInResponse;
import com.meawallet.usercrud.in.dto.UpdateUserInRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final SaveUserUseCase saveUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final CreateUserInRequestToDomainConverter createUserInRequestToDomainConverter;
    private final UserToGetUserInResponseConverter userToGetUserInResponseConverter;
    private final UserToCreateUserInResponseConverter userToCreateUserInResponseConverter;
    private final UpdateUserInRequestToUserConverter updateUserInRequestToUserConverter;

    //    @RequestMapping(method = RequestMethod.POST, path = "/users")
    @PostMapping(value = "/users")
    public ResponseEntity<CreateUserInResponse> create(@Valid @RequestBody CreateUserInRequest request) {
        log.debug("Received create user request: {}", request);
        var user = createUserInRequestToDomainConverter.convert(request);
        var createdUser = saveUserUseCase.saveUser(user);
        var responseBody = userToCreateUserInResponseConverter.convert(createdUser);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                             .body(responseBody);
    }

    @GetMapping(value = "/users/{id}")
    public GetUserInResponse findUserById(@PathVariable Integer id) {
        log.debug("Received find user by id request: {}", id);
        var user = getUserUseCase.getUser(id);
        return userToGetUserInResponseConverter.convert(user);
    }


    @GetMapping(value = "/users")
    public List<GetUserInResponse> findAll() {
        log.debug("Received find all users request");
        return getAllUsersUseCase.getAll().stream()
                                 .map(userToGetUserInResponseConverter::convert)
                                 .collect(Collectors.toList());
    }


    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        log.debug("Received delete user by id request: {}", id);
        deleteUserByIdUseCase.deleteById(id);
    }


    @PutMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody UpdateUserInRequest updateUserInRequest, @PathVariable Integer id) {
        log.debug("Received update user request: {}, id: {}", updateUserInRequest, id);
        var user = updateUserInRequestToUserConverter.convert(updateUserInRequest, id);
        updateUserUseCase.update(user);
    }
}
