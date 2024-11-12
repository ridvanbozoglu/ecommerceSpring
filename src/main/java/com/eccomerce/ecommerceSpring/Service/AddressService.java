package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Address;
import com.eccomerce.ecommerceSpring.Entity.User;

import java.util.List;

public interface AddressService {
    Address getAddressById(Long id);
    Address saveAddress(Address address);
    Address updateAddress(Address address);
    List<Address> getUserAddress();
    Address delete( Long id);
}
