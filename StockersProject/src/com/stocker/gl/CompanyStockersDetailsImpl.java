package com.stocker.gl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyStockersDetailsImpl implements CompanyStockersDetails{

	boolean chekcSharePrice = true;
	List<Double> list = new ArrayList<Double>();
	int roseCount = 0,declineCount=0 ;
	
	public void addSharePrice(double currentStockPrice) {
		list.add(currentStockPrice);
	}
	
	public boolean checkSharePrice(double currentStockPrice,int numOfCompany) { // numOfCompany = 1 , currentStockPrice
		
		if(currentStockPrice > list.get(0)) {				
			chekcSharePrice = true;
		}else if(numOfCompany == 1 ){
			chekcSharePrice = true;
		}else {
			chekcSharePrice = false;
		}
			
		return chekcSharePrice;
	}
	
	public List<Double> companyStockInAscendingOrder() {
		Collections.sort(list);	
		return list;
	}
	
	public List<Double> companyStockInDescendingOrder() {
		Collections.sort(list,Collections.reverseOrder());
		return list;
	}
	
	public int getRoseCount() {
		double firstElement = list.get(0);//10.25
		//10.25 200.02,85.25
		for(int i = 1; i <list.size() ; i++) {
			if(firstElement > list.get(i)) {
				roseCount++;
			}
		}
		return roseCount;
	}
	
	public int getDeclineCount() {
		double firstElement = list.get(0);
		
		for(int i = 1; i <list.size() ; i++) {
			if(firstElement < list.get(i)) {
				declineCount++;
			}
		}
		return declineCount;
	}
	
	public void searchStockPrice(Double stockPrice) {
		
		if(list.contains(stockPrice)) {
			System.out.println("Stock of Value "+stockPrice+" is present");
		}else {
			System.out.println("Value not found");
		}
		
	}
}
