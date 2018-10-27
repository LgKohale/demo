package com.cg.Ui;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Exception.BankException;

import com.cg.bean.BankingApp;
import com.cg.service.BankService;

public class Ui {
	
	static BankService service=null;
	StringBuffer sb = new StringBuffer();
	StringBuffer sbT = new StringBuffer();
	
	public static void main(String ar[]) throws BankException {
		
while(true) {
	System.out.println("===============================");
	System.out.println("===========Welcome=============");
	System.out.println("1.Create Account");
	System.out.println("2.Show Balance");
	System.out.println("3.Deposit Amount");
	System.out.println("4.Withdraw Amount");
	System.out.println("5.Fund Transfer");
	System.out.println("6.Print Transaction");
	System.out.println("7.Exit");
	System.out.println("===============================");
	System.out.println("Enter your Choice");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		service=new BankService();
		BankingApp bean=new BankingApp();
		
		switch (choice) {

		case 1:
			
			System.out.println("Enter your Name:");
			String custName;
			custName= sc.next();
			boolean validname=service.validName(custName);
			String vname;
			boolean validn;
			if(!validname){
				do{
					System.out.println("Enter name with Init-caps(ex:Tom): ");
					System.out.println("Enter your Name: ");
					vname= sc.next();
					validn = service.validName(vname);
				}while(!validn);
				bean.setCustName(vname);
			}
			else
				bean.setCustName(custName);	
			
			System.out.println("Enter your Address:");
			String address = sc.next();
			System.out.println("Enter your email id:");
			String emailid = sc.next();
			boolean isvalid = service.validEmail(emailid);
			boolean validid;
			String emailid1;
			if (!isvalid) {
				do {
					System.out.println("Type correct email Id");
					System.out.println("Enter your email id:");
					emailid1 = sc.next();
					validid = service.validEmail(emailid1);

				} while (!validid);
				bean.setEmailid(emailid1);
			}else
				bean.setEmailid(emailid);
			
			System.out.println("Enter your Aadhar Card number");
			String idProof = sc.next();
			boolean validac=service.validAdhar(idProof);
			boolean validaa;
			String proof;
			if(!validac){
				do{
					System.out.println("Enter 12 digit Aadhar card number: ");
					System.out.println("Enter the Id number " );
					proof=sc.next();
					validaa= service.validAdhar(proof);
				}while(!validaa);
				bean.setIdProof(proof);
			}else
				bean.setIdProof(idProof);

			System.out.println("Enter mobile number");
			String custMobNo = sc.next();
			boolean validm= service.validMobileaNo(custMobNo);
			boolean Validm;
			String mob;
			if(!validm){
				do{
					System.out.println("Enter correct 10 digit mobile number: ");
					mob=sc.next();
					Validm= service.validMobileaNo(mob);
				}while(!Validm);
				bean.setCustMobNo(mob);
			}else
				bean.setCustMobNo(custMobNo);
			

			System.out.println("Enter your age:");
			int custAge = sc.nextInt();
			boolean validage= service.validAge(custAge);
			boolean Validage;
			int age;
			if(!validage){
				do{
					System.out.println("Enter valid age :");
					age=sc.nextInt();
					Validage=service.validAge(age);
				}while(!Validage);
				bean.setCustAge(age);
			}else
				bean.setCustAge(custAge);
			
			
			System.out.println("Enter minimum balance amount you wish to keep");
			int balance = sc.nextInt();
			
			bean.setBalance(balance);
			bean.setAddress(address);
			
			Random rd1 = new Random();
			int accountNo = 1000000 + rd1.nextInt(900000);
			bean.setAccountNo(accountNo);
			Random rd2 = new Random();
			int accPin = 1000 + rd2.nextInt(9000);
			bean.setAccPin(accPin);
			boolean isAdded=service.addCustomer(bean);
			if(isAdded){
				System.out.println("YOUR ACCOUNT CREATED SUCCESSFULLY");
			}
			else{
				try{
					throw new  BankException("ACCOUNT NOT ADDED..");
				} catch (BankException e) {
				//System.out.println("ACCOUNT NOT ADDED..");
			}
			}
			System.out.println("===============================");
			break;
			
	//-------------------------------------------------------------------------------------------		
			
		case 2:
			/*System.out.println("in 2");
			Map<Integer, BankingApp> ll=service.getAll();
			ll.values().stream().forEach(System.out::println);*/
			System.out.println("Enter your Account no.:");
			int acc = sc.nextInt();
			int apin=0;
			System.out.println("Enter your Account Pin.:");
			 try {
				 apin = sc.nextInt();
		        } catch (InputMismatchException e) {
		            System.out.print("Invalid character entered, bye bye...");
		        }
			

			BankingApp cust = service.showBalance(acc, apin);
			//boolean cust= service.displayCustomer(acc);
			System.out.println("Your Account Balance is = " + cust.getBalance());
			System.out.println("===============================");	
			break;
	
//-----------------------------------------------------------------------------
		case 3:
			System.out.println("Enter your account no.:");
			int acc1 = sc.nextInt();
			System.out.println("Enter your Account Pin.:");
			int apin1 = sc.nextInt();
			System.out.println("Enter the deposit amount:");
			int deposit = sc.nextInt();

			BankingApp customer = service.depositAmount(acc1,apin1, deposit);
			System.out.println("your balance is now: ");
			System.out.println(customer.getBalance());
			service.printTransactions(customer);
			System.out.println("===============================");
			break;
			
//--------------------------------------------------------------------------------------------
			
		case 4:
			System.out.println("Enter your account no.:");
			int acc2 = sc.nextInt();
			System.out.println("Enter your Account Pin.:");
			int apin2 = sc.nextInt();
			System.out.println("Enter the withdraw amount:");
			int withdraw = sc.nextInt();

			BankingApp b1 = service.withdrawAmount(acc2,apin2, withdraw);
			System.out.println("your balance is now: ");
			System.out.println(b1.getBalance());
			service.printTransactions(b1);
			System.out.println("===============================");
			
			break;
//--------------------------------------------------------------------------------------------
			
		case 5:
			System.out.println("Enter your account no.:");
			int acc3 = sc.nextInt();
			System.out.println("Enter your Account Pin.:");
			int apin3 = sc.nextInt();
			System.out.println("Enter the account to transfer amount:");
			int acc4 = sc.nextInt();
			System.out.println("Enter the amount to transfer:");
			int amount = sc.nextInt();

			BankingApp b2 = service.FundTransfer(acc3,apin3, acc4, amount);
			
			System.out.println("The balance of account  "+ b2.getAccountNo() + " is : "+ b2.getBalance());
			
			if (b2!=null)
			{
				service.printTransactions(b2);
				
				BankingApp aa = service.showBalance(acc3, apin3);
				service.printTransactions(aa);
				
			}
			System.out.println("===============================");
			break;

	//-------------------------------------------------------------------
		case 6:
			
			System.out.println("Enter your account number");
			int accnumt = sc.nextInt();
			System.out.println("Enter your Account Pin.:");
			int apin4 = sc.nextInt();
			
			BankingApp b3= service.printTrans(accnumt);
			
			System.out.println("===============================");
			break;
			
		case 7:
			System.exit(0);
			break;

		default:
			break;
		}
	}

	}
}
