package com.face.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.face.bo.AddProductBO;
import com.face.dao.DBUtils;
import com.face.dao.MyUtils;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet (urlPatterns = { "/addProduct"})
//@WebServlet("/AddProductServlet")

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   System.out.println("Welcome to Login Servlet");
	       // Forward to /WEB-INF/views/loginView.jsp
	       // (Users can not access directly into JSP pages placed in WEB-INF)
	       RequestDispatcher dispatcher //
	               = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProductView.jsp");
	       dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html");
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		int price=Integer.parseInt(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		   AddProductBO add = null;
	       boolean hasError = false;
	       String errorString = null;
	       if (pname == null || price == 0 || quantity == 0 ) {
	           hasError = true;
	           errorString = "Required all the fields!";
	       } else {
	           Connection conn = MyUtils.getStoredConnection(request);
	           try {
	               // Find the user in the DB.
	               add = DBUtils.addProduct(conn, pid,pname, price, quantity);
	               /*if (add == null) {
	                   hasError = true;
	                   errorString = "User Name or password invalid";
	               }*/
	           } catch (SQLException e) {
	               e.printStackTrace();
	               hasError = true;
	               errorString = e.getMessage();
	           }
	       }
	       // If error, forward to /WEB-INF/views/login.jsp
	       if (hasError) {
	           add = new AddProductBO();
	           add.setPname(pname);
	           add.setPrice(price);
	           add.setQuantity(quantity);
	           // Store information in request attribute, before forward.
	           request.setAttribute("errorString", errorString);
	           request.setAttribute("add", add);
	           // Forward to /WEB-INF/views/login.jsp
	           RequestDispatcher dispatcher //
	                   = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProductView.jsp");
	           dispatcher.forward(request, response);
	       }
	       // If no error
	       // Store user information in Session
	       // And redirect to userInfo page.
	       else {
	           /*HttpSession session = request.getSession();
	           MyUtils.storeLoginedUser(session, add);
	           // If user checked "Remember me".
	           if (remember) {
	               MyUtils.storeUserCookie(response, user);
	           }
	           // Else delete cookie.
	           else {
	               //MyUtils.deleteUserCookie(response);
	           }*/
	           // Redirect to userInfo page.
	           response.sendRedirect(request.getContextPath() + "/productList");
	       }

	}
}
