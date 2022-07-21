package com.stocker.gl;

import java.util.List;

public interface CompanyStockersDetails {

	public void addSharePrice(double currentStockPrice);
	public boolean checkSharePrice(double currentStockPrice,int numOfCompany);
	public List<Double> companyStockInAscendingOrder();
	public List<Double> companyStockInDescendingOrder();
	public int getDeclineCount();
	public void searchStockPrice(Double stockPrice);
}
