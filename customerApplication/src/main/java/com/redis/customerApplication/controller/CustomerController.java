/**
 * 
 */
package com.redis.customerApplication.controller;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.customerApplication.pojo.Customer;
import com.redis.customerApplication.service.CustomerService;

/**
 * @author smangrul
 *
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		 Customer customerR=customerServiceImpl.createCustomer(customer);
		 
		return new ResponseEntity<Customer>(customerR, HttpStatus.OK);
	}

	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>>search(){
		List<Customer> customers = customerServiceImpl.getCustomers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerById/{customerid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String customerid) {
		// logger.info("Getting customer with ID {}.", id);
		Customer customers = customerServiceImpl.get(customerid).get();
		return new ResponseEntity<Customer>(customers, HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomerById( @RequestBody Customer customer) {
		Customer customers = customerServiceImpl.updateCustomerById(customer);
		return new ResponseEntity<Customer>(customers, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable String id) {
		customerServiceImpl.deleteCustomer(id);
		return new ResponseEntity<String>("Customer Deleted", HttpStatus.OK);

	}



	
}
