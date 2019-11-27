package com.face.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.face.bo.AddProductBO;
import com.face.bo.UserAccount;
import com.face.dao.DBUtils;
import com.face.dao.MyUtils;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet(urlPatterns = { "/deleteProduct"})
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   System.out.println("Welcome to delete product Servlet");
	       // (Users can not access directly into JSP pages placed in WEB-INF)
		   //HttpSession session = request.getSession();
	       // Check User has logged on
	       //UserAccount loginedUser = MyUtils.getLoginedUser(session);
		   RequestDispatcher dispatcher //
           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/deleteProduct.jsp");
		   dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int id=Integer.parseInt(request.getParameter("delId"));
	       System.out.println(id);
	       Connection conn = MyUtils.getStoredConnection(request);
			ArrayList<AddProductBO> pdt=new ArrayList<AddProductBO>();
			pdt=DBUtils.getProductList(conn);
			request.setAttribute("product", pdt);
			boolean prdt;
			prdt=DBUtils.deleteProduct(conn, id);
			//request.setAttribute("product", pdt);
	       //RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/editView.jsp");
	       //dispatcher.forward(request, response);
		//doGet(request, response);
	}
}
