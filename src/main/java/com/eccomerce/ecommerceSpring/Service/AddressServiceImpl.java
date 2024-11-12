package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Address;
import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Exceptions.ApiException;
import com.eccomerce.ecommerceSpring.Reposity.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    private AddressRepository addressRepository;
    private UserService userService;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserService userService) {
        this.addressRepository = addressRepository;
        this.userService = userService;
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new ApiException("Address not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Address saveAddress(Address address) {
        User user = userService.findCurrentUser();
        Address newAddress = new Address();
        newAddress.setCity(address.getCity());
        newAddress.setFullAddress(address.getFullAddress());
        newAddress.setDistrict(address.getDistrict());
        newAddress.setPostalCode(address.getPostalCode());
        newAddress.setUser(user);
        return addressRepository.save(newAddress);
    }

    @Override
    public Address updateAddress(Address address){
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getUserAddress() {
        User user = userService.findCurrentUser();
        return user.getAddresses();
    }

    @Override
    public Address delete(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(()-> new ApiException("Kullanıcı bulunamadı.",HttpStatus.NOT_FOUND));
        addressRepository.deleteById(id);
        return address;
    }

}
