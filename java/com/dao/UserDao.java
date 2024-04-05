package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entity.Doctor;
import com.entity.User;

public class UserDao {

	private Connection conn;

	public UserDao() {
		conn = DbConnection.getCon();
		}

	public boolean register(User u) {
		boolean f = false;
        
		try {
			String sql = "insert into user_tbls(full_name,age,gender,address,email,password,state) values(?,?,?,?,?,?,?) ";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFullname());
			ps.setString(2,u.getAge());
			ps.setString(3, u.getGender());
			ps.setString(4,u.getAddress());
			ps.setString(5, u.getEmail());
			ps.setString(6,u.getPassword());
			ps.setString(7, u.getStates());
			
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public User login(String em, String psw) {
		User u = null;

		try {
			String sql = "select * from user_tbls where email=? and password=? and state=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			ps.setString(3, "Active");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setFullname(rs.getString("full_name"));
				u.setAge(rs.getString("age"));
				u.setAddress(rs.getString("address"));
				u.setGender(rs.getString("gender"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setStates(rs.getString("state"));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}
	
	public boolean update(User u) throws SQLException {
		System.out.println("In Update method");
		boolean l=false;
		String sql = "update user_tbls set full_name=? ,age=?, gender=?,address=?, email=? , password=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, u.getFullname());
		ps.setString(2,u.getAge());
		ps.setString(3,u.getGender());
		ps.setString(4,u.getAddress());
		ps.setString(5,u.getEmail());
		ps.setString(6,u.getPassword());
		
		ps.setInt(7,u.getId());
		int i=ps.executeUpdate();
		if(i==1) 
		{
			l=true;
		}
		return l;
	}
	public User getUserById(int id) {

		User u = null;
		try {

			String sql = "select * from user_tbls where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setFullname(rs.getString("full_name"));
				u.setAge(rs.getString("age"));
				u.setGender(rs.getString("gender"));
				u.setAddress(rs.getString("address"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setStates(rs.getString("state"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		User u = null;
		try {

			String sql = "select * from user_tbls ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setFullname(rs.getString("full_name"));
				u.setAge(rs.getString("age"));
				u.setGender(rs.getString("gender"));
				u.setAddress(rs.getString("address"));
				u.setEmail(rs.getString("email"));
				u.setStates(rs.getString("state"));
				
				list.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean updateState(int id,String state) 
	{
		boolean f=false;
		try 
		{
			String sql="update user_tbls set state=? where id=? ";
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