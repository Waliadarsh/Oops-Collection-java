package sdbms;

import java.util.Scanner;

import customException.InvalidChoiceException;

public class SolutionStudent {
	
	public static void main(String[] args) {
		
		Scanner ip=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImpl();
		while(true) {
			System.out.println("-----Welcome to Student DB Project-----");
			System.out.println("=========================================\n");
			System.out.println("1.addStudent\n2.displayStudent\n3.displayAllStudent\n4.removeStudent"
					+ "\n5.removeAllStudent\n6.updateStudent\n7.countStudent\n8.sortStudent"
					+ "\n9.getStudentWithHighestMarks\n10.getStudentWithLowestMarks\n11.Exit\nSelect your choice: ");
			String choice=ip.nextLine();
			switch(choice) {
			
			case "1": 
				sms.addStudent();
				break;
			case "2": 
				sms.displayStudent();
				break;
			case "3": 
				sms.displayAllStudent();
				break;
			case "4": 
				sms.removeStudent();
				break;
			case "5": 
				sms.removeAllStudent();
				break;
			case "6": 
				sms.updateStudent();
				break;
			case "7": 
				sms.countStudent();
				break;
			case "8": 
				sms.sortStudent();
				break;
			case "9": 
				sms.getStudentWithHighestMarks();
				break;
			case "10": 
				sms.getStudentWithLowestMarks();
				break;
			case "11": 
				System.out.println("Thnak you!!!");	
				System.exit(0);		
			default: //customException	--> InvalidChoiceException
				try {
					throw new InvalidChoiceException("Invalid Choice!!");
				}
				catch(InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}
				
			}
			System.out.println("==========================");
		}

	}

}











