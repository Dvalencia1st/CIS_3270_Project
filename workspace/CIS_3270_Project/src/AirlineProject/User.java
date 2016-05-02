package AirlineProject;

public class User extends Person {
	Boolean admin;
	String book;

	public User(String Fname, String Lname, String EmailAddress, String Questions, String Answer, String Address,
			String Phone, String UserName, String Password, Boolean admin1, String SSN) {
		super(Fname, Lname, EmailAddress, Questions, Answer, Address, Phone, UserName, Password, SSN);
		admin = admin1;
	}

	public void print() {
		System.out.println(Fname);
		System.out.println(Lname);
		System.out.println(EmailAddress);
		System.out.println(Questions);
		System.out.println(Address);
		System.out.println(Phone);
		System.out.println(SSN);
	}
}



