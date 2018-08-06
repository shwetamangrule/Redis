/**
 * 
 */
package com.redis.customerApplication.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.customerApplication.dao.CustomerDAO;
import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customers = customerDAO.save(customer);
		// logger.info(customer.getId());
		return customers;

	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customer = customerDAO.findAll();
		logger.info("Done");
		return customer;
	}

	@Override
	@Cacheable(value = "customers", key = "#customerid")
	public Optional<Customer> get(String customerid) {
		// TODO Auto-generated method stub
		logger.info("Getting user with ID {}.", customerid);
		logger.info("from database>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return customerDAO.findById(customerid);

	}

	@Override
	@CachePut(value = "customers", key = "#customer.id")
	public Customer updateCustomerById(Customer customer) {
		logger.info("updating customer with id {}");
		Customer customerUpdate = customerDAO.save(customer);
		return customerUpdate;
	}

	@Override
	@CacheEvict(value = "customers", allEntries = true)
	public int deleteCustomer(String id) {
		// TODO Auto-generated method stub
		logger.info("deleting customer with id {}", id);
		customerDAO.deleteById(id);
		return 0;
	}

}
