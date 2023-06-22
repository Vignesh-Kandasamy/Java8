package com.example1;

public class Test1 {

	public void m2(String s)
	{
		System.out.println(s);
	}
	
	public static void main(String[] args)
	{
		Test1 test=new Test1();
		Infra i=test::m2;
		i.getLength("Helloqqqq!!!!!!!!!!");
	}
}
