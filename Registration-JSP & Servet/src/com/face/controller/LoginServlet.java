package com.face.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.face.bo.LoginBO;
import com.face.bo.RegisterBO;
import com.face.dao.LoginDAO;
import com.face.util.ConnectionManager;

/**@author Rosna Simon
 * @implNote perform user login
 * Date - 14-11-2019
 * @category controller class
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @implSpec -> action method to login customer with database
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("userpwd");
		
		LoginBO lbo=new LoginBO();
		RegisterBO rbo=new RegisterBO();

		lbo.setUsername(username);
		lbo.setPassword(password);
		boolean status=false;
		ConnectionManager con=new ConnectionManager();
		try {
			status=LoginDAO.check(con.getConnection(), lbo,rbo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(status==true)
		{
			ArrayList data=new ArrayList();
			data.add(rbo.getFname());
			data.add(rbo.getEmail());
			
			request.setAttribute("values", data);
			RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
			if(req!=null)
				req.forward(request, response);		
		}
		else
		{
			response.sendRedirect("signin.jsp");
			System.out.println("Failed login");
		}
	}
}
