package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

/**
 * Servlet implementation class ProcessAdmissionForm
 */
@WebServlet("/admission")
public class ProcessAdmissionForm extends HttpServlet {
	StudentDaoImpl studentDao;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void init() throws ServletException {
		try {
			studentDao = new StudentDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. get PW
		try (PrintWriter pw = response.getWriter()) {
			// 3. read req params
			String fName = request.getParameter("fn");
			String lName = request.getParameter("ln");
			int marks = Integer.parseInt(request.getParameter("score"));
			String selectedCourse = request.getParameter("course");
			Course course = Course.valueOf(selectedCourse.toUpperCase());
			// 4. wrap all student dtls in the student obj
			Student newStudent = new Student(fName, lName, marks, course);
			// 5. process admission
			if (marks >= course.getMinMarks())
				studentDao.studentRegister(fName, lName, marks, selectedCourse);
			newStudent.setAdmissionStatus(true);
			studentDao.updateStatus(fName);
			// 6. save student details under suitable scope =request
			request.setAttribute("student_dtls", newStudent);// req scoped attr
			pw.print("<h3> from 1st page....</h3>");
			// pw.flush();//rendering /sending / committing the resp
			// 7. create RD object
			RequestDispatcher rd = request.getRequestDispatcher("result");
			// 8. include the dyn contents of Results page in the SAME request
			rd.include(request, response);

			System.out.println("control came back.....");
			pw.print("<h5> 1st page generating contents again....</h5>");
		} catch (Exception e) {
			throw new ServletException("err in doPost", e);
		}
	}

	public void destroy() {
		System.out.println(getClass() + " destroyed");
		try {
			studentDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy", e);
		}
	}
}
