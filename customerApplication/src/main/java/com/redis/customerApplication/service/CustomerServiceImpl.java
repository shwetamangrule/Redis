/**
 * 
 */
package com.redis.customerApplication.service;

import java.util.List;

import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */

public interface CustomerServiceImpl {
	public int createCustomer(Customer customer);

	public List<Customer> getCustomers();

	public int deleteCustomer(String id);

	public int updateCustomer(Customer customer);

	public String get(String id);

	public String findById(String id);

}
