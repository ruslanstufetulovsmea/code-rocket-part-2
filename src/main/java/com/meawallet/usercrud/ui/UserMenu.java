package com.meawallet.usercrud.ui;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserMenu {

    private final UserInput userInput;
    private final List<MenuAction> actions;

    public void startMenu() {
        while (true) {
            System.out.println("Hello");

            try {
                for (int i = 0; i < actions.size(); i++) {
                    System.out.println(i + ". " + actions.get(i).getName());
                }

                int number = userInput.getMenuAction();

                MenuAction menuAction = actions.get(number);
                menuAction.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
