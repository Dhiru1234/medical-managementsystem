 package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DbConnection;
import com.entity.User;



@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id=req.getParameter("uid");
			String fullname = req.getParameter("fullname");
			String age=req.getParameter("age");
			String gender=req.getParameter("gender");
			String address=req.getParameter("address");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			
			User u = new User();
			u.setFullname(fullname);
			u.setAge(age);
			u.setGender(gender);
			u.setAddress(address);
			u.setEmail(email);
			u.setPassword(password);
			u.setStates("Active");
			
			UserDao d = new UserDao();
			
			HttpSession session=req.getSession();
			if(id.isEmpty()) 
			{
				boolean f = d.register(u);

				if (f) {
					
					session.setAttribute("sucMsg", "Register successfully");
					resp.sendRedirect("user_signup.jsp");
					
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("user_signup.jsp");
				}
			}
			else 
			{
				u.setId(Integer.parseInt(id));
				boolean f = d.update(u);

				if (f) {
					session.setAttribute("user", u);
					session.setAttribute("isMale", u.getGender()=="Male");
					session.setAttribute("isFemale", u.getGender()=="Female");
					session.setAttribute("sucMsg", "Update successfully");
					resp.sendRedirect("user_signup.jsp");
					
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("user_signup.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
