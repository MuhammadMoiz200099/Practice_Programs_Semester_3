package Conversions;

import java.util.Scanner;

/**
 * 
 * @author Muhammad Moiz
 *
 */
public class OctalToBinary {

    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Binary equivalent: " + convertOctalToBinary());
		sc.close();
	}
	
	public static String convertOctalToBinary() {
            Scanner scan = new Scanner(System.in);
            int num;

            System.out.println("Octal to Binary");
            System.out.println("\nEnter the number : ");
            num = Integer.parseInt(scan.nextLine(), 8);

            String binary = Integer.toBinaryString(num);	
            
            return binary;
	}
        
}