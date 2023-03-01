package com.meawallet.usercrud.in.controller;

import com.meawallet.usercrud.core.port.in.GetUserUseCase;
import com.meawallet.usercrud.core.port.in.SaveUserUseCase;
import com.meawallet.usercrud.in.converter.CreateUserInRequestToDomainConverter;
import com.meawallet.usercrud.in.converter.UserToCreateUserInResponseConverter;
import com.meawallet.usercrud.in.converter.UserToGetUserInResponseConverter;
import com.meawallet.usercrud.in.dto.CreateUserInRequest;
import com.meawallet.usercrud.in.dto.CreateUserInResponse;
import com.meawallet.usercrud.in.dto.GetUserInResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
public class UserController {

    private final SaveUserUseCase saveUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final CreateUserInRequestToDomainConverter createUserInRequestToDomainConverter;
    private final UserToGetUserInResponseConverter userToGetUserInResponseConverter;
    private final UserToCreateUserInResponseConverter userToCreateUserInResponseConverter;

    //    @RequestMapping(method = RequestMethod.POST, path = "/users")
    @PostMapping(value = "/users")
    public ResponseEntity<CreateUserInResponse> create(@RequestBody CreateUserInRequest request) {
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
        var user = getUserUseCase.getUser(id);
        return userToGetUserInResponseConverter.convert(user);
    }
}
