package model.dao;

import java.util.List;

public interface Seller {
	void Insert(Seller obj);
	void Update(Seller obj);
	void DeleteById(Integer id);
	Seller FindById(Integer id);
	List<Seller> FindAll();
}
