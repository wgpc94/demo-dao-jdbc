package aplication;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Progam {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");
		
		Seller seller = new Seller(21, "Bob", "Bob@email.com", new Date(), 3000.0, obj);
		
		System.out.println(seller);

	}

}
