package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dao.UserDao;
import com.entity.Doctor;
import com.entity.User;

/**
 * Servlet implementation class Users
 */
@WebServlet("/users")

public class Users extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		{
		
			HttpSession session = req.getSession();

			UserDao dao=new UserDao();
			List<User> user=dao.getAllUsers();
			
			System.out.println("users is  " + user);
			
			
			session.setAttribute("users", user);
			
			resp.sendRedirect("view_allPatients.jsp");
		}
		
		
	}
}