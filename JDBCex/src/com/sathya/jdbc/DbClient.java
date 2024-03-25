package com.sathya.jdbc;

//import java.util.List;

public class DbClient {
	public static void main(String args[]){
		EmployeeDao employeeDao=new EmployeeDao();
//		int res1 = employeeDao.save(new Employee(1001, "Anvesh", 50000));
//		System.out.println("Data Inserted Successfully...."+res1);
//		
//		int res2=employeeDao.save(new Employee(1002, "Kranthi", 50000));
//		System.out.println("Data inserted successfully..."+res2);
//		
//		Employee emp=employeeDao.findById(1001);
//		System.out.println(emp);
//		
//		Employee emp1=employeeDao.findById(1002);
//		System.out.println(emp1);
//		
//		int deletecount=employeeDao.deleteById(1002);
//		if(deletecount==1)
//			System.out.println("Data deleted successfully");
//		else
//			System.out.println("Data Deletion fail");
//		
//		int deletecount1=employeeDao.deleteBysalary(30000);
//		System.out.println("No of records deleted "+deletecount1);
//		
//		List<Employee> emps=employeeDao.findAll();
//		emps.forEach(System.out::println);
		
		int updatecount = employeeDao.updateSalary(60000, 2000);
		System.out.println("Number of records updated "+updatecount);
	}
}
