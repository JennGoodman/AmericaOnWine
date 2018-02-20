package com.revature.americaonwine.data;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.americaonwine.beans.Transaction;
import com.revature.americaonwine.beans.User;

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

	@Override
	public Transaction addTransaction(Transaction tran) {
		int i = (int) s.save(tran);
		if(i>0) {
			return tran;
		}else {
			return null;
		}
		
	}
	
	@Override
	public List<Transaction> getForUser(User u) {
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Transaction> query = builder.createQuery(Transaction.class);
		Root<Transaction> root = query.from(Transaction.class);
		query.select(root).where(builder.equal(root.get("userId"), u.getId()));
		Query q = s.createQuery(query);
		List<Transaction> qlist = q.getResultList();
		return qlist;
	}

	@Override
	public Transaction updateTransaction(Transaction t) {
		s.update(t);
		return t;
	}


}
