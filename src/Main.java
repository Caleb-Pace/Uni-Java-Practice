import java.security.InvalidParameterException;

public class Main {
	public static void main(String[] args) {
		displayResults(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"},
					   new String[] {"Steve", "GOAT", "cheddar", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"},
					   new String[] {"steve", "GOAT", "beef", "1", "2", "3", "4", "7", "6", "7", "8", "9", "0"});
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
		String pass = "\033[1;32mPass\033[0m";
		String fail = "\033[1;31mFail\033[0m";

		// Loop through test results
		for (int i = 0; i < testNames.length; i++) {
			boolean success = actualResults[i].equals(expectedResults[i]);
			String comment = "";
	
			// Build comment string only if test failed
			if (!success)
				comment = String.format("\n\033[0;33m%" + commentIndent + "s \"%s\"\n%" + commentIndent + "s \"%s\"\033[0m", "Expected:", expectedResults[i], "Got:", actualResults[i]);
	
			// Format and print test result
			System.out.println(String.format("%" + testNumberWidth + "s | %s | %s%s", i, (success ? pass : fail), testNames[i], comment));
		}
	}
}
