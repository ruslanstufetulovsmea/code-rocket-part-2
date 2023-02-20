package com.meawallet.usercrud.ui;

import com.meawallet.usercrud.dto.CreateUserInRequest;
import com.meawallet.usercrud.ui.exception.UserValidationException;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInput {

    public int getMenuAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter menu action: ");
        return scanner.nextInt();
    }

    public CreateUserInRequest getCreateUserInRequest() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter user name:");
            String name = scanner.nextLine();
            System.out.println("Please enter user age:");
            Integer age = Integer.valueOf(scanner.nextLine());
            return new CreateUserInRequest(name, age);
        } catch (NumberFormatException e) {
            throw new UserValidationException("User age incorrect, message: " + e.getMessage());
        }
    }

    public Integer getUserId() {
        var scanner = new Scanner(System.in);
        System.out.println("Please enter user id: ");
        return scanner.nextInt();
    }
}
