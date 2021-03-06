package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Progam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		

		System.out.println("\n---- Test 3: seller findAll ------");
		
		List<Seller> lista = sellerDao.FindAll();
		
		for (Seller x: lista) {
			System.out.println(x);
			
		}
		
		System.out.println("\n---- Test 4: seller insert ------");
		Seller sellerInsert = new Seller(null, "Greg", "Greg@email.com", new Date(), 4000.0, dep);
		
		sellerDao.Insert(sellerInsert);
		
		System.out.println("new Id: "+sellerInsert.getId());
		
		System.out.println("\n---- Test 5: seller update ------");
		
		Seller sellerUpdate = sellerDao.FindById(1);
		sellerUpdate.setName("Bruce wayne");
		
		sellerDao.Update(sellerUpdate);
		System.out.println("Update completed!");
		
		System.out.println("\n---- Test 6: seller delete ------");
		System.out.print("Enter Id for delete test: ");
		int id = sc.nextInt();
		sellerDao.DeleteById(id);
		System.out.println("Delete completed!");
		sc.close();
	}
	

}
