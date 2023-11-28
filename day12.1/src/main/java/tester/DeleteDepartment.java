package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;
import pojos.EmploymentType;

public class DeleteDepartment {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDao dao = new DepartmentDaoImpl();
			System.out.println("Enter Department name:");
			System.out.println(dao.deleteDepartment((sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
