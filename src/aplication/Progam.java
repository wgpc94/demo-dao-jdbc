package aplication;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Progam {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.CreateSellerDao();
		
		System.out.println("---- Test 1: seller findById ------");
		
		Seller seller = sellerDao.FindById(3);
		
		System.out.println(seller);

		
		System.out.println("\n---- Test 2: seller findByDepartmentId ------");
		Department dep = new Department(2,null);
		
		List<Seller> listaDepId = sellerDao.FindByDepartment(dep);
		
		for (Seller x: listaDepId) {
			System.out.println(x);
			
		}
	}

}
