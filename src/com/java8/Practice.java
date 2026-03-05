package com.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Practice 
{
	public static void main(String args[])
	{
		/*------------------------------------Converting UpperCase---------------------------------------*/
		
		List<String> toUpperCase= Arrays.asList("vignesh","boopi");		
		List<String> upperCase=toUpperCase.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("UpperCase is : "+upperCase);
		
		/*------------------------------------Sorting of Strings in descending order---------------------------------------*/
		
		List < String > toDescendingOrder = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        List<String> descendingOrder=toDescendingOrder.stream().sorted((s1,s2)->s2.compareTo(s1)).collect(Collectors.toList());
        System.out.println("Descending Order : "+descendingOrder);
		
		/*--------------------------------Removing duplicate from list of integer-----------------------------------*/
		
		List<Integer> removeDuplicates = Arrays.asList(4,8,2,1,5,3,8);
		List<Integer> uniqueElements = new ArrayList<Integer>();
		removeDuplicates.stream().distinct().forEach(uniqueElements::add);
		System.out.println("After Removing duplicates : "+uniqueElements);
		
		//or for directly printing
		
		removeDuplicates.stream().distinct().forEach(System.out::print);
		System.out.println();
		
		//or for directly printing
		
		List<Integer> uniqueElements1=removeDuplicates.stream().distinct().collect(Collectors.toList());
		System.out.println("After Removing duplicates 1 : "+uniqueElements1);
		
		/*------------------------------------------------Factorial of a number-------------------------------------------------*/
						
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
		
		//or
		
		long factorial = LongStream.rangeClosed(1, 5).reduce(1,(a,b)->(a*b));
		System.out.println("The factorial of 5 is :"+factorial);
		
		/*-------------------------------------------------Find even numbers----------------------------------------------------*/
		
		List<Integer> getEvenNumbers= Arrays.asList(2,5,4,88,34,1,31,72);
		List<Integer> evenNumbers=getEvenNumbers.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println("Even Numbers : "+evenNumbers);
		
		/*--------------------------------------Find out all the numbers starting with 1-----------------------------------------*/
		
		List<Integer> getStartsWith1= Arrays.asList(2,5,14,88,34,1,31,172);
		List<String> numberStartsWith1= getStartsWith1.stream().map(s->s+"").filter(s->s.startsWith("1")).collect(Collectors.toList());
		System.out.println("The numbers starting with 1 are : "+numberStartsWith1);
				
		/*----------------------------------------Find the duplicates from the list------------------------------------------------*/
		
		List<Integer> getDuplicates= Arrays.asList(172,5,14,88,34,14,31,172);
		Set<Integer> duplicateSet= new HashSet<>();
		List<Integer> duplicates=getDuplicates.stream().filter(n->!duplicateSet.add(n)).collect(Collectors.toList());
		System.out.println("The duplicate elements are : "+duplicates);
		
		/*---------------------------------Find the first element of the list------------------------------------*/
		
		List<Integer> toFindFirst= Arrays.asList(25,172,5,14,88,34,14,31,172);
		int findFirst=toFindFirst.stream().findFirst().get();
		System.out.println("The first element in the list is : "+findFirst);
		
		toFindFirst.stream().findFirst().ifPresent(System.out::println);
		
		/*--------------------Find the total number of elements in the list using stream functions--------------------*/
		
		List<Integer> getCount= Arrays.asList(25,172,5,14,88,34,14,31,172);
		long count=getCount.stream().count();
		System.out.println("Total no of elements in list : "+count);
		
		/*---------------------------------Find the maximum number using stream functions---------------------------------*/
		
		List<Integer> getMaxNumber= Arrays.asList(25,172,5,14,88,34,14,31,172);
		int maxNumber=getMaxNumber.stream().max((a,b)->a.compareTo(b)).get();
		System.out.println("Maximum number is : "+maxNumber);
		
		/*------------------------Sort all the values in ascending order using stream functions------------------------*/
		
		List<Integer> sortAscending= Arrays.asList(25,172,5,14,88,34,14,31,172);
		List<Integer> ascending = sortAscending.stream().sorted().collect(Collectors.toList());
		System.out.println("The Ascending order is : "+ascending);

		/*----------------------Sort all the values in descending order using stream functions-------------------*/
		
		List<Integer> sortDescending= Arrays.asList(25,172,5,14,88,34,14,31,172);
		List<Integer> descending= sortDescending.stream().sorted((n1,n2)->n2.compareTo(n1)).collect(Collectors.toList());
		System.out.println("The elements sorted in descending order is : "+descending);
		
		/*---------------------------------Find string whose length is greater than 3------------------------------*/
		
		List<String> getStringGreaterThan3= Arrays.asList("Hello","ow","ae","you","where","am");
		List<String> stringGreaterThan3=getStringGreaterThan3.stream().filter(s->s.length()>=3).collect(Collectors.toList());
		System.out.println("String length greater or equal to 3 : "+ stringGreaterThan3);
		
		/*---------------------------------Count string whose length is greater than 3------------------------------*/
		
		long resultCount=getStringGreaterThan3.stream().filter(s->s.length()>=3).count();
		System.out.println("Count of String length is greater than 3 : "+resultCount);
		
		/*-----------------------------multiply 3 to all elements in the list and print the list--------------------------*/
		
		List<Integer> toMultiplyBy3 = Arrays.asList(4,8,2,1,5,3,8);
		List<Integer> multiplyBy3=toMultiplyBy3.stream().map(s->s*3).collect(Collectors.toList());
		System.out.println("Multiplying each element with 3 : "+multiplyBy3);
		
		/*---------------------------------------Concatenation of two streams-----------------------------------*/
		
		List<Integer> list1 = Arrays.asList(4,8,1,5);
		List<Integer> list2 = Arrays.asList(6,3,7,2);
		
		List<Integer> concatStream = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
		System.out.println("Concatenation of two streams : "+concatStream);

		/*-------------------------------------------Sum of all elements in a list-------------------------------------*/
		
		List<Integer> getSum = Arrays.asList(4,8,1,5,10);
		int sum=getSum.stream().mapToInt(Integer::intValue).sum();
		System.out.println("The Sum is : "+sum);
		
		/*-------------------------------------------Get the Occurrence of string elements-------------------------------------*/
		
		List<String> getOccurrenceOfString = Arrays.asList("Vicky","Saravana","naveen","anuja","Eli","Vicky");		
		Map<String,Long> occurrenceOfNames=getOccurrenceOfString.stream().map(String::toLowerCase).collect(Collectors.groupingBy(e->e,Collectors.counting()));
		System.out.println("The Occurrence of list of Strings is : "+occurrenceOfNames);

		/*-------------------------------------------Get the Occurrence of characters-------------------------------------*/
		
		String getOccurrenceOfChar="KamalaKannan";
		Map<String,Long> occurrenceOfChar=Arrays.stream(getOccurrenceOfChar.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(e->e,LinkedHashMap::new,Collectors.counting()));
		System.out.println("The Occurrence of String is : " +occurrenceOfChar);
		
		/*-------------------------------------------Find the Local Date using Java8------------------------------------*/
		
		LocalDate localDate = java.time.LocalDate.now();
		System.out.println("LocalDate is : "+localDate);
		
		/*-------------------------------------------Find the Local Time using Java8------------------------------------*/
		
		LocalTime localTime = java.time.LocalTime.now();
		System.out.println("LocalTime is : "+localTime);
		
		/*-------------------------------------------Find the LocalDateTime using Java8------------------------------------*/
		
		LocalDateTime localDateTime = java.time.LocalDateTime.now();
		System.out.println("LocalDateTime is : "+localDateTime);
		
		/*--------------------------------------------------Modify Map-----------------------------------------------------*/
		
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "Vignesh");
		map.put(2, "Buvi");
		
		map.computeIfPresent(1, (key,value)->"Boopika");
		System.out.println("Modifying the value in a map : "+map);
		
		map.computeIfAbsent(3, (value)->"Vicky");
		System.out.println("Adding new entry in a map : "+map);
		
		int[] arr= {1,1,2,2,3,3,3,4,4,9,6,0};
		long summing = Arrays.stream(arr).distinct().filter(s->s%2==1).sum();
		System.out.println(summing);
		 
	}
	public static String m1()
	{
		return "Vignesh";
	}
}
