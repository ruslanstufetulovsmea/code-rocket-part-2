package com.meawallet.usercrud;

import com.meawallet.usercrud.ui.UserMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserCrudApplication {

    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext("com.meawallet.usercrud", "org.springframework.data");
        var userMenu = applicationContext.getBean(UserMenu.class);
        userMenu.startMenu();
    }

}
