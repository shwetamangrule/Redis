/**
 * 
 */
package com.redis.customerApplication.controller;

import java.util.List;
//import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.customerApplication.exception.CachingException;
import com.redis.customerApplication.pojo.Customer;
import com.redis.customerApplication.service.CustomerService;

/**
 * @author smangrul
 *
 */
@RestController
public class CustomerController {

	/** ----------Log---------------. */
	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	/** ------------customerService object-----------------. */
	@Autowired
	CustomerService customerServiceImpl;

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
		Customer customerR = customerServiceImpl.createCustomer(customer);

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
		List<Customer> customers = customerServiceImpl.getCustomers();
		if (customers != null) {
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * finding customer by id, initially when we hit the url we will get the
	 * customer object from database this microservice is integrated with, later
	 * when the url is hit we will get the customer object from Redis Cache
	 * 
	 * @return Customer
	 * @throws CachingException
	 */
	@Cacheable(value = "customers", key = "#id")
	@GetMapping("/getCustomerById/{id}")
	public Customer getCustomer(@PathVariable String id) throws CachingException {
		logger.info("Getting customer with ID {}.", id);
		return customerServiceImpl.getCustomer(id);
//		if (customer != null) {
//			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<String>(environment.getProperty("200"), HttpStatus.BAD_REQUEST);
//		}

	}

	/**
	 * updating the customer in redis cache this update will reflect into database
	 * as well
	 * 
	 * @return Customer
	 * @throws CachingException
	 */
	@CachePut(value = "users", key = "#customer.id")
	@PutMapping("/updateCustomer")
	public Customer updateCustomerById(@RequestBody Customer customer) throws CachingException {
		logger.info("calling update customer");
		Customer customers = customerServiceImpl.updateCustomerById(customer);
//		if(customer != null) {
//			return new ResponseEntity<Customer>(customers, HttpStatus.OK);
//		}else {
//			return new ResponseEntity<String>(environment.getProperty("200"), HttpStatus.BAD_REQUEST);
//		}
//		
		return customers;
	}

	/**
	 * deleting the customer object from redis cache
	 * 
	 * @return String
	 * @throws CachingException
	 */
	@CacheEvict(value = "customers", allEntries = true)
	@DeleteMapping("/delete/{id}")
	public String deleteCustomerById(@PathVariable String id) throws CachingException {
		customerServiceImpl.deleteCustomer(id);
		return "Customer Deleted";

	}

}
