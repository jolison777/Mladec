package com.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class CustomerData {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		
		Customer c = new Customer();
		int key;
		do{
			System.out.println("Enter your choice : ");
			System.out.println("1 --> Insert Data\n"
					+ "2 --> Update Data\n"
					+ "3 --> Delete Data\n"
					+ "4 --> Display Data\n"
					+ "5 --> Exit ");
			key = Build.getin().nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter name : ");
				String name = Build.getin().next();
				System.out.println("Enter Address : ");
				String address = Build.getin().next();
				c.setName(name);
				c.setAddress(address);
				session.persist(c);
				t.commit();
				System.out.println("Inserted Succcessfully");
				break;
			case 2 : 
				System.out.println("Enter id of customer to be updated : ");
				int id = Build.getin().nextInt();
				Customer dt = session.get(Customer.class, id);
				System.out.println("Enter new Name : ");
				String n_name = Build.getin().next();
				System.out.println("Enter new Address : ");
				String n_address = Build.getin().next();
				dt.setName(n_name);
				dt.setAddress(n_address);
				t.commit();
				System.out.println("Updated Successfully ");
				break;
			case 3 : 
				System.out.println("Enter id of customer to be Deleted : ");
				id = Build.getin().nextInt();
				Customer dt1 = session.get(Customer.class, id);
				session.remove(dt1);
				t.commit();
				System.out.println("Deleted Successfully");
				break;
			case 4  :
				Query cq = session.createQuery("From Customer");
				List<Customer> cl = cq.getResultList();
				System.out.println(cl);
				System.out.println("Done.");
				break;
			default:
				break;
			}
		}while(key<5);
		System.out.println("You are Done");
	}

}
