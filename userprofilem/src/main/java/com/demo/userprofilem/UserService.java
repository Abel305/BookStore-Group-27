package com.demo.userprofilem;
 import com.demo.userprofilem.User;
 import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserByUsername(String username);

    List<User> getAllUsers();

    User updateUser(String username, User user);


    CreditCard createCreditCard(String username, CreditCard creditCard);

}
