package sdbms;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.InvalidChoiceException;
import customException.StudentNotFoundException;
import customSorting.SortStudentByAge;
import customSorting.SortStudentById;
import customSorting.SortStudentByMarks;
import customSorting.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem {

	Scanner ip=new Scanner(System.in);
	
	Map<String,Student> db=new LinkedHashMap<String,Student>();


	@Override
	public void addStudent() {
		System.out.println("Enter the Student age: ");
		int age=ip.nextInt();								//accept age,name,marks.
		ip.nextLine();
		System.out.println("Enter the Student name: ");
		String name=ip.next();	//
		ip.nextLine();
		System.out.println("Enter the Student marks: ");
		int marks=ip.nextInt();

		Student s1= new Student(age,name,marks);

		db.put(s1.getId(), s1);
		System.out.println("Student record is inserted successfully");
		System.out.println("Student Id is: "+s1.getId());
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id: ");	
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {			//containsKey() is method of MAP interface with accept the 
			Student std=db.get(id);			//key input and check that key is present in given Map(boolean o/p)
			System.out.println("---------------------");
			System.out.println("Id: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());
		}
		else {
			try {
				String message="Student with the Id: "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student Details are as follows: ");
			System.out.println("--------------------------------");
			Set<String> keys=db.keySet();
			for(String key: keys) {
				Student value=db.get(key);
				System.out.println(value);		//System.out.println(db.get(key));  
			}
			System.out.println("--------------------------------");
		}
		else {
			//Create a Exception using name
			try {
				String message="Student Database is Empty, Norting to Display";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter the student Id: ");
		String id=ip.next();
		ip.nextLine();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student record found!");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record deleted successfully !");
		}
		else{
			try {
				String message="Student with id "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student Records Avaliable: "+db.size());
			db.clear();
			System.out.println("All Student Records Deleted Successfully!");
			System.out.println("Student Records Avaliable: "+db.size());
		}
		else {
			try {
				String message="Student Databasse is Empty, Northing to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter the student Id: ");
		String id=ip.next();
		ip.nextLine();
		id=id.toUpperCase();
		if(db.containsKey(id)) {

			Student std=db.get(id);
			System.out.println("1.Update Age:\n2.Update Name:\n3.Update Marks\nENter your choice");
			int choice=ip.nextInt();
			switch(choice) {
			case 1: 
				ip.nextLine();
				System.out.println("Enter Age: ");
				int age=ip.nextInt();
				std.setAge(age);
				System.out.println("Age updated successfully");
				break;

			case 2: 
				ip.nextLine();
				System.out.println("Enter Name: ");
				String name=ip.nextLine();
				std.setName(name);
				System.out.println("Name updated successfully");
				break;


			case 3: 
				ip.nextLine();
				System.out.println("Enter Marks: ");
				int marks=ip.nextInt();
				ip.nextLine();
				std.setMarks(marks);
				System.out.println("Marks updated successfully");
				break;

			default: 
				try {
					String message="Invalid choice, kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}

			}

		}
		else{
			try {
				String messgae="Student with id "+id+" is not found";
				throw new StudentNotFoundException(messgae);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudent() {
		System.out.println("No of Student Records: "+db.size());

	}

	@Override
	public void sortStudent() {
		/*
		 Map into Set -->keySet() ->keys
		 list list=new AL(); ->Student Object ->Generics
		 for each loop ->Traverse keys-->
		 get the values (Student object) & add it into AL
		 Display sortby: 1:Sort by id 2: by name 3: by Age 4: Marks
		 switch -->collection.sort(list,new SortStudentById())
		 traverse it using fro each loop 		
		 */
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key: keys) {
				list.add(db.get(key));
			}
			System.out.println("1:Sort by Id\n2:Sort by Age\n3:Sort by Name\n4:Sort by Marks\nEnter your choice");
			int choice=ip.nextInt();
			ip.nextLine();
			switch(choice) {
			case 1: 
				Collections.sort(list,new SortStudentById());
				display(list);
				break;
			case 2: 
				Collections.sort(list,new SortStudentByAge());
				display(list);
				break;
			case 3: 
				Collections.sort(list,new SortStudentByName());
				display(list);
				break;
			case 4: 
				Collections.sort(list,new SortStudentByMarks());
				display(list);
				break;
			default: 
				try {
					String message="Invalid choice, kindly enter valid choice";
					throw new StudentNotFoundException(message);
				}
				catch(StudentNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="No sufficient Student Record to compare";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private void display(List<Student> list) {
		for(Student ele: list) {
			System.out.println(ele);
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key: keys) {
				list.add(db.get(key));
			}

			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(db.size()-1)); //getting student object with highest marks

		}
		else {
			try {
				String message="No sufficient Student Record to compare";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key: keys) {
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(0));
		}
		else {
			try {
				String message="No sufficient Student Record to compare";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
