package com.demo.service;

import java.util.List;

import com.demo.model.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	Customer getCustomer(int cid);
	int deleteCustomer(int cid);
	void insertCustomer(Customer cobj);

}
