package com.meawallet.usercrud.in;

import com.meawallet.usercrud.core.port.in.GetUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindUserByIdMenuAction implements MenuAction {

    private final UserInput userInput;
    private final GetUserUseCase getUserUseCase;

    @Override
    public String getName() {
        return "Find user by id";
    }

    @Override
    public void execute() {
        var id = userInput.getUserId();
        var user = getUserUseCase.getUser(id);
        System.out.println("User: " + user);
    }
}
