/**
 * 
 */
package com.redis.customerApplication.service;

import java.util.List;

import com.redis.customerApplication.exception.CachingException;
import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */
public interface CustomerRedisDbService {
	
	/**
	 * @param customer
	 * @return customer
	 */
	public Customer createCustomer(Customer customer);

	/**
	 * @return list of customer
	 * @throws CachingException
	 */
	public List<Customer> getCustomers() throws CachingException;


}
