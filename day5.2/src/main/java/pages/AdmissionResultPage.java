package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDaoImpl;
import pojos.Student;

/**
 * Servlet implementation class AdmissionResultPage
 */
@WebServlet("/result")
public class AdmissionResultPage extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set content type
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h3> from 2nd page...." + request.getParameter("fn") + "</h3>");
		// get student details from req scoped attribute(server side object)
		Student s1 = (Student) request.getAttribute("student_dtls");
		if (s1 != null) {
			pw.print("<h4> Hello " + s1.getFirstName() + " " + s1.getLastName() + "</h4>");
			if (s1.isAdmissionStatus())
				pw.print("<h5> Congratulations ! , You are admitted in " + s1.getSelectedCourse() + "</h5>");
			else
				pw.print("<h5> Sorry  ! , Can't be  admitted in " + s1.getSelectedCourse() + "</h5>");
		}

	}

}
