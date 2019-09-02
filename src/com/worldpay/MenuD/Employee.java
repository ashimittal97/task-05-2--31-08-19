package com.worldpay.MenuD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Employee implements Comparable<Employee> {
	int eno;
	String name;
	int salary;
	String desg;
	String dept;

	static ArrayList<Employee> list = new ArrayList<>();
	

	Employee() {

	}

	Employee(int eno, String name, int salary, String desg, String dept) {
		this.eno = eno;
		this.name = name;
		this.salary = salary;
		this.desg = desg;
		this.dept = dept;

	}
	  @Override
		public int compareTo(Employee emp) {

			if(eno>emp.eno){
				return 1;
			}else if(eno<emp.eno){
				return -1;
			}else{
		int n=name.compareTo(emp.name);
				return n;
			}
		}
			
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (eno != other.eno)
				return false;
			if (salary != other.salary)
				return false;
			return true;
		}
		
			@Override
			public int hashCode() {
				return eno;
			}
			
			@Override
			public String toString() {
				return "Employee [eno=" + eno + ", ename=" + name + ",dept=" + dept + ",des=" +desg + ", sal=" + salary + "]";
			}

			public int getEno() {
				return eno;
			}
			public void setEno(int eno) {
				this.eno = eno;
			}
			
			
			public int getSal() {
				return salary;
			}
			public String getEname() {
				return name;
			}


			public void setEname(String ename) {
				this.name = ename;
			}


			public String getDes() {
				return desg;
			}


			public void setDes(String desg) {
				this.desg = desg;
			}


			public String getDept() {
				return dept;
			}


			public void setDept(String dept) {
				this.dept = dept;
			}


			public void setSal(int salary) {
				this.salary = salary;
			}


		
	    


	


	void employeeDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many employee's you want to add??");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			System.out.println("Enter the eno:");
			eno = sc.nextInt();

			System.out.println("Enter the name of employee:");
			sc.nextLine();
			name = sc.nextLine();

			System.out.println("Enter the salary of employee:");
			salary = sc.nextInt();

			System.out.println("Enter the desigination of employee :");
			sc.nextLine();
			desg = sc.nextLine();

			System.out.println("Enter the departement of the employee [IT/ACCOUNTS/MARKETING/HR]");
			dept = sc.nextLine();
			Employee eobj = new Employee(eno, name, salary, desg, dept);
			list.add(eobj);

		}
		System.out.println("employee added");
	}

	public static void ViewAll(ArrayList<Employee> empList) {
		for (Employee list : list) {
			System.out.println(list.eno);
			System.out.println(list.name);
			System.out.println(list.salary);
			System.out.println(list.desg);
			System.out.println(list.dept);
		}
		System.out.println("This  are all employee");
	}

	public static int Remove(int id) {
		for (int i = 0; i <= list.size(); i++)
			if (list.get(i).eno == id) {
				list.remove(list.get(i));

			}
		System.out.println("Empolyee deleted");
		return 0;
	}

	public static void clearData() {
		list.clear();
	}

	public void changeSalary() {
		Scanner s4=new Scanner(System.in);
		System.out.println("enter eno of employee whom you want to change salary");{
			int chngsal=s4.nextInt();
			for(int i=0;i<list.size();i++){
				if(list.get(i).eno==chngsal){
					System.out.println("insert the new salary you want");
					int newsal=s4.nextInt();
					list.get(i).salary=newsal;
					System.out.println("salary changed");
				}
			}
		}
	
	}

	public static void searchEmployee(int id) {
		for (int i = 0; i <= list.size(); i++) {
			if (list.get(i).eno == id) {
				System.out.println("E no:" + list.get(i).eno);
				System.out.println("E name:" + list.get(i).name);
				System.out.println("E salary:" + list.get(i).salary);
				System.out.println("E desg:" + list.get(i).desg);
				System.out.println("E dept:" + list.get(i).dept);

			}
		}
	}

	public void deptWise() {
		Scanner sc2 = new Scanner(System.in);
		String c = sc2.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).dept.equals(c)) {
				System.out.println("E no:" + list.get(i).eno);
				System.out.println("E name:" + list.get(i).name);
				System.out.println("E salary:" + list.get(i).salary);
				System.out.println("E desg:" + list.get(i).desg);
				System.out.println("E dept:" + list.get(i).dept);
			}
		}

	}
	public static void viewSortedEmployee(){
		Collections.sort(list);
		System.out.println(list);	
	}
	public static void SortEmployee(){
	   // System.out.println(list);
		Scanner s3=new Scanner(System.in);
		System.out.println("DEFAULT SORTING ON EMPLOYEE NUMBER GIVE YOUR CHOICE TO SORT ON DIFFERENT ASPECTS");
		viewSortedEmployee();
	    System.out.println("SORT ON THE BASIS OF:");
	    System.out.println("1.EMPLOYEE NO");
	    System.out.println("2.SALARY");
	    System.out.println("3.EMPLOYEE NAME");
	    System.out.println("4.EMPLOYEE DEPARTMENT");
	    
		int sortBasis=s3.nextInt();
		
		if(sortBasis==1){
			Collections.sort(list, new Comparator<Employee>(){
		          @Override
					public int compare(Employee e1, Employee e2) {
						return e1.getEno()-e2.getEno();
						
					}});
		}
		else if(sortBasis==2){
			Collections.sort(list, new Comparator<Employee>(){
		          @Override
					public int compare(Employee e1, Employee e2) {
						return e1.getSal()-e2.getSal();
					
						
					}});
		}
		else if(sortBasis==3){
			Collections.sort(list, new Comparator<Employee>(){
		          @Override
					public int compare(Employee e1, Employee e2) {
		        		int n=e1.getEname().compareTo(e2.getEname());
		      			return n;
						
					}});
		}
		else if(sortBasis==4){
			Collections.sort(list, new Comparator<Employee>(){
		          @Override
					public int compare(Employee e1, Employee e2) {
		        	  int n=e1.getDept().compareTo(e2.getDept());
		      			return n;
						
					}});
		}
			else System.out.println("INVALID ENTRY");
			
			
		for(Employee emp:list){
			System.out.println(emp);
			}	
	
	
	}
	

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Employee emp = new Employee();
		int choice;
		while (true) {
			System.out.println("\n");
			System.out.println("Menu:");
			System.out.println("1.Add Employee");
			System.out.println("2.View all Employee");
			System.out.println("3.Remove Employee");
			System.out.println("4.Clear Data");
			System.out.println("5.Change Salary");
			System.out.println("6.Search Employee");
			System.out.println("7.view departement wise list:");
			System.out.println("8.viewSortedEmployee");
			System.out.println("9.Exit");
			System.out.println("Enter your Choice:");
			choice = sc1.nextInt();
			switch (choice) {
			case 1:
				emp.employeeDetails();
				break;
			case 2:
				ViewAll(list);
				break;
			case 3:
				System.out.println("Enter the id you want to remove");
				Remove(sc1.nextInt());
				break;
			case 4:
				clearData();
				break;
			case 5:
				
				emp.changeSalary();
				break;

			case 6:
				System.out.println("Enter the id you want to search");
				searchEmployee(sc1.nextInt());
				break;

			case 7:
				emp.deptWise();
				break;
			case 8:
				SortEmployee();
			case 9:
				System.exit(1);
			default:
				break;
			}
		}

	}

}
