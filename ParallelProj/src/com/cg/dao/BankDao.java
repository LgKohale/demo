package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.bean.BankingApp;

public class BankDao implements IBankDao {

static Map<Integer, BankingApp> empMap = new HashMap<Integer, BankingApp>();
Map<Integer, StringBuffer> transaction = new HashMap<Integer, StringBuffer>();
StringBuffer sb= new StringBuffer();


	public boolean addCustomer(BankingApp bean) {
		boolean isAdded=false;
		//System.out.println("no data "+empMap);
			empMap.put(bean.getAccountNo(),bean);
			System.out.println("After adding: "+ "\n"+empMap);
			
			isAdded=true;
		return isAdded;
	}
	public Map<Integer,BankingApp> getAll(){
		System.out.println("in get all "+empMap);
		return empMap;
	}
	
	public BankingApp showBalance(int acc, int apin) {
		BankingApp bapp = null;
		//System.out.println(empMap);
		for (BankingApp bankingApp : empMap.values()) {
			if (bankingApp.getAccountNo() == acc && bankingApp.getAccPin() == apin) 
			{
				System.out.println(bankingApp);
				bapp=bankingApp;
				//System.out.println("Value= " + bankingApp.getBalance());
				
			}
		}
		return bapp;
	}

	public BankingApp depositAmount(int acc1,int apin1, int deposit) {
		BankingApp cust = null;

		for (BankingApp bapp : empMap.values()) {
			if (bapp.getAccountNo() == acc1 && bapp.getAccPin() == apin1)
			{
				int amt = bapp.getBalance();

				amt = amt + deposit;
				bapp.setBalance(amt);
				
				cust = bapp;
			}
		}

		return cust;
	}

	public BankingApp withdrawAmount(int acc2,int apin2 , int withdraw) {
		BankingApp cust = null;

		for (BankingApp custList : empMap.values()) {
			if (custList.getAccountNo() == acc2 && custList.getAccPin() == apin2) {
				int amt = custList.getBalance();
				if (withdraw < amt) {
					amt = amt - withdraw;
					custList.setBalance(amt);
					cust = custList;

				}

			}
		}
		return cust;

	}

	public BankingApp FundTransfer(int acc3,int apin3, int acc4, int amount) {
		BankingApp cust = null;

		for (BankingApp b1 : empMap.values()) {
			
			if (b1.getAccountNo() == acc3 && b1.getAccPin() == apin3)

			{
				double amt = b1.getBalance();
				if (amount < amt) {
					System.out.println("After transfer : ");
					int from = b1.getBalance();
					from = from - amount;
					
					for (BankingApp b2 : empMap.values()) {
						if (empMap.containsKey(acc4)) {
							int to = b2.getBalance();
							to = to + amount;
							b2.setBalance(to);
							sb.append("Withdrawal of  " + b2.getBalance());
							b1.setBalance(from);
							cust = b2;

						} else {
							System.out.println("ACCOUNT DOSEN'T EXIST..");
						}
					}

				}
			}
		}
		return cust;
	}
	public BankingApp printTrans(int accnumt) {
		System.out.println("sdfsdfsdfsdfs");
		System.out.println(transaction);
		if (transaction.containsKey(accnumt)) {
			System.out.println("ggggg");
			   Object value = transaction.get(accnumt);
			   System.out.println("ggg" + value);
			 System.out.println("Account number : " + accnumt +"\n"+ value + "\n");
			 }
		return null;
		
	}
	
	public BankingApp printTransactions(BankingApp ac)
	{
		BankingApp cust = null;
		int a = ac.getAccountNo();
		StringBuffer s = new StringBuffer();
		s = ac.getSb();
		s.append("balance is now ");
		s.append(ac.getBalance());
		ac.setSb(s);
		transaction.put(a, s);
		System.out.println("a"+ a +"s"+s);
		System.out.println(transaction);
		System.out.println("-----------");
		System.out.println("inside print transaction");
		for(StringBuffer transaction1 : transaction.values())
		{
			
			transaction.entrySet().stream().forEach(System.out::println);
			System.out.println("aaaaaaa");
			System.out.println(transaction);
		}
		return cust;
	}
	
	
	
	
	
	

}
