package com.demo.userprofilem;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String username,User user) {
        User existingUser = userRepository.findByUsername(username).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setHomeAddress(user.getHomeAddress());
            return userRepository.save(existingUser);
        }
        return null;
    }



    @Override
    public CreditCard createCreditCard(String username, CreditCard creditCard) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            user.getCreditCards().add(creditCard);
            userRepository.save(user);
        }
        return creditCard;
    }
}
