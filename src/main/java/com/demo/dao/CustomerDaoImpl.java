package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Customer;

@Repository("customerrepo")
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	
	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.getTransaction().begin();
//		System.out.println("HELLLLLLLLLLLLLOOOOOOOOOO");
		String selectall="from Customer"; //use only variable/object names now
		

		List<Customer> allcustomers=session.createQuery(selectall).getResultList();

//		System.out.println("SELECT WORKING!");
//		System.out.println(allcustomers);
		return allcustomers;

	}

	@Override
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
		
//		System.out.println("HERE IN DAO");
		Session session=sessionfactory.openSession();
		session.getTransaction().begin();
//		System.out.println("HERE IN DAO");
		String getone="from Customer as c where c.id=:id1";
//		System.out.println("HERE IN DAO");
		Query query=session.createQuery(getone);
		query.setParameter("id1", cid);
//		System.out.println("HERE IN GET CUSTOMER");
		List<Customer> single=query.getResultList();
//		System.out.println(single);
		return single.get(0);
		
		
	}

	@Override
	public int deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.getTransaction().begin();
		
		String deleteone="delete from Customer as c where c.id=:id1";
		Query query=session.createQuery(deleteone);
		query.setParameter("id1", cid);
		int result= query.executeUpdate();
		
		session.getTransaction().commit();
		return result;
	}

	@Override
	public void insertCustomer(Customer cobj) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.getTransaction().begin();
		
		session.saveOrUpdate(cobj);
		
		session.getTransaction().commit();
		session.clear();
	}

}
