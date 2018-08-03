/**
 * 
 */
package com.cache.CacheImplementation.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import com.cache.CacheImplementation.dao.CustomerDAO;
import com.cache.CacheImplementation.pojo.Customer;

/**
 * @author smangrul
 *
 */
public class AppRunner implements CommandLineRunner	 {

	 private final Logger logger = LoggerFactory.getLogger(getClass());
	 private CustomerDAO customerDAO;
	  
	  
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 //Populating embedded database here
//	    logger.info("Saving users. Current user count is {}.", customerDAO.count());
//	    Customer shubham = new Customer();
//	    Customer pankaj = new Customer();
//	    Customer lewis = new Customer();
//
//	    customerDAO.save(shubham);
//	    customerDAO.save(pankaj);
//	    customerDAO.save(lewis);
//	    logger.info("Done saving users. Data: {}.", customerDAO.findAll());
//	  }
	}

}
