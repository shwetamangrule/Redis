/**
 * 
 */
package com.redis.customerApplication.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.redis.customerApplication.dao.CustomerDAO;
import com.redis.customerApplication.exception.CachingException;
import com.redis.customerApplication.pojo.Customer;

/**
 * @author smangrul
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerCachingServiceTest {

	/**
	 * -----environment object to get in application properties---------------.
	 */
	@Mock
	private Environment environment;

	/** -----------to mock customerDAO ------. */
	@Mock
	CustomerDAO customerDAO;

	/** ---------------inject customer service--------. */
	@InjectMocks
	CustomerCachingServiceImpl customerCachingServiceImpl;

	@Test
	public void testGetCustomer() throws CachingException {

		Customer customer = new Customer();
		customer.setId("1");
		customer.setContact("8766764");
		customer.setLastName("Mangrule");
		customer.setAddress("address");
		Optional<Customer> customerOpt = Optional.of(customer);
		// when(customerDAO.save(customer)).thenReturn(customer);
		// Customer customer2 = new Customer();
		when(customerDAO.findById("1")).thenReturn(customerOpt);
		assertEquals(customer, customerCachingServiceImpl.getCustomer("1"));
	}

	@Test
	public void testUpdateCustomerById() throws CachingException {

		Customer customer = new Customer();
		customer.setId("1");
		customer.setContact("8766764");
		customer.setLastName("Mangrule");
		// Customer customer2 = new Customer();
		Optional<Customer> testUpdate = Optional.of(customer);
		when(customerDAO.findById(customer.getId())).thenReturn(testUpdate);
		Customer customer2 = testUpdate.get();
		customer2.setContact("876534");
		customer2.setAddress("address");
		when(customerDAO.save(customer2)).thenReturn(customer2);
		assertEquals(customer2, customerCachingServiceImpl.updateCustomerById(customer2));
	}

	@Test
	public void testDeleteCustomer() throws CachingException {
		Customer customer = new Customer();
		customer.setId("1");
		customer.setContact("8766764");
		customer.setLastName("Mangrule");
		customer.setAddress("address");
		Optional<Customer> customerOpt = Optional.of(customer);
		// when(customerDAO.save(customer)).thenReturn(customer);
		// Customer customer2 = new Customer();
		when(customerDAO.findById("1")).thenReturn(customerOpt);
		doNothing().when(customerDAO).deleteById(customerOpt.get().getId());
		assertEquals("Customer Deleted", customerCachingServiceImpl.deleteCustomer("1"));

	}
}
