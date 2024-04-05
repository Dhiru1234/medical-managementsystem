package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.DbConnection;
import com.dto.AppointmentInfoDTO;
import com.entity.Doctor;
import com.entity.Medical;
import com.entity.User;

public class MedicalDao {
	
	private Connection conn;
	
	public MedicalDao() 
	{
		conn=DbConnection.getCon();
	}

	public boolean InsertMedicalMedicine(Medical medical) {
		boolean f=false;
		
		try 
		{
			String sql="insert into medical(diseasename,symptomname,medicinename,quantity,cost,available) values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, medical.getDiseasename());
			ps.setString(2, medical.getSymptomname());
			ps.setString(3, medical.getMedicineName());
			ps.setInt(4, medical.getQuantity());
			ps.setInt(5, medical.getCostMedicine());
			ps.setString(6, medical.getAvailable());
			
			int i=ps.executeUpdate();
			if(i==1) 
			{
				f = true;
			}
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return f;
	
	}

	public Medical getMedicinesInfoById(int id) {
		{
			Medical me;
			 me = null;
			try {
				String sql = "select * from medical where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					me = new Medical();
					me.setId(id);
					me.setDiseasename(rs.getString("diseasename"));
					me.setSymptomname(rs.getString("symptomname"));
					me.setMedicineName(rs.getString("medicinename"));
					me.setQuantity(rs.getInt("quantity"));
					me.setCostMedicine(rs.getInt("cost"));
					me.setAvailable(rs.getString("available"));
					
		
			System.out.println("ap is = " + me);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return me;
			
		}
		
	}
	
	

}
