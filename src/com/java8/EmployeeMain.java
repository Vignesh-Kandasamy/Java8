package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EmployeeMain {
	
	public static void main(String args[])
	{
		List<Employee> employees = Arrays.asList(
	            new Employee(1, "Alice", 30, 50000, "IT"),
	            new Employee(2, "Bob", 28, 60000, "HR"),
	            new Employee(3, "Charlie", 32, 70000, "IT"),
	            new Employee(4, "David", 25, 45000, "HR"),
	            new Employee(5, "Eve", 29, 80000, "Finance")
	        );
		
		Map<String,Optional<Employee>> e= employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		System.out.println(e);
		
		//Predicate eg
		Predicate<Integer> p = i->i>10;
		System.out.println(p.test(100));
		
		Supplier<Date> s = ()->new Date();
		System.out.println(s.get());
		
		Consumer<String> c = a->System.out.println(a);
		c.accept("hello");
		
		Function<String,Integer> f = i->i.length();
		System.out.println(f.apply("Hello"));
		
		List<Employee> employee = Arrays.asList(new Employee(1,"Vignesh",23,15000,"mech"),
				new Employee(2,"Saravan",24,15000,"mech"),
				new Employee(3,"Ragu",12,16000,"mech"),
				new Employee(1,"Vignesh",23,15000,"mech"));
		
		employee.stream().filter(r->r.getAge()>20).forEach(System.out::println);
		
		System.out.println();
		
		Set<String> set= new HashSet<>();
		employee.stream().filter(i->set.add(i.getName())).forEach(System.out::println);
		
		//To filter the employees with mech department and also summing the salary based on dept
		Map<String, Double> emp = employee.stream().filter(a->"mech".equals(a.getDept()))
				.collect(Collectors.groupingBy(Employee::getDept,Collectors.summingDouble(Employee::getSalary)));
		System.out.println("Output: "+emp);

	}

}
