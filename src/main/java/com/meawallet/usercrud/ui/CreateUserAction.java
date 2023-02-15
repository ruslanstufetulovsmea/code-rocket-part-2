package com.meawallet.usercrud.ui;


import com.meawallet.usercrud.core.UserService;
import com.meawallet.usercrud.domain.User;
import com.meawallet.usercrud.dto.CreateUserInRequest;
import com.meawallet.usercrud.ui.converter.CreateUserInRequestToDomainConverter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserAction implements MenuAction {

    private final UserInput userInput;
    private final UserService userService;
    private final CreateUserInRequestToDomainConverter converter;

    @Override
    public String getName() {
        return "Create user";
    }

    @Override
    public void execute() {
        CreateUserInRequest request = userInput.getCreateUserInRequest();
        User user = converter.convert(request);
        userService.createUser(user);
    }
}
