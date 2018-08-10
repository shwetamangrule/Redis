/**
 * 
 */
package com.redis.customerApplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.redis.customerApplication.dao.CustomerDAO;
import com.redis.customerApplication.exception.CachingException;
import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */
public class CustomerRedisDbServiceImpl implements CustomerRedisDbService{

	/** ----------Log---------------. */
	Logger logger = LoggerFactory.getLogger(CustomerCachingService.class);

	/** ------------customerDAO object-----------------. */
	@Autowired
	CustomerDAO customerDAO;

	/** ------------environment-----------------. */
	@Autowired
	private Environment environment;
	
	/**/
	/*
	 * crating customer with id, firstName, lastName, address, contact
	 * 
	 * @see
	 * com.redis.customerApplication.service.CustomerCachingService#createCustomer(com.
	 * redis.customerApplication.Customer)
	 */
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customers = customerDAO.save(customer);
		// logger.info(customer.getId());
		return customers;

	}

	/*
	 * showing customers
	 * 
	 * @see com.redis.customerApplication.service.CustomerCachingService#getCustomers()
	 */
	@Override
	public List<Customer> getCustomers() throws CachingException {
		logger.info("in customer service calling getCustomer");
		List<Customer> customer = customerDAO.findAll();
		if (customer.isEmpty()) {
			throw new CachingException(environment.getProperty("200"));
		} else {
			logger.info("Customers Found");
			return customer;
		}
	}

}
