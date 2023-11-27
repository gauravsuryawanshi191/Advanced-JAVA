package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

//Create singleton , immutable, inherently thrd safe ,time consuming SF
public class HibernateUtils {
	//one instance per DB
	private static SessionFactory factory;
	static {
		System.out.println("in static init block");
		factory = new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	
}
