/**  
 * @Title InformationCompletion.java
 * @Package team.labber.webControllers
 * @author TODO
 * 2017��3��5��
 * File Name: InformationCompletion.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.webControllers;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.labber.beans.StudentsOperationImpl;
import team.labber.beans.VisitorsOperationImpl;
import team.labber.interfaces.StudentOperation;
import team.labber.interfaces.VisitorsOperation;

/**
 * @ClassName InformationCompletion
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017��3��5�� ����6:48:41, TODO,
 */

public class InformationCompletionController extends HttpServlet {
	private VisitorsOperation visit = new VisitorsOperationImpl();

	/**
	 * Constructor of the object.
	 */
	public InformationCompletionController() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = this.getServletContext();
		Stack<String> hisStack = (Stack<String>) session
				.getAttribute("hisStack");
		String currentRole = (String) session.getAttribute("currentRole");
		String vDocID = request.getParameter("vDocID");
		String vName = request.getParameter("vName");
		String vGender = request.getParameter("vGender");
		String vCID = request.getParameter("vCID");
		String vMajor = request.getParameter("vMajor");
		StudentOperation studentOperation = new StudentsOperationImpl();
		studentOperation.saveStudent(vName, vMajor, vCID, vDocID, vGender,
				currentRole);
		session.setAttribute("banner",
				"Welcome " + vName + ", please make your self at home!");
		visit.doVisit(visit.getPersonsByVisitDocID(vDocID).get(0));
		if (application.getAttribute("visitCounter") != null) {
			int visitCounter = (int) application.getAttribute("visitCounter")
					+ 1;
			application.setAttribute("visitCounter", visitCounter);
		} else {
			application.setAttribute("visitCounter", 1);
		}
		response.sendRedirect(hisStack.pop());

	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * Returns information about the servlet, such as author, version, and
	 * copyright.
	 *
	 * @return String information about this servlet
	 */
	@Override
	public String getServletInfo() {
		return "This is InformationCompletion Servlet";
	}

}
