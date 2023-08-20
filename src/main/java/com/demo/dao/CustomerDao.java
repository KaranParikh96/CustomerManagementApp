package com.demo.dao;

import java.util.List;

import com.demo.model.Customer;

public interface CustomerDao {
	
	List<Customer> getAllCustomers();
	Customer getCustomer(int cid);
	int deleteCustomer(int cid);
	void insertCustomer(Customer cobj);
	
	

}
