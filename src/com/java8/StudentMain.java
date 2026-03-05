package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StudentMain {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(
				new Student(1,"Vignesh",23,3,86),
				new Student(2,"Ram",13,2,57),
				new Student(3,"Samuel",25,5,100),
				new Student(4,"Ram",25,5,91),
				new Student(5,"Kamal",13,2,57));

		//Find the highest performed class
		Map<Integer, Integer> sumofMarks =students.stream()
				.collect(Collectors.groupingBy(Student::getstudentsClass,Collectors.summingInt(Student::getMarks)));
		Entry<Integer,Integer> highestmark = sumofMarks.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("Summing the marks based on class : "+highestmark.getValue());

	}

}
