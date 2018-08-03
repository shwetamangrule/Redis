/**
 * 
 */
package com.redis.customerApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.customerApplication.pojo.Customer;
import com.redis.customerApplication.service.CustomerServiceImpl;

/**
 * @author smangrul
 *
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<Integer> create(@RequestBody Customer customer) {
		customerServiceImpl.createCustomer(customer);
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}

}
