/*
 * Ajay Gurdat
 * 1/11/2016
 * Student Information Organizer and Handler
 * A program that takes information of students from a user, saves it and organizes them into an array list.
 */
public class Student implements Comparable {

	private String firstName, lastName, streetName, city, province, postalCode, phoneNumber, birthdate;
	private long studentNumber;
	private String errorMsg = "Wrong Format! Please relaunch the program";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() throws InvalidInputException {
		int postalCodeLength = postalCode.length();
		if (postalCodeLength == 7){
			return postalCode;
		}
		else
			throw new InvalidInputException(errorMsg);
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() throws InvalidInputException {
		int phoneNumberLenght = phoneNumber.length();
		if (phoneNumberLenght == 12){
			return phoneNumber;
		}
		else
			throw new InvalidInputException(errorMsg);
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthdate() throws InvalidInputException {
		int birthdayLenght = birthdate.length();
		if (birthdayLenght == 10){
			return birthdate;
		}
		else
			throw new InvalidInputException(errorMsg);
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public boolean equals(Student s){
		if (this.getStudentNumber() == s.getStudentNumber());
		return true;	
	}

	@Override
	public int compareTo(Object o) {

		return 0;

	}
}