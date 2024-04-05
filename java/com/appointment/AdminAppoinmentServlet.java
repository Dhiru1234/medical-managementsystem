package com.appointment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.dto.AppointmentInfoDTO;
import com.entity.Appointment;

@WebServlet("/appointment")

public class AdminAppoinmentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		{

			HttpSession session = req.getSession();

			AppointmentDAO dao=new AppointmentDAO ();
			List<AppointmentInfoDTO> allAppointment;
			try {
				allAppointment = dao.getAllAppointment();
				
				System.out.println(" all appointment = " + allAppointment);
				
				session.setAttribute("appointment", allAppointment);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
			
			resp.sendRedirect("view_allAppointment.jsp");
		}
	}
}