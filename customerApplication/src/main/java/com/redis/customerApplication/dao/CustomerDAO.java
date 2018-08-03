/**
 * 
 */
package com.redis.customerApplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */
public interface CustomerDAO extends JpaRepository<Customer, String> {
	Optional<Customer> findById(String Id);

	void deleteById(String id);
}
