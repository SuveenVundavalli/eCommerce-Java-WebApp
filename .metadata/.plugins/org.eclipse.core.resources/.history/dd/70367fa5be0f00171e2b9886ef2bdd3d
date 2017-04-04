package com.niit.loginapp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.niit.loginapp.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID = request.getParameter("userID"); //Name of the userID field in login.html
		String password = request.getParameter("password"); //Name of the password field in login.html
		
		//send it to corresponding DAO
		
		//Create instance of loginDAO
		LoginDAO loginDAO = new LoginDAO();
		
		//get the request dispatcher so that we dispatch either to home page or login page
		if(loginDAO.isValidCredentials(userID, password))
		{
			//Navigate/dispatch to home page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.html");
			dispatcher.forward(request, response); //supposed use include
		}
		else
		{
			//Navigate/dispatch to login page
			//show error message
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.html");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
