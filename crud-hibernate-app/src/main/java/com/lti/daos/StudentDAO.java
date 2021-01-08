package com.lti.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lti.config.HibernateUtility;
import com.lti.entities.Student;

public class StudentDAO {

	public void saveStudent(Student s) {

		Transaction tx = null;
		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			if(tx != null) {
				tx.rollback();
			}
		}
	}
	
	public Student getStudent(int id) {
		Transaction tx = null;
		Student s = null;
		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			tx = session.beginTransaction();
			s=session.get(Student.class, id);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			if(tx != null) {
				tx.rollback();
			}
		}
		return s;	
	}
	
	public List<Student> getAllStudent(){
		Transaction tx = null;
		List<Student> s1=new ArrayList<Student>();
		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			tx = session.beginTransaction();
			s1=session.createQuery("from Student").getResultList();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			if(tx != null) {
				tx.rollback();
			}
		}
		return s1;
		
	}

}
