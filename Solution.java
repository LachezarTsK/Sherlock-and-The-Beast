import java.util.Scanner;

public class Solution {

	private static String decentNumber(int numberOfDigitsInTheNumber) {
		int numberOfFivesInDecentNumber = numberOfDigitsInTheNumber;
		int numberOfThreesInDecentNumber = 0;
		String result = "-1";

		/**
		 * Check possibility for only 5s.
		 */
		if (numberOfDigitsInTheNumber % 3 == 0) {
			result = constructDecentNumber(numberOfFivesInDecentNumber, numberOfThreesInDecentNumber);
			return result;
		}

		/**
		 * Check possibility for 3s preceded by 5s.
		 */
		numberOfFivesInDecentNumber -= 5;
		while (numberOfFivesInDecentNumber >= 0) {
			numberOfThreesInDecentNumber += 5;
			if (numberOfFivesInDecentNumber % 3 == 0) {
				result = constructDecentNumber(numberOfFivesInDecentNumber, numberOfThreesInDecentNumber);
				return result;
			}
			numberOfFivesInDecentNumber -= 5;
		}

		/**
		 * Check possibility for only 3s.
		 */
		if (numberOfDigitsInTheNumber % 5 == 0) {
			numberOfFivesInDecentNumber = 0;
			numberOfThreesInDecentNumber = numberOfDigitsInTheNumber;
			result = constructDecentNumber(numberOfFivesInDecentNumber, numberOfThreesInDecentNumber);
			return result;
		}

		return result;
	}

	public static String constructDecentNumber(int numberOfFives, int numberOfThrees) {

		StringBuilder decentNumber = new StringBuilder();
		for (int i = 0; i < numberOfFives; i++) {
			decentNumber.append("5");
		}

		for (int i = 0; i < numberOfThrees; i++) {
			decentNumber.append("3");
		}

		return decentNumber.toString();
	}

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int numberOfTestCases = reader.nextInt();
		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfDigitsInTheNumber = reader.nextInt();
			String result = decentNumber(numberOfDigitsInTheNumber);
			System.out.println(result);
		}
		reader.close();
	}
}
