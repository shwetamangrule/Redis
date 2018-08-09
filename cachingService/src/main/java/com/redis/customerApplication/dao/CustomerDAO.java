/**
 * 
 */
package com.redis.customerApplication.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */
public interface CustomerDAO extends JpaRepository<Customer, String> {
	//Optional findById(String id);

	void deleteById(String id);
}
