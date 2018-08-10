/**
 * 
 */
package com.redis.customerApplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.redis.customerApplication.exception.CachingException;
import com.redis.customerApplication.pojo.Customer;
import com.redis.customerApplication.service.CustomerCachingService;
import com.redis.customerApplication.service.CustomerRedisDbService;

/**
 * @author smangrul
 *
 */
public class CustomerRedisDbController {
	
	/** ----------Log---------------. */
	Logger logger = LoggerFactory.getLogger(CustomerCachingController.class);

	/** ------------customerService object-----------------. */
	@Autowired
	CustomerRedisDbService customerRedisDbService;

	/** ------------environment-----------------. */
	@Autowired
	Environment environment;

	/**
	 * to add a customer object
	 * 
	 * @param customer object
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		Customer customerR = customerRedisDbService.createCustomer(customer);

		return new ResponseEntity<Customer>(customerR, HttpStatus.OK);
	}

	/**
	 * finding all the customers
	 * 
	 * @return
	 * @throws CachingException
	 */
	@GetMapping("/viewAllCustomers")
	public ResponseEntity<?> search() throws CachingException {
		logger.info("calling controller view all the customers  ");
		List<Customer> customers = customerRedisDbService.getCustomers();
		if (customers != null) {
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);
		}
	}


}
