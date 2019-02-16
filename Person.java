package phonebook;

public class Person implements Comparable<Person>  {
	//public class Person implements Comparable<Person>  {
	private String firstName;
	private String lastName;
	private String telephone;
	private Address address ;  //=new Address();
		
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
		
		public static Person[] addRecord(String[] arr, Person[] originalArray) {
			Address a = new Address();
			Person p = new Person();

	 		//first, fill a Person address from simple array	       
	   		p.setAddress(a);
			p.getAddress().setStreet(arr[3]);
	   		p.getAddress().setCity(arr[4]);
	   		p.getAddress().setState(arr[5]);
	   		p.getAddress().setZip(arr[6]);

	   		p.setFirstName(arr[0]);
	   		p.setLastName(arr[1]);       		
			//check phone number length of 10 before saving
			String phone = PhonebookAsArray.checkPhoneLength(arr[2]);
			p.setTelephone(phone);
			
			if (originalArray[0] == null)  {
			//Cant do isEmpty with array/// if (originalArray.isEmpty()) {
				Person[] newArray = new Person[originalArray.length];	

				newArray[0] = p;	
				//System.out.println("after first in newArray");			
				System.out.println("Successfully Added: " + newArray[0]);
				return newArray;
			} else {
				Person[] newArray = new Person[originalArray.length+1];
				
				newArray[originalArray.length] = p;
				System.out.println("Successfully Added: " + newArray[originalArray.length]);
				
				//loop thru copying in original array to new array
				for (int i = 0; i < originalArray.length; i++)
					newArray[i] = originalArray[i];
				return newArray;
			}
		}	
		
}
