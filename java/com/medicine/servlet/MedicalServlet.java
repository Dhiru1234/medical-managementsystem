package com.medicine.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MedicalDao;
import com.dao.MedicineDao;
import com.dto.AppointmentInfoDTO;
import com.entity.Medical;
import com.entity.Medicine;

@WebServlet("/medical")
public class MedicalServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String mode = req.getParameter("mode");
		
		System.out.println("Inside servlet code");
		// String diseasename=req.getParameter("diseasename[]");
		if (mode.equals("addMedicine")) {

			String[] diseasename = req.getParameterValues("diseasesname[]");
			String[] symptomname = req.getParameterValues("symptomname[]");

			String[] medicinename = req.getParameterValues("medicinename[]");

			String[] quantity = req.getParameterValues("quantity[]");

			String[] costMedicine = req.getParameterValues("cost[]");

			String[] available = req.getParameterValues("available[]");

			List<Medical> list = new ArrayList<Medical>();
			
			for (int i = 0; i < diseasename.length; i++) {
				Medical m = new Medical();
				m.setDiseasename(diseasename[i]);
				m.setSymptomname(symptomname[i]);
				m.setMedicineName(medicinename[i]);
				m.setQuantity(Integer.parseInt(quantity[i]));

				m.setCostMedicine(Integer.parseInt(costMedicine[i]));

				m.setAvailable(available[i]);

				list.add(m);
			}
			MedicalDao medicalDao = new MedicalDao();

			for (Medical medical : list) {
				medicalDao.InsertMedicalMedicine(medical);

			}
		}
		
		MedicalDao dao=new MedicalDao();
		if (mode.equals("viewAddedMedicine")) {
			int id = Integer.parseInt(req.getParameter("id"));

			Medical medical = dao.getMedicinesInfoById(id);

			session.setAttribute("medicineDetails", medical);
			resp.sendRedirect("view_patient.jsp");
		}
	}
	
}
