package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.CreditCard;
import com.eccomerce.ecommerceSpring.Service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CreditCardController {
    private CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/")
    public List<CreditCard> getUserCards(){
        return creditCardService.findAll();
    }

    @PostMapping("/")
    public CreditCard save(@RequestBody CreditCard creditCard){
        return creditCardService.save(creditCard);
    }

    @PutMapping("/")
    public CreditCard update(@RequestBody CreditCard creditCard){
        return creditCardService.update(creditCard);
    }

    @DeleteMapping("/{id}")
    public CreditCard delete(@PathVariable Long id){
        return creditCardService.delete(id);

    }
}
