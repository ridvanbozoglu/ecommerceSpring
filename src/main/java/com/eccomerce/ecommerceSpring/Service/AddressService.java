package com.eccomerce.ecommerceSpring.Service;

import com.eccomerce.ecommerceSpring.Entity.Address;
import com.eccomerce.ecommerceSpring.Entity.User;

public interface AddressService {
    Address saveAddress(User user, Address address);
    Address deleteAddress(Address address);
    Address updateAddress(Address address);
}
