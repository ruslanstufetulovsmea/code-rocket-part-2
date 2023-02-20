package com.meawallet.usercrud.ui;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMenu {

    private final UserInput userInput;
    private final List<MenuAction> userReadMenuActions;

    public UserMenu(UserInput userInput, List<MenuAction> userReadMenuActions) {
        this.userInput = userInput;
        this.userReadMenuActions = userReadMenuActions;
    }

    public void startMenu() {
        while (true) {
            System.out.println("Hello");

            try {
                for (int i = 0; i < userReadMenuActions.size(); i++) {
                    System.out.println(i + ". " + userReadMenuActions.get(i).getName());
                }

                int number = userInput.getMenuAction();

                checkUserInput(number);

                MenuAction menuAction = userReadMenuActions.get(number);
                menuAction.execute();
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect menu action, please try again.");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkUserInput(int number) {
        if (number < 0 || number >= userReadMenuActions.size()) {
            throw new IllegalArgumentException("Incorrect menu action.");
        }
    }
}
