package com.appointment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.dao.DoctorDao;
import com.db.DbConnection;
import com.dto.AppointmentInfoDTO;
import com.entity.Appointment;
import com.entity.Doctor;
import com.entity.User;
import com.mysql.cj.Session;

@WebServlet("/appointments")
public class AppointmentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mode = req.getParameter("mode");

		HttpSession session = req.getSession();

		AppointmentDAO dao = new AppointmentDAO();

		if (mode.equals("addAppointment")) {

			User user = (User) session.getAttribute("user");
			int uid = user.getId();

			String did = req.getParameter("doctor_id");
			String appoint_date = req.getParameter("appoint_date");
			String diseases = req.getParameter("diseases");

			Appointment ap = new Appointment();

			ap.setAppoinDate(appoint_date);
			ap.setDiseases(diseases);
			ap.setDoctorId(Integer.parseInt(did));
			ap.setUserId(uid);

			ap.setStatus("Pending");

			if (dao.addAppointment(ap)) {
				session.setAttribute("succMsg", "Appointment Sucessfully");
				resp.sendRedirect("appointments?mode=viewAppointments");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("user_appointment.jsp");
			}
		}

		if (mode.equals("viewAppointments")) {

			User user = (User) session.getAttribute("user");
			int uid = user.getId();

			List<AppointmentInfoDTO> appointments = dao.getAllAppointmentByLoginUser(uid);

			session.setAttribute("appointments", appointments);

			resp.sendRedirect("view_appointments.jsp");
		}

		if (mode.equals("viewDoctorAppointment")) {

			HttpSession session1 = req.getSession();
			Doctor doctor = (Doctor) session1.getAttribute("doctObj");
			int dd = doctor.getId();

			List<AppointmentInfoDTO> appointments = dao.getAllAppointmentByLoginDoctor(dd);

			System.out.println(appointments);

			session1.setAttribute("appointments", appointments);

			resp.sendRedirect("view_doctor_appointment.jsp");
		}

		if (mode.equals("viewAppointmentDetails")) {
			int id = Integer.parseInt(req.getParameter("id"));

			AppointmentInfoDTO appointmentInfoDTO = dao.getAppointmentInfoById(id);

			session.setAttribute("appoinmentDetails", appointmentInfoDTO);
			resp.sendRedirect("view_patient.jsp");
		}
		AppointmentDAO dao1 = new AppointmentDAO();

		if (mode.equals("updateStatus")) {
			try {
				String id = req.getParameter("id");
			
				Appointment ap = new Appointment();
				ap.setId(Integer.parseInt(id));
				boolean f = dao1.updateCommentStatus(ap.getId());
				
				if(f == true ) 
				{
					String msg = "Checking Completed";
					req.setAttribute("msg", msg);
					resp.sendRedirect("appointments?mode=viewDoctorAppointment");	
				}
				else 
				{
					session.setAttribute("errorMsg", "wrong on server");
					resp.sendRedirect("view_patient.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}