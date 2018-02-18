package com.revature.americaonwine.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {
	
	private SessionFactory sessionFactory;
	
	public HibernateUtil()
	{
		super();
	}
	
	public SessionFactory getSessionFactory() 
	{
		if(sessionFactory==null) 
		{
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure().build();
            Metadata meta = new MetadataSources(standardRegistry)
                    .getMetadataBuilder()
                    .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                    .build();
            sessionFactory = meta.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
	
	public Session getSession() 
	{
		return this.getSessionFactory().openSession();
	}
}
