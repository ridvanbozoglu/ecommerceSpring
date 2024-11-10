package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.CreditCard;
import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Reposity.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService{
    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public CreditCard save(User user, CreditCard creditCard) {
        creditCard.setUser(user);
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard update(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard delete(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow(() -> new RuntimeException("Credit card does not exists"));
        creditCardRepository.deleteById(id);
        return creditCard;
    }
}
