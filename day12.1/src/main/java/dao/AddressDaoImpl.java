package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Employee;

import static utils.HibernateUtils.getFactory;

public class AddressDaoImpl implements AddressDao {

	@Override
	public Address addNewAddress(Address address, Long empId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				address.setEmp(emp);
				session.persist(address);
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
		return address;
	}

}
