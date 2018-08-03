/**
 * 
 */
package com.cache.CacheImplementation.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cache.CacheImplementation.pojo.Customer;


/**
 * @author smangrul
 *
 */
@Repository
public interface CustomerDAO extends CrudRepository<Customer, String> {

	Optional<Customer> findById(String Id);

	void deleteById(String id);
}
