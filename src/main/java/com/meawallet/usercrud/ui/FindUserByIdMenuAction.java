package com.meawallet.usercrud.ui;

import com.meawallet.usercrud.core.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindUserByIdMenuAction implements MenuAction {

    private final UserService userService;
    private final UserInput userInput;

    @Override
    public String getName() {
        return "Find user by id";
    }

    @Override
    public void execute() {
        var id = userInput.getUserId();
        var user = userService.getUserById(id);
        System.out.println("User: " + user);
    }
}
