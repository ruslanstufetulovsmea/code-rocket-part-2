package com.meawallet.usercrud;

import com.meawallet.usercrud.common.UserRepositoryFactory;
import com.meawallet.usercrud.core.UserService;
import com.meawallet.usercrud.database.UserRepository;
import com.meawallet.usercrud.ui.CreateUserAction;
import com.meawallet.usercrud.ui.MenuAction;
import com.meawallet.usercrud.ui.UserInput;
import com.meawallet.usercrud.ui.UserMenu;
import com.meawallet.usercrud.ui.converter.CreateUserInRequestToDomainConverter;

import java.util.List;

public class UserCrudApplication {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        String name = args[0];
        UserRepository userRepository = UserRepositoryFactory.create(name);
        UserService userService = new UserService(userRepository);
        CreateUserInRequestToDomainConverter createUserInRequestToDomainConverter = new CreateUserInRequestToDomainConverter();
        List<MenuAction> actions = List.of(
                new CreateUserAction(userInput, userService, createUserInRequestToDomainConverter)
        );

        UserMenu userMenu = new UserMenu(userInput, actions);

        userMenu.startMenu();
    }

}
