/**
 * 
 */
package com.cache.CacheImplementation.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cache.CacheImplementation.dao.CustomerDAO;
import com.cache.CacheImplementation.pojo.Customer;



/**
 * @author smangrul
 *
 */
@Service
public class CustomerService implements CustomerServiceImpl{
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public int createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customers = customerDAO.save(customer);
		return 1;
	}
	
	      

//	@Override
//	public List<Customer> getCustomers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int deleteCustomer(String id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	@CachePut(value="customers", key="#customer.id")
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customers = customerDAO.save(customer);
		return 0;
	}
	@Override
	@Cacheable(value="customers", key="#id")
	public String get(String id) {
		// TODO Auto-generated method stub 
		System.out.println("Service processing...");
        try{
            Thread.sleep(3000); 
        }catch(Exception e){
        }
        Optional<Customer> customer = customerDAO.findById(id);
        return null;
	}

//	@Override
//	public String findById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
