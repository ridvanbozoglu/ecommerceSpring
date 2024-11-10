package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Address;
import com.eccomerce.ecommerceSpring.Entity.User;
import com.eccomerce.ecommerceSpring.Reposity.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address saveAddress(User user, Address address) {
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
    public Address deleteAddress(Address address) {
        addressRepository.delete(address);
        return address;
    }
}
