package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;
import pojos.Address;

public class AddAddressToEmp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AddressDao dao = new AddressDaoImpl();
			System.out.println("Enter empId");
			Long empId = sc.nextLong();
			System.out.println("Enter Address Details:\n adrLine1,adrLine2,city,state,country,zipCode");
			Address adr = new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
			System.out.println(dao.addNewAddress(adr, empId));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
