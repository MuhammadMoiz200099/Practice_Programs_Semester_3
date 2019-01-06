package Conversions;

import java.util.Scanner;

/**
 * 
 * @author Muhammad Moiz
 *
 */
public class OctalToDecimal {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Octal Input: ");
		String inputOctal = sc.nextLine();
		int result = convertOctalToDecimal(inputOctal);
		if (result != -1)
			System.out.println("Result convertOctalToDecimal : " + result);
		sc.close();
	}

	public static int convertOctalToDecimal(String inputOctal) {

		try {
			Integer outputDecimal = Integer.parseInt(inputOctal, 8);
			return outputDecimal;
		} catch (NumberFormatException ne) {
		
			System.out.println("Invalid Input, Expecting octal number 0-7");
			return -1;
		}
	}
}