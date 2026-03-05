package com.java8;

class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String dept;

    // Constructor
    public Employee(int id, String name, int age, double salary, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dept = dept;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDept() { return dept; }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", dept=" + dept + "]";
	}

   
}

