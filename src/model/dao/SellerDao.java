package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	void Insert(SellerDao obj);
	void Update(SellerDao obj);
	void DeleteById(Integer id);
	Seller FindById(Integer id);
	List<SellerDao> FindAll();
}
