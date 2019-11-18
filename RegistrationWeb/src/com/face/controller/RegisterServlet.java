package com.face.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.face.bo.RegisterBO;
import com.face.dao.RegisterDAO;
import com.face.util.ConnectionManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	ConnectionManager con=new ConnectionManager();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String fname=request.getParameter("fname");
		String uname=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		System.out.println(pwd);
		String cpwd=request.getParameter("cpwd");
		String mail=request.getParameter("email");
		String mob=request.getParameter("mob");
		RegisterBO reg=new RegisterBO();
		reg.setFname(fname);
		reg.setUname(uname);
		reg.setPwd(pwd);
		reg.setCpwd(cpwd);
		reg.setMail(mail);
		reg.setMob(mob);
		try {
			RegisterDAO.Save(con.connection(),reg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
