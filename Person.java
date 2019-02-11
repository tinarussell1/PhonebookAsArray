package Phonebook;

public class Person implements Comparable<Person>  {
	//public class Person implements Comparable<Person>  {
	private String firstName;
	private String lastName;
	private String telephone;
	private Address address =new Address();
		
	public Person() {
	}
	
	public Person(String lastName, String firstName, String telephone, Address address) {
			this.lastName = lastName;
			this.firstName = firstName;
			this.telephone = telephone;
			this.address = address;
		}
	
	
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Address getAddress() {
		return this.address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
		

		@Override
		public String toString() {
			return  firstName + " " + lastName + ", " 
					+ "(" + telephone.substring(0,3) 
					+ ")" + telephone.substring(3,6) 
					+ "-" + telephone.substring(6) 
					+  ", " + address;
		}

		@Override
		public int compareTo(Person o) {
			return this.lastName.compareTo(o.lastName);
		}
		
		
		
}
