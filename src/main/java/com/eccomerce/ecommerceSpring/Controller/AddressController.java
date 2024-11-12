package com.eccomerce.ecommerceSpring.Controller;

import com.eccomerce.ecommerceSpring.Entity.Address;
import com.eccomerce.ecommerceSpring.Service.AddressService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> getUserAddress(){
        return addressService.getUserAddress();
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable Long id){
        return addressService.delete(id);
    }

    @PutMapping("/")
    public Address update(@RequestBody Address address){
        return addressService.updateAddress(address);
    }

    @PostMapping("/")
    public Address save(@RequestBody Address address){
        return addressService.saveAddress(address);
    }
}
