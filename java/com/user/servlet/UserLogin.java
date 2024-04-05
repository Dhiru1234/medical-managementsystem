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
import com.db.DbConnection;
import com.entity.Doctor;
import com.entity.User;


@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		UserDao dao = new UserDao();
		User user = dao.login(email, password);

		if (user != null) {
			session.setAttribute("user", user);
			session.setAttribute("isMale", user.getGender()=="Male");
			session.setAttribute("isFemale", user.getGender()=="Female");
			
			DoctorDao ddao = new DoctorDao();
			List<Doctor> list = ddao.getAllDoctor();
			
			session.setAttribute("doctorList", list);
			
			
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("user_login.jsp");
		}

	}

}