package Question2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter D.O.B(DD-MM-YYYY): ");
		String[] dob = sc.nextLine().split("-");
		Date date = new Date(Integer.parseInt(dob[0]),Integer.parseInt(dob[1]),Integer.parseInt(dob[2]));
		
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter NIC: ");
		String nic = sc.nextLine();
		
		Owner owner = new Owner(name,date,nic);
		
		System.out.println("Enter balance: ");
		float balance = sc.nextFloat();
		
		System.out.println("Enter Number:");
		String number = sc.nextLine();
		
		Account account;
		
		System.out.println("Select account type: \n1. Savings \n2. Current");
		int in = sc.nextInt();
		if(in == 1) {
			account = new SavingsAccount(owner, balance, number, 3);
		}else if(in == 2) {
			account = new CurrentAccount(owner, balance, number, 5000);
		}else {
			account = new SavingsAccount();
			System.out.println("Invalid input!");}
		account.print();
	}
}
