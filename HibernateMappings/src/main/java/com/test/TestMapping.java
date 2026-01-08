package com.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class TestMapping {

	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory sf=cfg.buildSessionFactory();
	Session session=sf.openSession();
	Transaction t=session.beginTransaction();
	Address adr=new Address();
	adr.setCity("Bangalore");
	adr.setState("KA");
	adr.setCountry("India");
	Address adr2=new Address();
	adr2.setCity("Mumbai");
	adr2.setState("MH");
	adr2.setCountry("INDIA");
	List<Address> adrs=Arrays.asList(adr,adr2);
	/*
	 * Employee emp=new Employee(); emp.setE_name("Arjun");
	 * emp.setE_company("Mphasis"); emp.setAddress(adr);
	 */
	Student std=new Student();
	std.setStd_name("Rohit");
	std.setAddresses(adrs);
	session.persist(std);
t.commit();
System.out.println("Done");
session.close();
	}

}
