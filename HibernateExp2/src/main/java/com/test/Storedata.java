package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class Storedata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sf=cfg.buildSessionFactory();
Session session=sf.openSession();
Transaction t=session.beginTransaction();
Player p1=new Player();
p1.setName("Rohit");
Cricketer c1=new Cricketer();
c1.setJerseyNumber("45");
c1.setName("Rohit");
c1.setType("AllRounder");

TennisPlayer t1=new TennisPlayer();
t1.setName("Ayush");
t1.setWonMatches(90);
t1.setNoOfMatches(100);

session.persist(p1);
session.persist(c1);
session.persist(t1);
t.commit();
System.out.println("Done");
session.close();
	}

}
