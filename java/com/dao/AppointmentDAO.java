package com.dao;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.dto.AppointmentInfoDTO;
import com.entity.Appointment;
import com.entity.Doctor;
import com.entity.User;

public class AppointmentDAO {

	private Connection conn;

	public AppointmentDAO() {
		conn = DbConnection.getCon();
		}

  
	public boolean addAppointment(Appointment ap) {
		boolean f = false;

		try {

			String sql = "insert into appointment(id,user_id,doctor_id,appoinDate,diseases,status) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ap.getId());
			ps.setInt(2, ap.getUserId());
			ps.setInt(3, ap.getDoctorId());
			ps.setString(4, ap.getAppoinDate());
			ps.setString(5, ap.getDiseases());
			ps.setString(6, ap.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public List<AppointmentInfoDTO> getAllAppointmentByLoginUser(int UserId) {
		List<AppointmentInfoDTO> list = new ArrayList<AppointmentInfoDTO>();

		UserDao udo = new UserDao();
		DoctorDao ddo = new DoctorDao();
		AppointmentDAO dd = new AppointmentDAO();
		User user = udo.getUserById(UserId);

		AppointmentInfoDTO ap = null;
		try {
			String sql = "select * from appointment where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, UserId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ap = new AppointmentInfoDTO();
				
				ap.setApId(rs.getInt("id"));

				ap.setAppoinDate(rs.getString("appoinDate"));
				ap.setDiseases(rs.getString("diseases"));
				ap.setStatus(rs.getString("status"));

				int doctorId = rs.getInt("doctor_Id");

				Doctor doctor = ddo.getDoctorById(doctorId);

				ap.setDoctorName(doctor.getFullName());
				ap.setHospitalName(doctor.getHospitalName());
				ap.setQualification(doctor.getQualification());
				ap.setSpecialist(doctor.getSpecialist());
				ap.setDoctorEmail(doctor.getEmail());
				ap.setMobNo(doctor.getMobNo());

				ap.setUserName(user.getFullname());
				ap.setAge(user.getAge());
				ap.setGender(user.getGender());
				ap.setAddress(user.getAddress());
				ap.setUserEmail(user.getEmail());

				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<AppointmentInfoDTO> getAllAppointmentByLoginDoctor(int DoctorId) {
		List<AppointmentInfoDTO> list = new ArrayList<AppointmentInfoDTO>();

		DoctorDao ddo = new DoctorDao();
		AppointmentDAO dd = new AppointmentDAO();
		Doctor doctor = ddo.getDoctorById(DoctorId);
		
		UserDao dd1=new UserDao();

		AppointmentInfoDTO ap = null;
		try {
			String sql = "select * from appointment where doctor_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, DoctorId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ap = new AppointmentInfoDTO();
				
				ap.setApId(rs.getInt("id"));

				ap.setAppoinDate(rs.getString("appoinDate"));
				ap.setDiseases(rs.getString("diseases"));
				ap.setStatus(rs.getString("status"));

				ap.setDoctorName(doctor.getFullName());
				ap.setHospitalName(doctor.getHospitalName());
				ap.setQualification(doctor.getQualification());
				ap.setSpecialist(doctor.getSpecialist());
				ap.setDoctorEmail(doctor.getEmail());
				ap.setMobNo(doctor.getMobNo());
				
				int UserId = rs.getInt("user_id");
				
				System.out.println("user is " + UserId);

				User user = dd1.getUserById(UserId);

							
				ap.setUserName(user.getFullname());
				ap.setAge(user.getAge());
				ap.setGender(user.getGender());
				ap.setAddress(user.getAddress());
				ap.setUserEmail(user.getEmail());
	
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public AppointmentInfoDTO getAppointmentInfoById(int id) 
	{
		
		DoctorDao do1 =new DoctorDao();
		UserDao dd1=new UserDao();

		AppointmentInfoDTO ap = null;
		try {
			String sql = "select * from appointment where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ap = new AppointmentInfoDTO();
				ap.setApId(id);
				ap.setAppoinDate(rs.getString("appoinDate"));
				ap.setDiseases(rs.getString("diseases"));
				ap.setStatus(rs.getString("status"));

				int DoctorId=rs.getInt("doctor_Id");
				Doctor doctor=do1.getDoctorById(DoctorId);
				
				ap.setDoctorName(doctor.getFullName());
				ap.setHospitalName(doctor.getHospitalName());
				ap.setQualification(doctor.getQualification());
				ap.setSpecialist(doctor.getSpecialist());
				ap.setDoctorEmail(doctor.getEmail());
				ap.setMobNo(doctor.getMobNo());
				
				int UserId = rs.getInt("user_id");
				
				System.out.println("user is " + UserId);

				User user = dd1.getUserById(UserId);

				ap.setUserName(user.getFullname());
				ap.setAge(user.getAge());
				ap.setGender(user.getGender());
				ap.setAddress(user.getAddress());
				ap.setUserEmail(user.getEmail());
	
		System.out.println("ap is = " + ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ap;
		
	}

	public List<AppointmentInfoDTO> getAllAppointment() throws SQLException {	
		List<AppointmentInfoDTO> list = new ArrayList<AppointmentInfoDTO>();
		DoctorDao ddo = new DoctorDao();
		AppointmentDAO dd = new AppointmentDAO();
		UserDao dd1=new UserDao();
		AppointmentInfoDTO ap = null;
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new AppointmentInfoDTO();
				ap.setApId(rs.getInt("id"));
				ap.setAppoinDate(rs.getString("appoinDate"));
				ap.setDiseases(rs.getString("diseases"));
				ap.setStatus(rs.getString("status"));
				int DoctorId=rs.getInt("doctor_Id");
				Doctor doctor=ddo.getDoctorById(DoctorId);
				ap.setDoctorName(doctor.getFullName());
				ap.setHospitalName(doctor.getHospitalName());
				ap.setQualification(doctor.getQualification());
				ap.setSpecialist(doctor.getSpecialist());
				ap.setDoctorEmail(doctor.getEmail());
				ap.setMobNo(doctor.getMobNo());
				int UserId = rs.getInt("user_id");				
				System.out.println("user is " + UserId);
				User user = dd1.getUserById(UserId);
				ap.setUserName(user.getFullname());
				ap.setAge(user.getAge());
				ap.setGender(user.getGender());
				ap.setAddress(user.getAddress());
				ap.setUserEmail(user.getEmail());
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;		
}
	
public AppointmentInfoDTO getAllAppointmentById(int id) throws SQLException {
		
		DoctorDao ddo = new DoctorDao();
		AppointmentDAO dd = new AppointmentDAO();
		
		UserDao dd1=new UserDao();

		AppointmentInfoDTO ap = null;
		try {
			String sql = "select * from appointment where id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ap = new AppointmentInfoDTO();
				
				ap.setApId(rs.getInt("id"));

				ap.setAppoinDate(rs.getString("appoinDate"));
				ap.setDiseases(rs.getString("diseases"));
				ap.setStatus(rs.getString("status"));
				
				int DoctorId=rs.getInt("doctor_Id");
				Doctor doctor=ddo.getDoctorById(DoctorId);
				
				ap.setDoctorName(doctor.getFullName());
				ap.setHospitalName(doctor.getHospitalName());
				ap.setQualification(doctor.getQualification());
				ap.setSpecialist(doctor.getSpecialist());
				ap.setDoctorEmail(doctor.getEmail());
				ap.setMobNo(doctor.getMobNo());
				
				int UserId = rs.getInt("user_id");
				
				System.out.println("user is " + UserId);

				User user = dd1.getUserById(UserId);

							
				ap.setUserName(user.getFullname());
				ap.setAge(user.getAge());
				ap.setGender(user.getGender());
				ap.setAddress(user.getAddress());
				ap.setUserEmail(user.getEmail());
	
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ap;		
}

public boolean updateCommentStatus(int id) {
	boolean f=false;
	try {
		String sql = "update appointment set status = ? where id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(2,id);
	    ps.setString(1,"CheckUp completed");
	    
		int i=ps.executeUpdate();
		if(i==1) 
		{
			f=true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;	
}	

}