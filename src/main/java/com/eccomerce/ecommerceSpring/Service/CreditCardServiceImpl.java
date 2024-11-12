package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.CreditCard;
import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Exceptions.ApiException;
import com.eccomerce.ecommerceSpring.Reposity.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService{
    private CreditCardRepository creditCardRepository;
    private UserService userService;

    @Autowired
    public CreditCardServiceImpl(CreditCardRepository creditCardRepository, UserService userService) {
        this.creditCardRepository = creditCardRepository;
        this.userService = userService;
    }

    @Override
    public CreditCard findById(Long id) {
        return creditCardRepository.findById(id).orElseThrow(()-> new ApiException("Card not found!",HttpStatus.NOT_FOUND));
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        User user = userService.findCurrentUser();
        creditCard.setUser(user);
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard update(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard delete(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow(() -> new ApiException("Credit card does not exists", HttpStatus.NOT_FOUND));
        creditCardRepository.deleteById(id);
        return creditCard;
    }

    @Override
    public List<CreditCard> findAll() {
        User user = userService.findCurrentUser();
        return user.getCreditCards();
    }
}
