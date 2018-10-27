package com.cg.service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.bean.BankingApp;
import com.cg.dao.BankDao;

public class BankService implements IBankService {
	
	BankDao dao= new BankDao();
	
	public boolean addCustomer(BankingApp bean) {
		// TODO Auto-generated method stub
		//dao=new BankDao();
		return dao.addCustomer(bean);
	}
	public Map<Integer,BankingApp> getAll(){
		dao=new BankDao();
		return dao.getAll();
	}
	
	public BankingApp showBalance(int acc, int apin) {
		// TODO Auto-generated method stub
		return dao.showBalance(acc,apin);
	}

	public BankingApp depositAmount(int acc1, int apin1, int deposit) {
		// TODO Auto-generated method stub
		return dao.depositAmount(acc1,apin1, deposit);
	}

	public BankingApp withdrawAmount(int acc2,int apin2, int withdraw) {
		// TODO Auto-generated method stub
		return dao.withdrawAmount(acc2,apin2 ,withdraw);
	}

	public BankingApp FundTransfer(int acc3,int apin3, int acc4, int amount) {
		// TODO Auto-generated method stub
		return dao.FundTransfer(acc3,apin3,  acc4, amount);
	}

	public BankingApp printTransactions(BankingApp ac)
	{
		return dao.printTransactions(ac);
	}
	public boolean validName(String custName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = custName.matches("[A-Z][a-zA-Z]*");

		return flag;
	}

	public boolean validEmail(String emailid) {
		// TODO Auto-generated method stub
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String email1 = emailid;
		Boolean b = email1.matches(EMAIL_REGEX);
		if (b) {
			return b;
		} else {
			return false;
		}
	}

	public boolean validAdhar(String idProof) {
		// TODO Auto-generated method stub

		Pattern aadharPattern = Pattern.compile("\\d{12}");
		boolean isValidAadhar = aadharPattern.matcher(idProof).matches();
		return isValidAadhar;

	}

	/*
	 * @Override public boolean (int accountNo, BankingApp bean) { // TODO
	 * Auto-generated method stub return dao.addCustomer(accountNo,bean); }
	 */

	
	public boolean validMobileaNo(String custMobNo) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[7-9][0-9]{9}");

		Matcher m = p.matcher(custMobNo);
		Boolean b = (m.find() && m.group().equals(custMobNo));
		if (b) {
			return b;
		} else {
			return false;
		}
	}

	public boolean validAge(int age) {
		// TODO Auto-generated method stub
		if (age > 0) {
			return true;
		} else {
			return false;
		}
	}
	public BankingApp printTrans(int accnumt) {
		// TODO Auto-generated method stub
		return dao.printTrans(accnumt);
	}
	
}

