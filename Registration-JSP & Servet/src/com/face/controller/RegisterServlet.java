package com.face.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.face.bo.RegisterBO;
import com.face.dao.RegisterDAO;
import com.face.util.ConnectionManager;

/**@author Rosna Simon
 * @implNote perform user registration
 * Date - 14-11-2019
 * @category controller class
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @implSpec -> action method to register customer with database
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("Welcome");
		response.setContentType("text/html");
		String fname=request.getParameter("fname");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String cpwd=request.getParameter("cpwd");
		String email=request.getParameter("email");
		
		RegisterBO regbo=new RegisterBO();
		regbo.setFname(fname);
		regbo.setUname(uname);
		regbo.setPwd(pwd);
		regbo.setCpwd(cpwd);
		regbo.setEmail(email);
		boolean status=false;
		ConnectionManager con=new ConnectionManager();
			try {
				status=RegisterDAO.save(con.getConnection(),regbo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(status==true)
				response.sendRedirect("signin.jsp");
	}

}
