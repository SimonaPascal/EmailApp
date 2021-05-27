package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String email;
	private String companySuffix = "company.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();

		
		this.password = generateRandomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

	}
	
	private String setDepartment() {
		System.out.println("New worker: " + firstName + "DEPARTMENT CODES: \n1 for Sales \n2 for Development\n3 for Accounting \n0 for none \nENTER THE DEPARTMENT CODE: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) return "sales";
		else if(depChoice == 2) return "development";
		else if(depChoice == 3) return "accounting";
		else return "";
		
	}
	
	private String generateRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i = 0 ; i < length; i++) {
			int random = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);
		}
		
		return new String(password);
	}
	
	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}
	
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity;  
	}

}
