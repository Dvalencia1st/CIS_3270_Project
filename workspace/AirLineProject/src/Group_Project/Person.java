package Group_Project;


public abstract class Person {
	String Fname, Lname;
	String Email;
	String Questions;
	String Answer;
	String Address;
	String Phone;
	String UserName;
	String Password;
	String SSN;

	public Person() {

	}

	public Person(String Fname, String Lname, String Email, String Questions, 
			String Answer, String Address, String Phone, String UserName, 
			String Password, String SSN) {
		this.Answer = Answer;
		this.Fname = Fname;
		this.Lname = Lname;
		this.Email = Email;
		this.Questions = Questions;
		this.Address = Address;
		this.Phone = Phone;
		this.UserName = UserName;
		this.Password = Password;
		this.SSN = SSN;

	}
}