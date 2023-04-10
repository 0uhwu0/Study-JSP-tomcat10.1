package com.study;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.*;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. get request param
		String indexStr = request.getParameter("index");
		String name = request.getParameter("name");
		int index = Integer.parseInt(indexStr);
		
		// 2. business logic
		HttpSession session = request.getSession();
		List<String> db = (List<String>) session.getAttribute("db");
		db.set(index, name);
		
		// 3. add attribute
		
		// 4. forward / redirect
		String location = request.getContextPath() + "/list";
		response.sendRedirect(location);
	}

}
