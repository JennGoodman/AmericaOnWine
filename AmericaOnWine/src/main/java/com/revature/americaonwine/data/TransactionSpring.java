package com.revature.americaonwine.data;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class TransactionSpring implements TransactionDao, HibernateSession {
	
	private Session s;
	
	@Override
	public void setSession(Session session) 
	{
		this.s = session;
	}
	
	@Override
	public int nextOrderNum() {
		String sql = "SELECT MAX(order_number) FROM aow_transaction";
		Query q = s.createQuery(sql, Integer.class);
		List<Integer> l = q.getResultList();
		return l.get(0);
	}


}
