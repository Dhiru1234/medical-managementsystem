package com.doctor.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dto.AppointmentInfoDTO;
import com.entity.Doctor;

/**
 * Servlet implementation class Doctors
 */
@WebServlet("/doctors")

public class Doctors extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		{

			HttpSession session = req.getSession();

			DoctorDao dao=new DoctorDao();
			List<Doctor> doctor=dao.getAllDoctors();
			
			
			
			session.setAttribute("doctor", doctor);
			
			resp.sendRedirect("view_allDoctors.jsp");
		}
	}
}