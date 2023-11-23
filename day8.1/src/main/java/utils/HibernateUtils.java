package utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
//create singelton,immutable, inhernetly thread safe, time comsuming SF

public class HibernateUtils {
	public static SessionFactory factory;
	static {
		System.out.println("in static init block");
		factory = new Configuration().configure().buildSessionFactory();

	}

	public static SessionFactory getFactory() {
		return factory;
	}

}
