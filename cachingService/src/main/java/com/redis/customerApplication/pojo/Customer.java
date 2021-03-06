/**
 * 
 */
package com.redis.customerApplication.pojo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.data.redis.core.RedisHash;

/**
 * @author smangrul
 *
 */
@RedisHash("Customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6655163215861232438L;

	@Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_CUSTOMER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private String id;
	
	private String firstName;
	private String lastName;
	private String address;
	private String contact;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param contact
	 */
	public Customer(String firstName, String lastName, String address, String contact) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
	}

	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {

		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the id
	 */
	

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", contact=" + contact + "]";
	}

}
