package com.eccomerce.ecommerceSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class EcommerceSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSpringApplication.class, args);


	}
}

// USER : email = robert.taylor@example.com password = robtay789
// ADMIN : email = rıd@example.com password = 1234

// Create user

// Auth test -> POST -> http://localhost:9090/workintech/auth/
// {"firstName": "Fizz","lastName": "Buzz","email": "fizzbuzz@example.com","password": "0000","role": "USER"}

// Add product to cart and retrieve authenticated users shopping cart

// Cart test -> POST -> http://localhost:9090/workintech/cart/
// [{"item_id":3,"quantity":6},{"item_id":1,"quantity":1},{"item_id":6,"quantity":6},{"item_id":8,"quantity":2},{"item_id":2,"quantity":6}]
// Cart test -> GET -> http://localhost:9090/workintech/cart/

// Product filtering and sorting

//All products with pagination

// No filter -> GET -> http://localhost:9090/workintech/products/
// No filter with price asc and limit 5 offset 2(second page) -> GET -> http://localhost:9090/workintech/products/?sort=price:asc&limit=5&offset=2

//All products with only category filtered

// Filter by category Shoes -> GET -> http://localhost:9090/workintech/products/?category=Shoes

//Category filtered with pagination

// Filter by category Shoes page 0 and limit 5-> GET -> http://localhost:9090/workintech/products/?category=Shoes&sort=price:asc&limit=5&offset=0
