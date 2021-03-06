package phonebook;

import java.util.Scanner;
import java.util.Arrays;

public class PhonebookAsArray {

private static Scanner input;
		
	public static void main(String[] args) {
		input = new Scanner(System.in);
		String choice ="0";
		Person[] peopleArray = new Person[1];
		
		do {	
		System.out.println();
		choice = displayMenu();
		String phoneNumber ="";
		boolean found = false;
		
		switch(choice) {
		case "1": 
			System.out.println("1. Add new record, Example:");
            System.out.println("Firstname, Lastname, 3142224444, 999 Street, Any City, Mo, 63103");
			
    		//split to newPersonString by ", "; this is from lab from week 2, reverse words
            String newPersonString = input.nextLine();
            String[] arr = newPersonString.split(", ");
    			
    		//Debug Sysout of array length
    		//System.out.println("arr length: " +arr.length);
    		if (newPersonString == null || arr.length < 7) {
    			System.err.println("ERROR: Match Example And ");
    			System.err.println("enter a Comma Space between all fields.");
    			break;
    		}	
            peopleArray = Person.addRecord(arr, peopleArray);
			break;
		case "2":
			//delete a record by matching phone number
			System.out.println("2. To delete a record: ");
			System.out.println("Enter Phone Number of record to delete: ");
			phoneNumber = input.nextLine();
			if (peopleArray.length <1) {
				System.out.println("No one with that number");
			}
			//Added new array to replace current array once person deleted.  Its
			//here so that I only loop thru array once.
			Person[] fixing = new Person[peopleArray.length-1];
			for (int i=0; i<peopleArray.length; i++) {
				
				//copies in current array elements until we get to the one being deleted
				if (i <= fixing.length-1) {
					fixing[i] =peopleArray[i];
				}
				System.out.println(peopleArray[i] +", i=: " +i);
				if(peopleArray[i].getTelephone().equals(phoneNumber)) {
					System.out.println(peopleArray[i].getFirstName() 
							+ ", " + peopleArray[i].getLastName()
							+ ", " + peopleArray[i].getTelephone() 
							+ ", " + peopleArray[i].getAddress().getStreet()
							+ ", " + peopleArray[i].getAddress().getCity() 
							+ ", " + peopleArray[i].getAddress().getState() 
							+ ", " + peopleArray[i].getAddress().getZip()		
							); 
					String deletedName = (peopleArray[i].getFirstName() 
						   	  	  + " " + peopleArray[i].getLastName()
						   	  	  + " " + peopleArray[i].getTelephone()
					);
					System.out.println("Is this the person you want to delete(yes/no)? ");
					String yesNo = input.nextLine();
					yesNo = yesNo.toLowerCase();
					int temp = i;  //not entirely needed but easier to read
					if (yesNo.contentEquals("yes") || yesNo.contentEquals("y"))  {
						//returns updated version of array with record matching phone deleted
						peopleArray = deleteRecord(temp, peopleArray, fixing);
						System.out.println("Deleted Successfully " + deletedName);
						break;
					}
				}else {
					if (i==peopleArray.length-1) {
						System.out.println("No one with that number");
					}
				}
			}
/*	
			//delete a record by find last name		
			System.out.println("Enter Last Name of record to delete: ");
			String deleteLastName = input.nextLine();
			if (peopleArray.length<1) {
				System.out.println("No one with that number");
			}
			for (int i=0; i<peopleArray.length; i++) {
				if(peopleArray[i].getLastName().equals(deleteLastName)) {
					System.out.println(peopleArray[i].getFirstName() 
							+ ", " + peopleArray[i].getLastName()
							+ ", " + peopleArray[i].getTelephone() 
							+ ", " + peopleArray[i].getAddress().getStreet()
							+ ", " + peopleArray[i].getAddress().getCity() 
							+ ", " + peopleArray[i].getAddress().getState() 
							+ ", " + peopleArray[i].getAddress().getZip()	
					String deletedName = (peopleArray[i].getFirstName() 
						   	  	  + " " + peopleArray[i].getLastName()
						   	  	  + " " + peopleArray[i].getTelephone() );
					System.out.println("Is this the person you want to delete(yes/no)? ");
					String yesNo = input.nextLine();
					yesNo = yesNo.toLowerCase();
					int temp = i;  //not entirely needed but easier to read
					if (yesNo.contentEquals("yes") || yesNo.contentEquals("y"))  {
						//returns updated version of array with record matching phone deleted
						peopleArray = deleteRecord(temp, peopleArray);
						System.out.println("Deleted Successfully " + deletedName);
						break;
					}
				} else {
					if (i==peopleArray.length-1) {
						System.out.println("No one with that name");
					}
			}
*/			
			break;
		case "3":
			System.out.println("3. To update a record");
			//update a record by finding the matching phone number
			System.out.println("Enter phone number of record to change: ");
			phoneNumber = input.nextLine();
			for (int i=0; i<peopleArray.length; i++) {
				if(peopleArray[i].getTelephone().equals(phoneNumber)) {
					System.out.println(peopleArray[i]);
					System.out.println("Is this the person you want to change the phone number for(yes/no)? ");
					String yesNo = input.nextLine();
					yesNo = yesNo.toLowerCase();
					if (yesNo.contentEquals("yes") || yesNo.contentEquals("y"))  {
						System.out.println("Enter new phone number: "); 
						phoneNumber = checkPhoneLength(input.nextLine());
						peopleArray[i].setTelephone(phoneNumber);
						System.out.println("Updated telephone for: " + peopleArray[i]);
						break;
					}
				} else {
					if (i==peopleArray.length-1) {
						System.out.println("No one with that number");
					}
				}
			}
/* 
			//update a record by finding the matching last name
			System.out.println("Enter Last Name of record to change: ");
			String lastname = input.nextLine();
			for (int i=0; i<peopleArray.length; i++) {
				if(peopleArray[i].getLastName().equals(lastname)) {
					System.out.println(peopleArray[i]); 
					System.out.println("Is this the person you want to change the phone number for(yes/no)? ");
					String yesNo = input.nextLine();
					yesNo = yesNo.toLowerCase();
					if (yesNo.contentEquals("yes") || yesNo.contentEquals("y"))  {
						System.out.println("Enter new phone number: "); 
						phoneNumber = checkPhoneLength(input.nextLine());
						peopleArray[i].setTelephone(phoneNumber);
						System.out.println("Updated telephone for: " + peopleArray[i]);
						break;
					}
				} else {
					if (i==peopleArray.length-1) {
						System.out.println("No one with that name");
					}
				}
			}
*/
			if (peopleArray.length<1) {
				System.out.println("No one with that name");
			}
			break;
		case "4":
			System.out.println("4. Listing all records");
			Arrays.sort(peopleArray, 0, peopleArray.length);

			for (int i=0; i<peopleArray.length; i++) {
				System.out.println(peopleArray[i]);
			}
			break;
		case "5":
			System.out.println("5. Enter Full Name to Search for: ");
			String name = input.nextLine();
			String concatenateName = "";
			found = false;
			for (int i=0; i<peopleArray.length; i++) {
				concatenateName =peopleArray[i].getFirstName() + " " + peopleArray[i].getLastName();
				if(concatenateName.equals(name)) {
					System.out.println(peopleArray[i]); 
					found = true;
				} else if (i==peopleArray.length-1 && !found) {
					System.out.println("No one with that name");
				}
			}
			if (peopleArray.length<1) {
				System.out.println("No one with that name");
			}
			break;
		case "6": 
			System.out.println("6. Enter First Name to Search for: ");
			String fname = input.nextLine();
			found = false;
			for (int i=0; i<peopleArray.length; i++) {
				if(peopleArray[i].getFirstName().equals(fname)) {
					System.out.println(peopleArray[i]); 
					found = true;
				} else if (i==peopleArray.length-1 && !found) {
					System.out.println("No one with that name");
				}
			}
			if (peopleArray.length<1) {
				System.out.println("No one with that name");
			}
			break;
		case "7":
			System.out.println("7. Enter Last Name to Search for: ");
			String lname = input.nextLine();
			found = false;
			for (int i=0; i<peopleArray.length; i++) {
				if(peopleArray[i].getLastName().equals(lname)) {
					System.out.println(peopleArray[i]); 
					found = true;
				} else if (i==peopleArray.length-1 && !found) {
					System.out.println("No one with that name");
				}
			}
			if (peopleArray.length<1) {
				System.out.println("No one with that name");
			}
			break;
		case "8":
			System.out.println("8. Enter Telephone to Search for: ");
			phoneNumber = input.nextLine();
			found = false;
			for (int i=0; i<peopleArray.length; i++) {
				if(peopleArray[i].getTelephone().equals(phoneNumber)) {
					System.out.println(peopleArray[i]); 
					found = true;
				} else if (i==peopleArray.length-1 && !found) {
					System.out.println("No one with that number");
				}
			}
			if (peopleArray.length<1) {
				System.out.println("No one with that number");
			}
			break;
		case "9":
			System.out.println("9. Enter City to Search for: ");
			String city = input.nextLine();
			found = false;
			for (int i=0; i<peopleArray.length; i++) {
				if(peopleArray[i].getAddress().getCity().equals(city)) {
					System.out.println(peopleArray[i]); 
					found = true;
				} else if (i==peopleArray.length-1 && !found) {
					System.out.println("No one with that city");
				}
			}
			if (peopleArray.length<1) {
				System.out.println("No one with that city");
			}
			break;
		case "10":
			System.out.println("10. Enter State to Search for: ");
			String state = input.nextLine();
			found = false;
			for (int i=0; i<peopleArray.length; i++) {
				if(peopleArray[i].getAddress().getState().equals(state)) {
					found = true;
					System.out.println(peopleArray[i]); 
				} else if (i==peopleArray.length-1 && !found) {
					System.out.println("No one with that state");
				}
			}
			if (peopleArray.length<1) {
				System.out.println("No one with that state");
			}
			break;
		case "11":
			System.out.println("Bye");
			break;
		default:
			System.err.println("ERROR: Enter a number 1 through 11");
			break;
		}
	} while (!choice.equals("11"));
	}	
	
	public static String displayMenu() {
		input = new Scanner(System.in);
		
		System.out.println("What would you like to do: ");
		System.out.println("1. Add a record");
		System.out.println("2. Delete a record");
		System.out.println("3. Update a telephone number");
		System.out.println("4. List all records");
		System.out.println("5. Search by Full Name");
		System.out.println("6. Search by First Name");
		System.out.println("7. Search by Last Name");
		System.out.println("8. Search by Telephone Number");
		System.out.println("9. Search by City");
		System.out.println("10.Search by State");
		System.out.println("11.Exit");
		
		//Break this later
		String choice = input.nextLine();
		return choice;
	}

	public static String checkPhoneLength(String phone) {
		boolean phoneGood = false;
		do {
			if (phone.length() == 10) {
				phoneGood = true;
			} else {
				System.err.println("ERROR bad phone number: ("
						+ phone.substring(0,3) + ")" 
						+ phone.substring(3,6) + "-" 
						+ phone.substring(6)   );
			System.err.println("Please RE-enter 10-digit Telephone Number");
			phone = input.nextLine();
			}
		} while (phoneGood == false);
		return phone;
	}
	
	public static Person[] deleteRecord(int temp, Person[] arrayToFix, Person[] fixed) {
		//set length of new array to old array length minus 1.

		for (int i=0; i < arrayToFix.length-1; i++) {
			//temp is the array element to be removed.
			if (i >= temp)  {
				//sets the array elements after one to be deleted down by one place.
				fixed[i] =arrayToFix[i+1];
			} 
		}
		return fixed;
	}
}
