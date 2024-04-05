package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entity.Doctor;

public class DoctorDao {
	private Connection conn;

	public DoctorDao() {
		conn = DbConnection.getCon();
	}


	public boolean register(Doctor dr) {
		boolean f = false;

		try {
			String sql = "insert into doctor(full_name,hospital_name,qualification,specialist,email,mobno,password,state) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dr.getFullName());
			ps.setString(2, dr.getHospitalName());
			ps.setString(3, dr.getQualification());
			ps.setString(4, dr.getSpecialist());
			ps.setString(5, dr.getEmail());
			ps.setString(6, dr.getMobNo());
			ps.setString(7, dr.getPassword());
			ps.setString(8, dr.getStates());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}


	public boolean update(Doctor d) {
		boolean f = false;

		try {
			String sql = "update doctor set full_name=?,hospital_name=?,qualification=?,specialist=?,email=?,mobno=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getHospitalName());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}


	public Doctor login(String email, String psw) {
		Doctor d = null;
		try {

			String sql = "select * from doctor where email=? and password=? and state=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);
			ps.setString(3, "Active");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setHospitalName(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				d.setStates(rs.getString(9));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}

	public int countDoctor() {
		int i = 0;
		try {
			String sql = "select * from doctor";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointment() {
		int i = 0;
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

//	public int countAppointmentByDocotrId(int did) {
//		int i = 0;
//		try {
//			String sql = "select * from appointment where doctor_id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, did);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				i++;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return i;
//	}

	public int countUSer() {
		int i = 0;
		try {
			String sql = "select * from user_tbls";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	

//	public boolean changePassword(int userid, String newPassword) {
//		boolean f = false;
//
//		try {
//			String sql = "update doctor set password=? where id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, newPassword);
//			ps.setInt(2, userid);
//
//			int i = ps.executeUpdate();
//			if (i == 1) {
//				f = true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}

//	public boolean editDoctorProfile(Doctor d) {
//		boolean f = false;
//
//		try {
//			String sql = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=? where id=?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, d.getFullName());
//			ps.setString(2, d.getHospitalName());
//			ps.setString(3, d.getQualification());
//			ps.setString(4, d.getSpecialist());
//			ps.setString(5, d.getEmail());
//			ps.setString(6, d.getMobNo());
//			ps.setInt(7, d.getId());
//			int i = ps.executeUpdate();
//
//			if (i == 1) {
//				f = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return f;
//	}
	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {

			String sql = "select * from doctor order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				d = new Doctor();
				
				d.setId(rs.getInt("id"));
				d.setFullName(rs.getString("full_name"));
				d.setHospitalName(rs.getString("hospital_name"));
				d.setQualification(rs.getString("qualification"));
				d.setSpecialist(rs.getString("specialist"));
				d.setEmail(rs.getString("email"));
				d.setMobNo(rs.getString("mobNO"));
				d.setStates(rs.getString("state"));
				
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Doctor getDoctorById(int id) {

		Doctor d = null;
		try {

			String sql = "select * from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt("id"));
				d.setFullName(rs.getString("full_name"));
				d.setHospitalName(rs.getString("hospital_name"));
				d.setQualification(rs.getString("qualification"));
				d.setSpecialist(rs.getString("specialist"));
				d.setEmail(rs.getString("email"));
				d.setMobNo(rs.getString("mobNO"));
				d.setStates(rs.getString("state"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}


	public List<Doctor> getAllDoctors() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {

			String sql = "select * from doctor ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt("id"));
				d.setFullName(rs.getString("full_name"));
				d.setHospitalName(rs.getString("hospital_name"));
				d.setQualification(rs.getString("qualification"));
				d.setSpecialist(rs.getString("specialist"));
				d.setEmail(rs.getString("email"));
				d.setMobNo(rs.getString("mobNO"));
				d.setStates(rs.getString("state"));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public boolean updateStateDoctor(int id,String state) 
	{
		boolean f=false;
		try 
		{
			String sql="update doctor set state=? where id=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(2,id);
			ps.setString(1, state);
			
			int i=ps.executeUpdate();
			if(i==1) 
			{
				f=true;
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return f;	
	}
}