package com.stocker.gl;

import java.util.List;
import java.util.Scanner;

public class StockerCompanyDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CompanyStockersDetailsImpl companyDetails = new CompanyStockersDetailsImpl();
		boolean chekcSharePrice ;
		double currentStockPrice = 0 ; 
		System.out.println("enter the no of companies");
		int numOfCompany = sc.nextInt();
		
		for(int i =1 ; i<=numOfCompany ; i++) {
			System.out.println("Enter current stock price of the company "+i);
			currentStockPrice = sc.nextDouble();
			companyDetails.addSharePrice(currentStockPrice);
			
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			chekcSharePrice = companyDetails.checkSharePrice(currentStockPrice,i);
			System.out.println(chekcSharePrice);
			
		}
		
		int choice =0;		
		do {
			System.out.println("\n----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("\t1. Display the companies stock prices in ascending order"
					+ "\n\t2. Display the companies stock prices in descending order"
					+ "\n\t3. Display the total no of companies for which stock prices rose today"
					+ "\n\t4. Display the total no of companies for which stock prices declined today"
					+ "\n\t5. Search a specific stock price"
					+ "\n\t6. press 0 to exit");
			System.out.println("----------------------------------------------");
			
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					System.out.println("Stock prices in ascending order are:");
					List ascendingOrderList = companyDetails.companyStockInAscendingOrder();
					ascendingOrderList.forEach(n->System.out.print(" "+n));
					break;
				case 2 :
					System.out.println("Stock prices in descending order are :");
					List<Double> descendingOrderList = companyDetails.companyStockInDescendingOrder();
					descendingOrderList.forEach(n->System.out.print(" "+n));
					break;
				case 3 :
					System.out.println("Display the total no of companies for which stock prices rose today :");
					int roseCount = companyDetails.getRoseCount();
					System.out.println(roseCount);
					break;
				case 4 :
					System.out.println("Display the total no of companies for which stock prices declined today :");
					int declineCount = companyDetails.getDeclineCount();
					System.out.println(declineCount);
					break;
				case 5 :
					System.out.println("enter the key value :");
					Double key = sc.nextDouble();
					companyDetails.searchStockPrice(key);
					break;
				case 6 :
					System.out.println("press 0 to exit :");
					int statusCode = sc.nextInt();
					System.out.println("Exited successfully");
					System.exit(statusCode);
					
					break;
			}
			
		}while(choice != 7);		

	}

}
