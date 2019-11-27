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
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet(urlPatterns = { "/productInfo"})
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   System.out.println("Welcome to view product list Servlet");
	       // (Users can not access directly into JSP pages placed in WEB-INF)
		   HttpSession session = request.getSession();
	       // Check User has logged on
	       UserAccount loginedUser = MyUtils.getLoginedUser(session);
	       
	       Connection conn = MyUtils.getStoredConnection(request);
			ArrayList<AddProductBO> pdt=new ArrayList<AddProductBO>();
			pdt=DBUtils.getProductList(conn);
			request.setAttribute("product", pdt);
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productInfoView.jsp");
	       dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
