/**
 * 
 */
package com.cache.CacheImplementation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cache.CacheImplementation.pojo.Customer;
import com.cache.CacheImplementation.service.CustomerServiceImpl;


/**
 * @author smangrul
 *
 */
@RestController
public class CustomerController {
	
	 private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	 @PostMapping("/create")
	    public ResponseEntity<Integer> create(@RequestBody Customer customer) {
	        customerServiceImpl.createCustomer(customer);
	        return new ResponseEntity<Integer>(1, HttpStatus.OK);
	    }
	 
//	 @RequestMapping("/cachable")
//	    public Customer get(@RequestParam("id")String id){
//	 
//	        return  customerServiceImpl.get(id);
//	    }
//	 @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
//	 @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
//	 public Customer getCustomer(@PathVariable String customerId) {
//	   logger.info("Getting user with ID {}.", customerId);
//	   return customerDAO.findOne(Long.valueOf(customerId));
//	 }

}
