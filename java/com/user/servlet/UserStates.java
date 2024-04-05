package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.dao.UserDao;
import com.entity.Appointment;
import com.entity.User;
import com.mysql.cj.Session;
	
	@WebServlet("/userStates")

	public class UserStates extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			doPost(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			{
				UserDao dao1=new UserDao();
				HttpSession session=req.getSession();
				
					try {
						String id = req.getParameter("id");
						String state=req.getParameter("state");
					     System.out.println("idddd = " + id);
//						User u = new User();
//						u.setId(Integer.parseInt(id));
//						u.setStates(state);
						boolean f = dao1.updateState(Integer.parseInt(id), state);
						
						if(f == true ) 
						{
							
							String msg = "inactive user";
							req.setAttribute("msg", msg);
							resp.sendRedirect("users?mode=viewAppointments");
							
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

