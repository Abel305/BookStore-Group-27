package com.example.UserProfile.CreditCard;

import com.example.UserProfile.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.UserProfile.userRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping("/users/{username}/credit-cards")
    public ResponseEntity<Void> createCreditCardForUser(@PathVariable String username, @RequestBody CreditCard creditCard) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            creditCard.setUserId(user.getId());
            creditCardRepository.save(creditCard);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}

