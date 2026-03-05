package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Programs {

	public static void main(String[] args) 
	{
		//Given a list of integers, separate odd and even numbers
		List<Integer> list = Arrays.asList(14,5,9,44,72,2,6,105,5,15,3,6);
		List<Integer> evenNumbers = list.stream().filter(s->s%2==0).collect(Collectors.toList());
		System.out.println("Even Numbers : "+evenNumbers);

		List<Integer> oddNumbers = list.stream().filter(s->s%2==1).collect(Collectors.toList());
		System.out.println("Odd Numbers : "+oddNumbers);
		
		Map<Boolean, List<Integer>> oddAndEven = list.stream().collect(Collectors.partitioningBy(s->s%2==0));
		System.out.println("Even numbers : "+ oddAndEven.get(true));
		System.out.println("Odd numbers : "+ oddAndEven.get(false));
		
		Map<Boolean,List<Integer>> oddAndEven1 =
				 IntStream.rangeClosed(1, 10).boxed()
				 .collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("Even numbers : "+ oddAndEven1.get(true));
		System.out.println("Odd numbers : "+ oddAndEven1.get(false));
		
		//How do you remove duplicate elements from a list using Java 8 streams?
		List<Integer> uniqueNumbers=list.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique Numbers : "+uniqueNumbers);
		
		Map<Integer, Long> countOfElements = list.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()));
		List<Integer> duplicateElementsWithoutSet = countOfElements.entrySet().stream().filter(s->s.getValue()>1)
				.map(s->s.getKey()).collect(Collectors.toList());
		System.out.println("Duplicate elements without using set : " + duplicateElementsWithoutSet);
		
		//How do you find frequency of each character in a string using Java 8 streams?
		String str = "Vignesh vicky";
		Map<String,Long> charCount = Arrays.stream(str.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(e->e, LinkedHashMap::new ,Collectors.counting()));
		System.out.println("Frequency of characters : "+charCount);

		//How do you find frequency of each element in an array or a list?
		List<String> listOfStrings = Arrays.asList("Vignesh","Boopi","Saravana","vignesh","gopi","saravana","Vignesh");
		Map<String, Long> frequencyOfElements = listOfStrings.stream().collect(Collectors.groupingBy(e->e, LinkedHashMap::new, Collectors.counting()));
		System.out.println("Frequency of elements : "+frequencyOfElements);

		//How do you sort the given list of decimals in reverse order?
		List<Integer> reverseOrder=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sorting in reverse order : "+reverseOrder);

		//Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
		String delimiter = listOfStrings.stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println("Join the Strings with brackets : "+delimiter);

		//From the given list of integers, print the numbers which are multiples of 5
		List<Integer> multiplyBy5 = list.stream().filter(s->s%5==0).collect(Collectors.toList());
		System.out.println("Multiply of 5 : "+multiplyBy5);

		//Given a list of integers, find maximum and minimum of those numbers?
		Integer maximum = list.stream().max(Comparator.naturalOrder()).get();
		System.out.println("Maximum number from the list : "+maximum);

		Integer minimum = list.stream().min(Comparator.naturalOrder()).get();
		System.out.println("Minimum number from the list : "+minimum);

		//How do you merge two unsorted arrays into single sorted array using Java 8 streams?
		List<Integer> list2 = Arrays.asList(2,6,1,4,8);
		List<Integer> list3 = Arrays.asList(1,3,5,4,7);
		List<Integer> concat = Stream.concat(list2.stream(), list3.stream()).sorted().collect(Collectors.toList());
		System.out.println("Merging two lists : "+concat);

		//How do you merge two unsorted arrays into single sorted array without duplicates?
		List<Integer> concatWithoutDup = Stream.concat(list2.stream(), list3.stream()).sorted().distinct().collect(Collectors.toList());
		System.out.println("Mergind two list without dup : "+concatWithoutDup);

		//How do you get three maximum numbers and three minimum numbers from the given list of integers?
		List<Integer> maxThreeNumbers = list.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		System.out.println("Finding the max three numbers : "+maxThreeNumbers);

		List<Integer> minThreeNumbers = list.stream().sorted().limit(3).collect(Collectors.toList());
		System.out.println("Finding the min three numbers : "+minThreeNumbers);

		//Java 8 program to check if two strings are anagrams or not?
		String string1 ="HepLo";
		String string2 = "OHlle";
		string1 = Arrays.stream(string1.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
		string2 = Arrays.stream(string2.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
		if(string1.equals(string2))
			System.out.println("Anagram");
		else
			System.out.println("Not Anagram");

		//Find sum of all digits of a number in Java 8?
		Integer sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum of numbers : "+sum);

		//Find second largest number in an integer array?
		Integer secondLargest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("Finding the second largest number : "+secondLargest);

		//Given a list of strings, sort them according to increasing order of their length?
		List<String> list4 = Arrays.asList("Apple","Orange","Mango","Kiwi","Keer","Banana","Brinjal");
		List<String> sorting = list4.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
		System.out.println("Increasing order of length : "+sorting);

		//How do you find common elements between two arrays?
		List<Integer> commonElements = list2.stream().filter(list3::contains).collect(Collectors.toList());
		System.out.println("Common elements in two lists : "+commonElements);
		
		List<String> list5 = Arrays.asList("apple", "banana", "cherry");
        List<String> list6 = Arrays.asList("banana", "cherry", "date");
        List<String> common = new ArrayList<>(list5); 
        common.retainAll(list6); 
        System.out.println("Common Elements : "+common);

		//Reverse each word of a string using Java 8 streams?
		String str1 = "Java Concept Of The Day";
		String reverseString =Arrays.stream(str1.split(" ")).map(s->new StringBuffer(s).reverse()).collect(Collectors.joining(" "));
		System.out.println("Reverse each string : "+reverseString);

		//How do you find sum of first 10 natural numbers?
		Integer sum1 = IntStream.range(1, 10).sum();
		System.out.println("Sum of first 10 natural numbers : "+sum1);

		//Reverse an integer array
		int arr[] = {1,5,7,9,23,6};
		int[] reverseArray = IntStream.rangeClosed(1, arr.length).map(s->arr[arr.length-s]).toArray();
		System.out.println("Reverse of array : "+Arrays.toString(reverseArray));

		//Print first 10 even numbers
		IntStream.rangeClosed(1, 10).map(a->a*2).forEach(System.out::println);

		//How do you find the most repeated element in an array?
		List<String> listOfString = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
		Map<String, Long> count  =listOfString.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()));
		Entry<String,Long> repeatedWord = count.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("Most repeated elements in an array : "+repeatedWord.getValue());

		//Given a list of strings, find out those strings which start with a number?
		List<String> listOfStringss = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
		List<String> notAChar = listOfStringss.stream().filter(s->Character.isDigit(s.charAt(0))).collect(Collectors.toList());
		System.out.println("Starts with Number : "+notAChar);

		//How do you extract duplicate elements from an array?
		List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		Set<Integer> set = new HashSet<>();
		List<Integer> duplicateElements =listOfIntegers.stream().filter(a->!set.add(a)).collect(Collectors.toList());
		System.out.println("Duplicate elements : "+duplicateElements);

		//Print duplicate characters in a string?
		Set<String> set1= new HashSet<>();
		Set<String> dupChars = Arrays.stream(str1.split("")).map(String::toLowerCase).filter(b->!set1.add(b)).collect(Collectors.toSet());
		System.out.println("Duplicate Characters from the String : "+dupChars);

		//Find first repeated character in a string?
		String inputString1 = "Java Concept Of The Day";
		Map<String,Long> count2 = Arrays.stream(inputString1.split("")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(e->e, LinkedHashMap::new, Collectors.counting()));
		System.out.println(count2);
		String firstRepeatedChar= count2.entrySet().stream().filter(c->c.getValue()>1).map(s->s.getKey()).findFirst().get();
		System.out.println("First repeated characters from the String : "+firstRepeatedChar);

		//Find first non repeated character in a string?
		String firstNonRepeatedChar = count2.entrySet().stream().filter(a->a.getValue()==1).map(b->b.getKey()).findFirst().get();
		System.out.println("First non-repeated characters from the String : "+firstNonRepeatedChar);

		//How do you get last element of an array?
		Integer lastElement = listOfIntegers.stream().skip(listOfIntegers.size()-1).findFirst().get();
		System.out.println("Last element of an array : "+lastElement);

		//Find the longest String in the list using java 8
		String longestString = listOfStrings.stream().max((s1,s2)->Integer.compare(s1.length(), s2.length())).get();
		System.out.println("Longest String : "+longestString);
		
		//Find the number that starts with 1
		List<Integer> numbers = Arrays.asList(12, 23, 25, 34, 29, 42);
        List<Integer> numberStartsWith = numbers.stream().filter(n -> String.valueOf(n).startsWith("2"))
                                      .collect(Collectors.toList());
        System.out.println("Number starts with : "+numberStartsWith);
        
      	List<String> startsWith1 = list.stream().map(String::valueOf).filter(s->s.startsWith("1")).collect(Collectors.toList());
      	System.out.println("Number starts with : "+startsWith1);

		//Java 8 to print only the first letter of each word
        //Scenario -1
		String input = "Hello Welcome to Java";
		String output = Arrays.stream(input.split(" ")).flatMap(s->Stream.of(s.charAt(0))).map(String::valueOf).collect(Collectors.joining());
		System.out.println("First letter of each word : "+output);
		
		//Scenario-2
		String output1 = Arrays.stream(input.split(" ")).map(word -> word.substring(0, 1)).collect(Collectors.joining());
		System.out.println("First letter of each word : "+output1);

		//Scenario-3
		List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date");
		List<String> firstLetters = words.stream().map(word -> word.substring(0, 1)).collect(Collectors.toList());
		System.out.println("First letter of each word : "+firstLetters);

		//To List
		List<Integer> listOfElementsList = Stream.of(2,4,2,5,5,7).collect(Collectors.toList());
		System.out.println("To List : "+listOfElementsList);

		//To Set
		Set<Integer> listOfElementsSet = Stream.of(2,4,2,5,5,7).collect(Collectors.toSet());
		System.out.println("To Set : "+listOfElementsSet);

		//To Set -1
		Set<Integer> listOfElementsSet1 = list.stream().collect(Collectors.toSet());
		System.out.println("To Set : "+listOfElementsSet1);

		//group strings by their length
		Map<Integer, String> groupStrings = Stream.of("apple", "banana", "cherry")
				.collect(Collectors.toMap(String::length,s -> s, (a, b) -> a + ", " + b ));
		System.out.println("Group Strings by their length: "+ groupStrings);

		//Join all words into a single comma-separated string.
		String commaSeparated = Stream.of("Vignesh","Kamal","Vijay").collect(Collectors.joining(","));
		System.out.println("String comma separated : "+commaSeparated);

		//Counting the strings
		long countingString = Stream.of("apple", "banana", "cherry").collect(Collectors.counting());
		System.out.println("Count of Strings : "+countingString);

		int totalSum = Stream.of(2,4,2,3,6).collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Total Sum : "+totalSum);

		//Find the average using Collectors.averagingInt()
		double averageOfNumbers = Stream.of(1, 2, 3, 4).collect(Collectors.averagingInt(Integer::intValue));
		System.out.println("Average of numbers : "+averageOfNumbers);
		
		//Summarizing the Numbers
		IntSummaryStatistics summarizingNumbers = Stream.of(1, 2, 3, 4).collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println("Summarizing the numbers : "+summarizingNumbers);
		
		//Group by length
		Map<Integer, List<String>> groupByLength = Stream.of("Apple","Mango", "Apple","Orange","Orange").collect(Collectors.groupingBy(String::length));
		System.out.println("Grouping by length : "+groupByLength);
		
		//Group by length and count how many words have that length.
		Map<Integer,Long> groupByLengthAndCount = Stream.of("Apple","Mango", "Apple","Orange","Orange")
				.collect(Collectors.groupingBy(String::length,Collectors.counting()));
		System.out.println("Grouping by length and count : "+groupByLengthAndCount);
		
		//Create a Map where key = string length, value = string itself.
		Map<Integer,String> mapWithKeyAndValueItself =Stream.of("apple", "banana","banana", "cherry").distinct().collect(Collectors.toMap(String::length,s->s,(a,b)->a+","+b));
		System.out.println("Key = string length, Value = string itself : "+mapWithKeyAndValueItself);
		
		//Remove the duplicates and print only the odd numbers from the list
		int[] array= {1,1,2,2,3,3,3,4,4,9,6,0};
		long summing = Arrays.stream(array).distinct().filter(s->s%2==1).sum();
		System.out.println("Summing only the odd numbers : "+summing);
	}

}
