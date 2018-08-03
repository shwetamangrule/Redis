/**
 * 
 */
package com.cache.CacheImplementation.service;

import java.util.List;

import com.cache.CacheImplementation.pojo.Customer;

/**
 * @author smangrul
 *
 */
public interface CustomerServiceImpl {
	public int createCustomer(Customer customer);

	//public List<Customer> getCustomers();

	//public int deleteCustomer(String id);

	public int updateCustomer(Customer customer);

	public String get(String id);

	//public String findById(String id);

}
