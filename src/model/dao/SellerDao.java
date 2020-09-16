package model.dao;

import java.util.List;

public interface SellerDao {
	void Insert(SellerDao obj);
	void Update(SellerDao obj);
	void DeleteById(Integer id);
	SellerDao FindById(Integer id);
	List<SellerDao> FindAll();
}
