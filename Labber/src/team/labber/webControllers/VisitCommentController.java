/**  
 * @Title VisitCommentController.java
 * @Package team.labber.webControllers
 * @author TODO
 * 2017��3��7��
 * File Name: VisitCommentController.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.webControllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.labber.beans.VisitorsOperationImpl;
import team.labber.entities.Visitors;
import team.labber.interfaces.VisitorsOperation;

/**
 * @ClassName VisitCommentController
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017��3��7�� ����9:18:47, TODO,
 */

public class VisitCommentController extends HttpServlet {
	private VisitorsOperation visit = new VisitorsOperationImpl();

	/**
	 * Constructor of the object.
	 */
	public VisitCommentController() {
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
		String comments = request.getParameter("vComment");
		int score = Integer.valueOf(request.getParameter("vScore"));
		Visitors todayVisitor = (Visitors) session.getAttribute("todayVisitor");
		visit.addComments(todayVisitor, comments, score);
		session.removeAttribute("todayVisitor");
		session.removeAttribute("vName");
		session.removeAttribute("vDocID");
		session.setAttribute("banner",
				todayVisitor.getPersons().getPName() + ", Thank You!");
		response.sendRedirect("Visitors/");

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
		return "This is my default servlet created by Eclipse";
	}

}
