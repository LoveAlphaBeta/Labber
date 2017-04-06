/**  
 * @Title Visit.java
 * @Package sevice
 * @author TODO
 * 2017年3月5日
 * File Name: Visit.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.webControllers;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.labber.beans.VisitorsOperationImpl;
import team.labber.dao.DepartmentsDAO;
import team.labber.dao.MajorsDAO;
import team.labber.entities.Departments;
import team.labber.entities.Majors;
import team.labber.entities.Persons;
import team.labber.entities.Visitors;
import team.labber.interfaces.VisitorsOperation;

/**
 * @ClassName Visit
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017年3月5日 下午2:26:04, TODO,
 */

public class VisitController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public VisitController() {
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
		response.sendRedirect("Visitors/");
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
		String docID = request.getParameter("docID");
		HttpSession session = request.getSession();
		ServletContext application = this.getServletContext();
		VisitorsOperation visit = new VisitorsOperationImpl();
		List<Persons> possibleVisitedPersons = visit
				.getPersonsByVisitDocID(docID);
		if (possibleVisitedPersons.size() == 0) {
			Stack<String> historyStack = new Stack<String>();
			historyStack.push("Visitors/");
			List<Departments> departments = new DepartmentsDAO().findAll();
			List<Majors> majors = new MajorsDAO().findAll();
			session.setAttribute("majorsList", majors);
			session.setAttribute("DocID", docID);
			session.setAttribute("hisStack", historyStack);
			session.removeAttribute("vName");
			session.setAttribute("currentRole", "Visitor");
			response.sendRedirect("./Visitors/InformationCompletion.jsp");
		} else {
			Visitors visitor = visit
					.hasVisitedInOneDay(possibleVisitedPersons.get(0));
			if (visitor != null) {
				session.setAttribute("vDocID", docID);
				session.setAttribute("vName",
						possibleVisitedPersons.get(0).getPName());
				session.setAttribute("vScore", visitor.getScore());
				session.setAttribute("vComment", visitor.getComments());
				session.setAttribute("todayVisitor", visitor);
				response.sendRedirect("./Visitors/Comments.jsp");
			} else {
				session.setAttribute("banner",
						"Welcome " + possibleVisitedPersons.get(0).getPName()
								+ ", please make your self at home!");
				visit.doVisit(possibleVisitedPersons.get(0));
				if (application.getAttribute("visitCounter") != null) {
					int visitCounter = (int) application
							.getAttribute("visitCounter") + 1;
					application.setAttribute("visitCounter", visitCounter);
				} else {
					application.setAttribute("visitCounter", 1);
				}
				response.sendRedirect("Visitors/");
			}
		}
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
		return "This is Visit Controller";
	}

}
