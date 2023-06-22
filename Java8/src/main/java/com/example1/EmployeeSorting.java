package com.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee
{
	int empno;
	String empname;
	
	public Employee(int empno, String empname)
	{
		this.empno=empno;
		this.empname=empname;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + "]";
	}
	
}
 class EmployeeSorting 
{
	public static void main(String args[])
	{
		List<Employee> list=new ArrayList<>();
		list.add(new Employee(20,"vicky"));
		list.add(new Employee(60,"Arun"));
		list.add(new Employee(5,"saran"));
		Collections.sort(list,(e1,e2)->(e1.empno<e2.empno)?-1:(e1.empno>e2.empno)?1:0);
		System.out.println(list);
	}
}

