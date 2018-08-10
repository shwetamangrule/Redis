/**
 * 
 */
package com.redis.customerApplication.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.redis.customerApplication.dao.CustomerDAO;
import com.redis.customerApplication.exception.CachingException;
import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */
@Service
public class CustomerCachingServiceImpl implements CustomerCachingService {

	/** ----------Log---------------. */
	Logger logger = LoggerFactory.getLogger(CustomerCachingService.class);

	/** ------------customerDAO object-----------------. */
	@Autowired
	CustomerDAO customerDAO;

	/** ------------environment-----------------. */
	@Autowired
	private Environment environment;

	
	/*
	 * get customer by id
	 * 
	 * @see
	 * com.redis.customerApplication.service.CustomerCachingService#getCustomer(java.lang.
	 * String)
	 */
	@Override
	public Customer getCustomer(String id) throws CachingException {
		logger.info("Getting customer with ID {}.", id);
		Optional<Customer> customer = customerDAO.findById(id);
		if (customer.isPresent()) {
			logger.info("from database>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			return customer.get();
		} else {
			throw new CachingException(environment.getProperty("200"));
		}

	}

	/*
	 * update customer by id
	 * 
	 * @see
	 * com.redis.customerApplication.service.CustomerCachingService#updateCustomerById(com.
	 * redis.customerApplication.Customer)
	 */
	@Override
	public Customer updateCustomerById(Customer customer) throws CachingException {
		logger.info("updating customer with id {}");
		if (customer != null && customer.getId() != null & customer.getLastName() != null) {
			Customer customerUpdate = customerDAO.findById(customer.getId()).get();
			customerUpdate.setAddress(customer.getAddress());
			customerUpdate.setContact(customer.getContact());
			return customerDAO.save(customerUpdate);
		} else {
			throw new CachingException(environment.getProperty("7777"));
		}

	}

	/*
	 * delete customer by id
	 * 
	 * @see
	 * com.redis.customerApplication.service.CustomerCachingService#deleteCustomer(java
	 * .lang.String)
	 */
	@Override
	public String deleteCustomer(String id) throws CachingException {
		// TODO Auto-generated method stub
		logger.info("deleting customer with id {}", id);
		if (id != null) {
			Optional<Customer> customer = customerDAO.findById(id);
			if (customer.isPresent()) {
				customerDAO.deleteById(id);
				return "Customer Deleted";
			} else {
				throw new CachingException(environment.getProperty("200"));
			}
		}

		else {
			throw new CachingException(environment.getProperty("201"));
		}
	}

}
