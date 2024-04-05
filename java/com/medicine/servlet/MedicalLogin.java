package com.medicine.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;


	@WebServlet("/medicalLogin")
	public class MedicalLogin extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
                System.out.println("inside medical");
                
				String email = req.getParameter("email");
				String password = req.getParameter("password");

				HttpSession session = req.getSession();

				if ("medical@gmail.com".equals(email) && "medical".equals(password)) {
					session.setAttribute("medicalObj", new User());
					resp.sendRedirect("medical_index.jsp");
				} else {
					session.setAttribute("errorMsg", "invalid email & password");
					resp.sendRedirect("medical_login.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

