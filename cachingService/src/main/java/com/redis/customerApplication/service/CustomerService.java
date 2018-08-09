/**
 * 
 */
package com.redis.customerApplication.service;

import java.util.List;
import java.util.Optional;

import com.redis.customerApplication.exception.CachingException;
import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */

public interface CustomerService {

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

	/**
	 * @param id
	 * @return customer
	 * @throws CachingException
	 */
	public Customer getCustomer(String id) throws CachingException;

	/**
	 * @param customer
	 * @return customer
	 * @throws CachingException
	 */
	public Customer updateCustomerById(Customer customer) throws CachingException;

	/**
	 * @param id
	 * @return String
	 * @throws CachingException
	 */
	public String deleteCustomer(String id) throws CachingException;

}
