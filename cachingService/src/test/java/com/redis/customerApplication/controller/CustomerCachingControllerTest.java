/**
 * 
 */
package com.redis.customerApplication.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.redis.customerApplication.exception.CachingException;
import com.redis.customerApplication.pojo.Customer;
import com.redis.customerApplication.service.CustomerCachingService;

/**
 * @author smangrul
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerCachingControllerTest {

	/** --------environment object to get in application properties-------. */
	@Mock
	Environment environment;

	/** ---------------mock customer service--------. */
	@Mock
	CustomerCachingService customerServiceImpl;

	/** ---------------inject customer controller--------. */
	@InjectMocks
	CustomerCachingController customerCachingController;

	@Test
	public void testGetCustomer() throws CachingException {
		Customer customer = new Customer();
		when(customerServiceImpl.getCustomer("1")).thenReturn(customer);
		assertEquals(customer, customerCachingController.getCustomer("1"));
	}

	@Test
	public void testUpdateCustomerById() throws CachingException {
		Customer customer = new Customer();
		customer.setId("1");
		customer.setLastName("Mangrule");
		customer.setContact("876534");
		Customer customer2 = new Customer();
		when(customerServiceImpl.updateCustomerById(customer)).thenReturn(customer2);
		assertEquals(customer2, customerCachingController.updateCustomerById(customer));

	}

	@Test
	public void testDeleteCustomerById() throws CachingException {
		when(customerServiceImpl.deleteCustomer("1")).thenReturn("Customer Deleted");
		assertEquals("Customer Deleted", customerCachingController.deleteCustomerById("1"));
	}
}
