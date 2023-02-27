package com.meawallet.usercrud.in;


import com.meawallet.usercrud.core.port.in.SaveUserUseCase;
import com.meawallet.usercrud.in.converter.CreateUserInRequestToDomainConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserAction implements MenuAction {

    private final UserInput userInput;
    private final SaveUserUseCase saveUserUseCase;
    private final CreateUserInRequestToDomainConverter converter;

    @Override
    public String getName() {
        return "Create user";
    }

    @Override
    public void execute() {
        var request = userInput.getCreateUserInRequest();
        var user = converter.convert(request);
        saveUserUseCase.saveUser(user);
    }
}
