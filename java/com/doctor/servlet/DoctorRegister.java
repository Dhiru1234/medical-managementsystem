package com.doctor.servlet;

import java.io.IOException;

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

@WebServlet("/doctor_register")
public class DoctorRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String id=req.getParameter("id");
			String fullname = req.getParameter("fullname");
			String hospitalname=req.getParameter("hospitalName");
			String qualification=req.getParameter("qualification");
			String specialist = req.getParameter("specialist");
			String mobNo=req.getParameter("mobNo");
			String email = req.getParameter("email");
			String password=req.getParameter("password");
			
			
		   
			
			Doctor dr = new Doctor();
			
			dr.setFullName(fullname);
			dr.setHospitalName(hospitalname);
			dr.setQualification(qualification);
			dr.setSpecialist(specialist);
			dr.setMobNo(mobNo);
			dr.setEmail(email);
			dr.setPassword(password);
			dr.setStates("Active");
	
			DoctorDao dao = new DoctorDao();
			
			HttpSession session=req.getSession();
			
			

			if(id.isEmpty()) 
			{
				boolean f = dao.register(dr);

				if (f) {
					
					session.setAttribute("sucMsg", "Register successfully");
					resp.sendRedirect("doctor_signup.jsp");
					
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("doctor_signup.jsp");
				}
			}
			else 
			{
				dr.setId(Integer.parseInt(id));
				boolean g = dao.update(dr);

				if (g) {
					session.setAttribute("doctObj", dr);
					session.setAttribute("sucMsg", "Update successfully");
					resp.sendRedirect("doctor_signup.jsp");
					
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("doctor_signup.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}}