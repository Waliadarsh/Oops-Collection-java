package com.ty;

import java.util.Scanner;
class Hotel 
{
	static Scanner sc=new Scanner(System.in);
	static int total_price;
	static int total_price1;
	public static void main(String[] args) 
	{

		
		while(true)
		{
			System.out.println("===================================");

			System.out.println("WELCOME TO BECA CHILLED OUT RESTAURANT");

			System.out.println("====================================");
			//char grade='5';
			System.out.println("Select the number of your choice\n 1. veg \n 2. non-veg \n 3. exit");

			int n=sc.nextInt();

			switch(n)
			{

			case 1: veg();
			break;

			case 2: nonveg();
			break;
			
			case 3: System.out.println("Thank you visit again");
					System.exit(0);
			
			default: System.out.println("Enter correct option");
			}
		}
		
	}




	static void veg()
	{
		
		System.out.println("Your choice is Veg");
		System.out.println("============================");
		String arr[]=new String[5];
		int pri[]=new int[5];
		System.out.println("Thank you for selecting veg");
		System.out.println("Here is the list of items for Veg");


		arr[0]="Masala Dosa";
		arr[1]="Idly";
		arr[2]="Puri";
		arr[3]="Set Dosa";
		arr[4]="Vada";

		pri[0]=30;
		pri[1]=10;
		pri[2]=30;
		pri[3]=30;
		pri[4]=10; 

		for (int i=0;i<5;i++)
		{
			System.out.println(i+"\t"+arr[i]+"->"+pri[i]);
		}


		int item_index=sc.nextInt();
		System.out.println("You have selected " + arr[item_index]);


		System.out.println("enter the quantity");
		int quantity=sc.nextInt();
		total_price =total_price+ pri[item_index]*quantity;
		System.out.println("The amount is " + total_price +"rs");
		System.out.println("Do you want to order anything select \n 1. veg \n 2. nonveg\n 3. Generate Bill");
		int y=sc.nextInt();
		switch(y)
		{
		case 1: veg();
		break;

		case 2: nonveg();
		break;

		case 3: totalBill(total_price,total_price1);
		break;

		}
	}


	static void nonveg()
	{
		System.out.println("Your choice is Non Veg");
		System.out.println("============================");
		String arr1[]=new String[5];
		int pri1[]=new int[5];
		System.out.println("Thank you for selecting Non Veg");
		System.out.println("Here is the list of items for Non Veg");


		arr1[0]="Chilly Chicken";
		arr1[1]="Kabab";
		arr1[2]="Chicken 65";
		arr1[3]="lollipop";
		arr1[4]="Tandoori";

		pri1[0]=250;
		pri1[1]=150;
		pri1[2]=275;
		pri1[3]=300;
		pri1[4]=100; 

		for (int i=0;i<5;i++)
		{
			System.out.println(i+"\t"+arr1[i]+"->"+pri1[i]);
		}

		int item_index1=sc.nextInt();
		System.out.println("You have selected " + arr1[item_index1]);


		System.out.println("enter the quantity");
		int quantity1=sc.nextInt();
		total_price1 = total_price1+pri1[item_index1]*quantity1;
		System.out.println("The amount is " + total_price1 +"rs");
		System.out.println("Do you want to order anything select \n 1. veg \n 2. nonveg \n 3. Generate Bill");
		int y=sc.nextInt();
		switch(y)
		{
		case 1: veg();
		break;

		case 2: nonveg();
		break;
		case 3: totalBill(total_price,total_price1);
		break;

		}

	}

	static void totalBill(int a, int b)
	{
		int grand_total=a+b;
		System.out.println("the total bill  is " + grand_total);

		/*int grand_total=total_price+total_price1;
     System.out.println("the grand total is " + grand_total);*/
	}
}
