package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entity.Medicine;
import com.entity.User;

public class MedicineDao {
	private Connection conn;

	public MedicineDao() {
		conn = DbConnection.getCon();
		}
	public boolean Insertmedicine(Medicine medicine1) {
		boolean f = false;
		try {
			String sql = "insert into medicine(diseases_name,symptoms,medicine_name,quantity,schedule_medicine) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, medicine1.getDiseasename());
			ps.setString(2, medicine1.getSymtomname());
			ps.setString(3, medicine1.getMedicineName());
			ps.setInt(4, medicine1.getQuantity());
			ps.setString(5, medicine1.getSchedule());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
