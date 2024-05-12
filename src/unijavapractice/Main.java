package unijavapractice;

import java.security.InvalidParameterException;
import unijavapractice.banking.Person;


public class Main {
	public static void main(String[] args) {
		PersonalDataTests();
	}

	// Unit tests for the Personal Data section.
	public static void PersonalDataTests() {
		String[] responses = new String[16];

		// Get & toString tests
		Person p = new Person("John", "Smith", 32);
		responses[0] = p.toString();
		responses[1] = String.valueOf(p.getAge());
		responses[8] = p.getFirstName();
		responses[11] = p.getLastName();

		// Set tests
		//     age
		p.setAge(-5);
		responses[2] = String.valueOf(p.getAge());
		p.setAge(0);
		responses[3] = String.valueOf(p.getAge());
		p.setAge(20);
		responses[4] = String.valueOf(p.getAge());
		p.setAge(94);
		responses[5] = String.valueOf(p.getAge());
		p.setAge(969);
		responses[6] = String.valueOf(p.getAge());
		p.setAge(980);
		responses[7] = String.valueOf(p.getAge());
		//     first name
		p.setFirstName("Robin");
		responses[9] = p.getFirstName();
		p.setFirstName("");
		responses[10] = p.getFirstName();
		//     last name
		p.setLastName("Philips");
		responses[12] = p.getLastName();
		p.setLastName("");
		responses[13] = p.getLastName();

		// Method tests
		Person p1 =  new Person("Danny", "DeVito", 79);
		Person p2 =  new Person("Ryan", "Reynolds", 47);
		responses[14] = p1.oldest(p2).toString();
		responses[15] = p2.oldest(p1).toString();

		displayResults(new String[] {
			"Person(\"John\", \"Smith\", 32)",
			"getAge()",
			"setAge(-5)",
			"setAge(0)",
			"setAge(20)",
			"setAge(94)",
			"setAge(969)",
			"setAge(980)",
			"getFirstName()",
			"setFirstName(\"Robin\")",
			"setFirstName(\"\")",
			"getLastName()",
			"setLastName(\"Philips\")",
			"setLastName(\"\")",
			"Oldest Person",
			"Oldest Person (Swapped)"
		}, new String[] {
			"First Name = John\nLast Name = Smith\nAge = 32",
			"32",
			"-1",
			"0",
			"20",
			"94",
			"969",
			"-1",
			"John",
			"Robin",
			"",
			"Smith",
			"Philips",
			"",
			"First Name = Danny\nLast Name = DeVito\nAge = 79",
			"First Name = Danny\nLast Name = DeVito\nAge = 79"
		}, responses);
	}

	// This method validates and displays formatted test results (Pass/Fail).
	public static void displayResults(String[] testNames, String[] expectedResults, String[] actualResults) {
		// Validate input array lengths
		if (testNames.length != expectedResults.length) {
			throw new InvalidParameterException("Length mismatch between tests and expected results! (test names: " + testNames.length + " != expected: " + expectedResults.length + ")");
		}
		if (expectedResults.length != actualResults.length) {
			throw new InvalidParameterException("Length mismatch between expected and actual results! (expected: " + expectedResults.length + " != actual: " + actualResults.length + ")");
		}
	
		// Calculate formatting offsets
		int testNumberWidth = String.valueOf(testNames.length).length();
		int commentIndent = testNumberWidth + 3 + 9; // Align with test "Fail". +9 for "Expected:"
		
		// Coloured key words
		String pass = "\033[1;32mPass\033[0m"; // Bold green
		String fail = "\033[1;31mFail\033[0m"; // Bold red

		// Loop through test results
		for (int i = 0; i < testNames.length; i++) {
			boolean success = expectedResults[i].equals(actualResults[i]);
			String comment = "";
	
			// Build comment string only if the test failed (Colour: Yellow)
			if (!success)
				comment = String.format("\n\033[0;33m%" + commentIndent + "s \"%s\"\n%" + commentIndent + "s \"%s\"\033[0m", "Expected:", expectedResults[i], "Got:", actualResults[i]);
	
			// Format and print test result
			System.out.println(String.format("%" + testNumberWidth + "s | %s | %s%s", i, (success ? pass : fail), testNames[i], comment));
		}
	}
}
