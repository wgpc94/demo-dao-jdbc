package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn = null;
	
	public SellerDaoJDBC(Connection conn){
		this.conn = conn;
	}

	@Override
	public void Insert(SellerDao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(SellerDao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller FindById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
			"SELECT seller.*,department.Name as DepName " 
			+ "FROM seller INNER JOIN department " 
			+ "ON seller.DepartmentId = department.Id " 
			+ "WHERE seller.Id = ?");
					
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department department = new Department();
				
				department.setId(rs.getInt("DepartmentId"));
				department.setName(rs.getString("DepName"));
				
				Seller seller = new Seller();
				
				seller.setId(rs.getInt("Id"));
				seller.setName(rs.getString("Name"));
				seller.setEmail(rs.getString("Email"));
				seller.setBirthDate(rs.getDate("BirthDate"));
				seller.setBaseSalary(rs.getDouble("BaseSalary"));
				seller.setDepartment(department);
				
				return seller;	
			}
			return null;

		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	
	}

	@Override
	public List<SellerDao> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
