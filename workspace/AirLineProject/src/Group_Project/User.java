package Group_Project;



public class User extends Person {
Boolean admin;
String book;

public User(String Fname, String Lname, String Email, String Questions, String Answer, String Address,
		String Phone, String UserName, String Password, Boolean ad, String book, String SSN) {
	super(Fname, Lname, Email, Questions, Answer, Address, Phone, UserName, Password, SSN);
	admin = ad;
}

public void print() {
	System.out.println(Fname);
	System.out.println(Lname);
	System.out.println(Email);
	System.out.println(Questions);
	System.out.println(Address);
	System.out.println(Phone);
	System.out.println(SSN);
}
}

