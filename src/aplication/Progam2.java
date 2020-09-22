package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Progam2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("---- Test 1: department insert ------");
		Department dep = new Department(null, "Mecanica");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		departmentDao.Insert(dep);
		System.out.println("new Id: "+dep.getId());
		
		System.out.println("---- Test 2: department update ------");
		Department departmentUpdate = new Department(6,"Automoção");
		departmentDao.Update(departmentUpdate);
		System.out.println("Update complected");
		
		System.out.println("---- Test 3: department delete ------");
		System.out.print("Enter id delete: ");
		int id = sc.nextInt();
		departmentDao.DeleteById(id);
		System.out.println("Delete complected");
		
		
		System.out.println("---- Test 4: department findById ------");
		System.out.print("Enter the seach Id: ");
		id = sc.nextInt();
		dep = departmentDao.FindById(id);
		System.out.println(dep);
		
		System.out.println("---- Test 5: department findAll ------");
		List<Department> deps = new ArrayList<>();
		deps = departmentDao.FindAll();
		
		for (Department x: deps) {
			System.out.println(x);
			
		}
		



		sc.close();
	}

}
