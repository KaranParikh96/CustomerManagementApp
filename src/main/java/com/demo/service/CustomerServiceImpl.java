package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CustomerDao;
import com.demo.model.Customer;

@Service("customerservice")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerrepo;

	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		return customerrepo.getAllCustomers();
		
	}

	@Override
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
//		System.out.println("CID"+" "+cid);
		return customerrepo.getCustomer(cid);
	}

	@Override
	public int deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		return customerrepo.deleteCustomer(cid);
	}

	@Override
	public void insertCustomer(Customer cobj) {
		// TODO Auto-generated method stub
		
		customerrepo.insertCustomer(cobj);
		
	}

}
