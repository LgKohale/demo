package com.cg.bean;

public class BankingApp {
	String custName;
	String address;
	String emailid;
	String idProof;
	String custMobNo;
	int custAge;
	int accountNo;
	int accPin;
	int balance;
	//StringBuffer Transaction;
	
	StringBuffer sb = new StringBuffer();
	public StringBuffer getSb() {
		return sb;
	}
	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}
	/*public StringBuffer getTransaction() {
		return Transaction;
	}
	public void setTransaction(StringBuffer transction) {
		Transaction = transction;
	}*/
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getAccPin() {
		return accPin;
	}
	public void setAccPin(int accPin) {
		this.accPin = accPin;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String vname) {
		this.custName = vname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String proof) {
		this.idProof = proof;
	}
	public String getCustMobNo() {
		return custMobNo;
	}
	public void setCustMobNo(String custMobNo) {
		this.custMobNo = custMobNo;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	@Override
	public String toString() {
		return "Customer: "+ "\n" + "[custName=" + custName + ", address=" + address+"\n"
				+ ", emailid=" + emailid + ", idProof=" + idProof+"\n"
				+ ", custMobNo=" + custMobNo + ", custAge=" + custAge+"\n"
				+ ", accountNo=" + accountNo + ", accPin=" + accPin+"\n"
				+ ", balance=" + balance + ", ]";
	}
	
	
	
	
	

}
