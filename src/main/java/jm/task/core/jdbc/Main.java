package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = new ArrayList<>();
        User vadim = new User("Vadim", "Semenyta",(byte)26);
        User tatyana = new User("Tatyana", "Varshavskaya",(byte)24);
        User petr = new User("Petr", "Petrov",(byte)34);
        User alexandra = new User("Alexandra", "Aleshina",(byte)21);
        userList.add(vadim);
        userList.add(tatyana);
        userList.add(petr);
        userList.add(alexandra);
        userService.createUsersTable();

        for (User user : userList) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем : " + user.getName() + " добавлен в базу данных");
        }

        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
