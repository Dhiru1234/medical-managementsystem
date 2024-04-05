
package com.medicine.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MedicineDao;
import com.dao.UserDao;
import com.entity.Medicine;
import com.entity.User;

@WebServlet("/medicine")
public class MedicineServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {		
			System.out.println("Inside servlet code");
		//	String diseasename=req.getParameter("diseasename[]");
			
			String [] diseasename = req.getParameterValues("diseasesname[]");
			
			String [] symptomname = req.getParameterValues("symptomname[]");
		
			String [] medicinename = req.getParameterValues("medicinename[]");
			
			String [] quantity = req.getParameterValues("quantity[]");
			
			String [] schedule = req.getParameterValues("schedule[]");
			
			List<Medicine> list=new ArrayList<Medicine>();	
			for(int i=0;i<diseasename.length;i++) 
			{
				Medicine m=new Medicine();
				m.setDiseasename(diseasename[i]);
				m.setSymtomname(symptomname[i]);
				m.setMedicineName(medicinename[i]);
				m.setQuantity(Integer.parseInt(quantity[i]));
			    m.setSchedule(schedule[i]);
			    
			    list.add(m);
			}		
			MedicineDao medicineDao = new MedicineDao();
			
			for (Medicine medicine : list) {
				medicineDao.Insertmedicine(medicine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
