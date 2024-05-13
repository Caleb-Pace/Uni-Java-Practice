package unijavapractice;

import java.security.InvalidParameterException;
import unijavapractice.banking.BankAccount;
import unijavapractice.banking.Person;
import unijavapractice.secret.TopSecret;


public class Main {
	public static void main(String[] args) {
		PersonalDataTests();
		BankAccountTests();
		TopSecretFilesTests();
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

		// Compare results
		displayResults("Personal Data", new String[] {
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

	// Unit tests for the Bank Account section.
	public static void BankAccountTests() {
		String[] responses = new String[17];
		
		// Get & toString tests
		Person p = new Person("John", "Smith", 32);
		BankAccount b = new BankAccount(p);
		responses[0] = b.toString();
		responses[1] = String.valueOf(b.getBalance());
		responses[2] = b.getCustomer().toString();

		// Method tests
		//     deposit
		b.deposit(-12);
		responses[3] = b.toString();
		b.deposit(0);
		responses[4] = b.toString();
		b.deposit(203);
		responses[5] = b.toString();
		//     withdraw
		b.withdraw(-7);
		responses[6] = b.toString();
		b.withdraw(0);
		responses[7] = b.toString();
		b.withdraw(150);
		responses[8] = b.toString();
		b.withdraw(50);
		responses[9] = b.toString();
		b.withdraw(1700);
		responses[10] = b.toString();
		//     transfer
		Person p1 =  new Person("Danny", "DeVito", 79);
		Person p2 =  new Person("Ryan", "Reynolds", 47);
		BankAccount b1 = new BankAccount(p1); // Danny
		BankAccount b2 = new BankAccount(p2); // Ryan
		b1.deposit(9); // Danny
		b2.deposit(314); // Ryan
		b1.transfer(b2, -2);
		responses[11] = String.format("Danny: %d ->  Ryan: %d", b1.getBalance(), b2.getBalance());
		b1.transfer(b2, 0);
		responses[12] = String.format("Danny: %d ->  Ryan: %d", b1.getBalance(), b2.getBalance());
		b1.transfer(b2, 9);
		responses[13] = String.format("Danny: %d ->  Ryan: %d", b1.getBalance(), b2.getBalance());
		b2.transfer(b1, 320);
		responses[14] = String.format(" Ryan: %d -> Danny: %d", b2.getBalance(), b1.getBalance());
		b2.transfer(b1, 6);
		responses[15] = String.format(" Ryan: %d -> Danny: %d", b2.getBalance(), b1.getBalance());
		b1.transfer(b1, 200);
		responses[16] = String.format("Danny: %d -> Danny", b1.getBalance());
		
		// Compare results
		displayResults("Bank Account", new String[] {
			"Initialisation",
			"getBalance()",
			"getCustomer()",
			"deposit(-12)",
			"deposit(0)",
			"deposit(203)",
			"withdraw(-7)",
			"withdraw(0)",
			"withdraw(150)",
			"withdraw(50)",
			"withdraw(1700)       // Insufficient funds",
			"b1.transfer(b2, -2)",
			"b1.transfer(b2, 0)",
			"b1.transfer(b2, 9)",
			"b2.transfer(b1, 320)",
			"b2.transfer(b1, 6)   // Insufficient funds",
			"b1.transfer(b1, 200) // Self transfer"
		}, new String[] {
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 0",
			"0",
			"First Name = John\nLast Name = Smith\nAge = 32",
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 0",
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 0",
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 203",
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 203",
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 203",
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 53",
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 3",
			"First Name = John\nLast Name = Smith\nAge = 32\nBalance = 3",
			"Danny: 9 ->  Ryan: 314",
			"Danny: 9 ->  Ryan: 314",
			"Danny: 0 ->  Ryan: 323",
			" Ryan: 3 -> Danny: 320",
			" Ryan: 3 -> Danny: 320",
			"Danny: 320 -> Danny",
		}, responses);
	}

	// Unit tests for the Top Secret Files section.
	public static void TopSecretFilesTests() {
		String[] responses = new String[2];

		String originalText = "The secret tomato sauce ingredients are: onions, carrots,\ngarlic, whole tomatoes, salt, tomato paste and olive oil.";
		String secretText = "The ______ ______ s_uce ingredients _re: onions, c_rrots,\ng_rlic, wh__e ______es, s_lt, ______ p_ste _nd __ive oil.";

		// toString test
		TopSecret original = new TopSecret(originalText);
		responses[0] = original.toString();

		// Method test
		responses[1] = original.redact(new String[]{"tomato","secret","ol","a"}).toString();

		// Compare results
		displayResults("Top Secret Files", new String[] {
			"Initialisation",
			"Redaction"
		}, new String[] {
			"Text = " + originalText,
			"Text = " + secretText
		}, responses);
	}

	// This method validates and displays formatted test results (Pass/Fail).
	public static void displayResults(String heading, String[] testNames, String[] expectedResults, String[] actualResults) {
		// Validate input array lengths
		if (testNames.length != expectedResults.length) {
			throw new InvalidParameterException("Length mismatch between tests and expected results! (test names: " + testNames.length + " != expected: " + expectedResults.length + ")");
		}
		if (expectedResults.length != actualResults.length) {
			throw new InvalidParameterException("Length mismatch between expected and actual results! (expected: " + expectedResults.length + " != actual: " + actualResults.length + ")");
		}
	
		// Calculate formatting offsets
		int indent = 4;
		int testNumberWidth = String.valueOf(testNames.length).length() + indent;
		int commentIndent = testNumberWidth + 3 + 9; // Align with test "Fail". +9 for "Expected:"
		
		// Coloured key words
		String pass = "\033[1;32mPass\033[0m"; // Bold green
		String fail = "\033[1;31mFail\033[0m"; // Bold red

		// Print heading
		System.out.println("\n\033[4;1m" + heading + ":\033[0m"); // Bold Underline

		// Loop through test results
		int failCount = 0;
		for (int i = 0; i < testNames.length; i++) {
			boolean success = expectedResults[i].equals(actualResults[i]);
			String comment = "";
	
			// Build comment string only if the test failed (Colour: Yellow)
			if (!success) {
				comment = String.format("\n\033[0;33m%" + commentIndent + "s \"%s\"\n%" + commentIndent + "s \"%s\"\033[0m", "Expected:", expectedResults[i], "Got:", actualResults[i]);
				failCount++;
			}
	
			// Format and print test result
			System.out.println(String.format("%" + testNumberWidth + "s | %s | %s%s", (i + 1), (success ? pass : fail), testNames[i], comment));
		}

		// Display summary
		String summaryIndicator = "-".repeat(testNumberWidth - indent - 1) + ">";
		if (failCount == 0)
			System.out.println(String.format("%" + testNumberWidth + "s | \033[1;32mPassed \033[0;32mall %d tests\033[0m", summaryIndicator, testNames.length));
		else
			System.out.println(String.format("%" + testNumberWidth + "s | \033[1;31mPassed \033[0;31m%d/%d tests\033[0m", summaryIndicator, (testNames.length - failCount), testNames.length));
	}
}
