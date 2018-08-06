/**
 * 
 */
package com.redis.customerApplication.service;

import java.util.List;
import java.util.Optional;

import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */

public interface CustomerService {
	public Customer createCustomer(Customer customer);

	public List<Customer> getCustomers();

	public Optional<Customer> get(String id);

	public int deleteCustomer(String id);

	public Customer updateCustomerById(Customer customer);

}
