package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;

@WebServlet("/doctorStates")
public class DoctorStates extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		{
			System.out.println("aniket aniket aniket");
			DoctorDao dao1=new DoctorDao();
			HttpSession session=req.getSession();
			
				try {
					String id = req.getParameter("id");
					String state=req.getParameter("state");
				     System.out.println("idddd = " + id);
//					User u = new User();
//					u.setId(Integer.parseInt(id));
//					u.setStates(state);
					boolean f = dao1.updateStateDoctor(Integer.parseInt(id), state);
					
					if(f == true ) 
					{
						
						String msg = "inactive user";
						req.setAttribute("msg", msg);
						resp.sendRedirect("doctors?mode=viewDoctorAppointment");
						
					}
					else 
					{
						session.setAttribute("errorMsg", "wrong on server");
						resp.sendRedirect("view_doctor_appointment.jsp");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

