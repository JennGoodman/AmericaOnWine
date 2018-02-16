package com.revature.americaonwine.data;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.util.HibernateUtil;

@Component
public class TransactionSpring implements TransactionDao {
	
	private HibernateUtil hu = HibernateUtil.getInstance();
	private Logger log = Logger.getLogger(TransactionSpring.class);

	@Override
	public int nextOrderNum() {
		Session s = hu.getSession();
		String sql = "SELECT MAX(order_number) FROM aow_transaction";
		Query q = s.createQuery(sql, Integer.class);
		List<Integer> l = q.getResultList();
		return l.get(0);
	}

}
