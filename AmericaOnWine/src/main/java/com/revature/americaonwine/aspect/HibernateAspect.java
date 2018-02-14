/*package com.revature.americaonwine.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.americaonwine.util.HibernateUtil;

public class HibernateAspect {

	@Autowired
	private HibernateUtil hu;
	
	@Around("allDaoObjections()")
	public Object manageSession(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		// HibernateSession hs = (HibernateSession) pjp.getThis();
		//hs.setSession(session);
		try {
			obj = pjp.proceed();
		}
		catch (Throwable e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		
		tx.commit();
		session.close();
		//hs.setSession(null);
		return obj;
	}
}
*/