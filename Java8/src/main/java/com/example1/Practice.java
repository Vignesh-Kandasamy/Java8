package com.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;

public class Practice 
{
	public static void main(String args[])
	{
		/*Removing duplicate from list of integer*/
		
		//method1
		
		List<Integer> list = Arrays.asList(4,8,2,1,5,3,8);
		Set<Integer> set =new HashSet<Integer>();
		
		for(int num : list)
		{
			set.add(num);
		}
		System.out.println("After removing duplicates - "+set);
		
		//method2
		
		List<Integer> list1 = Arrays.asList(4,8,2,1,5,3,8);
		List<Integer> removedDup = new ArrayList<Integer>();
		list1.stream().distinct().forEach(removedDup::add);
		System.out.println("After removing duplicates - "+removedDup);
		
		//or for directly printing
		
		list1.stream().distinct().forEach(System.out::print);
		
		/*-------------------------------------------------------------------------------------------------*/
		
		/*Factorial of a number*/
				
		LongUnaryOperator num= n->{
			int result=1;
			for(int i=1; i<=n;i++)
			{
				result=result*i;
			}
			System.out.println(result);
			return result;
		};
		
		int no=5;
		long factorial_result = num.applyAsLong(no);
		System.out.println("The factorial of "+ no +" is "+factorial_result);
		
		/*-------------------------------------------------------------------------------------------------*/
		
		/*Find all the even numbers in the list using stream API*/
		
		List<Integer> numbers= Arrays.asList(2,5,4,88,34,1,31,72);
		
		numbers.stream().filter(n->n%2==0).forEach(System.out::print);
		
		System.out.println();
		
		/*-------------------------------------------------------------------------------------------------*/
		
		/*Given a list of integers, find out all the numbers starting with 1 using stream functions*/
		
		List<Integer> numbers1= Arrays.asList(2,5,14,88,34,1,31,172);
		
		List<String> num1= numbers1.stream().map(s->s+"").filter(s->s.startsWith("1")).collect(Collectors.toList());
		System.out.println("The numbers starting with 1 are - "+num1);
				
		/*-------------------------------------------------------------------------------------------------*/
		
		/*How to remove the duplicate elements in a given integers list in java using stream functions*/
		
		List<Integer> numbers2= Arrays.asList(172,5,14,88,34,14,31,172);
		
		List<Integer> remDup=numbers2.stream().distinct().collect(Collectors.toList());
		System.out.println("After removing the duplicate elements - "+remDup);
		
		/*-------------------------------------------------------------------------------------------------*/
		
		/*How to find the duplicate elements in a given integers list in java using stream functions*/
		
		List<Integer> numbers3= Arrays.asList(172,5,14,88,34,14,31,172);
		
		Set<Integer> set1= new HashSet<>();
		List<Integer> l1=numbers3.stream().filter(n->!set1.add(n)).collect(Collectors.toList());
		System.out.println("The duplicate elements in the list are - "+l1);
		
		/*-------------------------------------------------------------------------------------------------*/
		
		/*Given the list of integers, find the first element of the list using stream functions*/
		
		List<Integer> numbers4= Arrays.asList(25,172,5,14,88,34,14,31,172);
		
		int firstElement=numbers4.stream().findFirst().get();
		System.out.println("The first element of the list is - "+firstElement);
		
		/*-------------------------------------------------------------------------------------------------*/
		
		/*Given the list of integers, find the total number of elements present in the list using stream functions*/
		
		List<Integer> numbers5= Arrays.asList(25,172,5,14,88,34,14,31,172);
		
		long count=numbers5.stream().count();
		System.out.println("Total no of elements in list - "+count);
		
		/*-------------------------------------------------------------------------------------------------*/
		
		/*Given the list of integers, find the total number of elements present in the list using stream functions*/
		
		List<Integer> numbers6= Arrays.asList(25,172,5,14,88,34,14,31,172);
		
		int maxNumber=numbers6.stream().max((a,b)->a.compareTo(b)).get();
		System.out.println("Maximum number is - "+maxNumber);
		
		/*-------------------------------------------------------------------------------------------------*/
		
		/*Given the list of integers, sort all the values present in the list using stream functions*/	
		
		List<Integer> numbers7= Arrays.asList(25,172,5,14,88,34,14,31,172);
		
		List<Integer> sortedList = numbers7.stream().sorted().collect(Collectors.toList());
		System.out.println("The elements sorted in ascending order is - "+sortedList);

		/*-------------------------------------------------------------------------------------------------*/
		
		/*Given the list of integers, sort all the values present in it in descending order using stream functions*/	
		
		List<Integer> numbers8= Arrays.asList(25,172,5,14,88,34,14,31,172);
		
		List<Integer> sortDesc= numbers8.stream().sorted((n1,n2)->n2.compareTo(n1)).collect(Collectors.toList());
		System.out.println("The elements sorted in descending order is - "+sortDesc);
	}
}
