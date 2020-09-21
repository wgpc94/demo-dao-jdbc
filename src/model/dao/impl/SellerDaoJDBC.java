package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void Insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Seller obj) {
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
				Department department = InstantiateDepartment(rs);
				Seller seller = InstantiateSeller(rs,department);
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
	public List<Seller> FindByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
			"SELECT seller.*,department.Name as DepName " 
			+ "FROM seller INNER JOIN department " 
			+ "ON seller.DepartmentId = department.Id " 
			+ "WHERE DepartmentId = ? "
			+ "ORDER BY Name" );
			
					
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
			List<Seller> lista = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = InstantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				Seller seller = InstantiateSeller(rs,dep);
				lista.add(seller);
				}
			return lista;

		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	
		
	}

	

	private Seller InstantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setDepartment(department);
		
		return seller;
	}

	private Department InstantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("DepartmentId"));
		department.setName(rs.getString("DepName"));	
		return department;
	}

	@Override
	public List<Seller> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
