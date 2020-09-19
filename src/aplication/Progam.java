package aplication;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Progam {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.CreateSellerDao();
		
		System.out.println("---- Test 1: seller findById ------");
		
		Seller seller = sellerDao.FindById(3);
		
		System.out.println(seller);

	}

}
