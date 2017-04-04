package com.niit.loginapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.html");
			
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			writer.append("Invalid Credentials. Please try again");
			//we have include login.html + this message
			//show error message

			
			dispatcher.include(request, response);
			// dispatcher.forward doesn't give writer.append message. Hence we need to use dispatcher.include
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
