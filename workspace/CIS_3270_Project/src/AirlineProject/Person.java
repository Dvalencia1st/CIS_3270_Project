package AirlineProject;

public abstract class Person {
	String Fname, Lname, EmailAddress, Questions, Answer, Address, Phone, UserName, Password, SSN;

	public Person() {

	}

	public Person(String Fname, String Lname, String EmailAddress, String Questions, String Answer, String Address,
			String Phone, String UserName, String Password, String SSN) {
		this.Answer = Answer;
		this.Fname = Fname;
		this.Lname = Lname;
		this.EmailAddress = EmailAddress;
		this.Questions = Questions;
		this.Address = Address;
		this.Phone = Phone;
		this.UserName = UserName;
		this.Password = Password;
		this.SSN = SSN;

	}

}
