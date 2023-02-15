package com.meawallet.usercrud.ui;

import com.meawallet.usercrud.dto.CreateUserInRequest;

import java.util.Scanner;

public class UserInput {

    public int getMenuAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter menu action: ");
        return scanner.nextInt();
    }

    public CreateUserInRequest getCreateUserInRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user name:");
        String name = scanner.nextLine();
        System.out.println("Please enter user age:");
        Integer age = Integer.valueOf(scanner.nextLine());

        return new CreateUserInRequest(name, age);
    }
}
