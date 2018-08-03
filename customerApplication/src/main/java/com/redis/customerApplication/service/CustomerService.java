/**
 * 
 */
package com.redis.customerApplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.customerApplication.dao.CustomerDAO;
import com.redis.customerApplication.pojo.Customer;



/**
 * @author smangrul
 *
 */
@Service
public class CustomerService implements CustomerServiceImpl {
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public int createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customers = customerDAO.save(customer);
		return 1;
	
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		customerDAO.findAll();
		logger.info("Done");
		return null;
	}

	@Override
	public int deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
