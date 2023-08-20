package com.demo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.Customer;
import com.demo.service.CustomerService;


@Controller
@RequestMapping(method=RequestMethod.GET, value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public String getCustomers(Model model) {
		List<Customer> allcustomers=new ArrayList<>(customerservice.getAllCustomers());
		model.addAttribute("allcustomers", allcustomers);
		return "allcustomers";
		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/showform")
	public String showForm(Model model) {
		
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "form";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/savecustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerservice.insertCustomer(customer);
		return "redirect:/customer/list";
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/updateform")
	public String showFormUpdate(Model model, @RequestParam("customerId") int id) {
		
		//request.getParameter cannot be done because this is spring mvc not servlets!
//		System.out.println("UPDATE FORM");
		Customer curr_customer=customerservice.getCustomer(id);
		System.out.println(curr_customer);
		model.addAttribute("customer", curr_customer);
		
		return "form";
		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/deletecustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		customerservice.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	
	
	
	
	
	

}
