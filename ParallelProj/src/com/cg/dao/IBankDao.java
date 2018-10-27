package com.cg.dao;

import java.util.Map;

import com.cg.bean.BankingApp;

public interface IBankDao {
	
	public boolean addCustomer(BankingApp bean);
	public Map<Integer,BankingApp> getAll();
	public BankingApp showBalance(int acc, int apin);
	public BankingApp depositAmount(int acc1,int apin1, int deposit);
	public BankingApp withdrawAmount(int acc2,int apin2 , int withdraw);
	public BankingApp FundTransfer(int acc3,int apin3, int acc4, int amount);
	//public BankingApp printTrans(int accnumt);
	
}
