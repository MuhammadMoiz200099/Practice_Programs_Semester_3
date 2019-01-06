package Conversions;

import java.util.Scanner;

/**
 * 
 * 
 * @author Muhammad Moiz
 *
 */
public class DecimalToBinary {

    public static void main(String args[]) {
        conventionalConversion();
        bitwiseConversion();
    }

    public static void conventionalConversion() {
        int n, b = 0, c = 0, d;
        Scanner input = new Scanner(System.in);
        System.out.printf("Conventional conversion.\n\tEnter the decimal number: ");
        n = input.nextInt();
        while (n != 0) {
            d = n % 2;
            b = b + d * (int) Math.pow(10, c++);
            n /= 2;
        } 
        System.out.println("\tBinary number: " + b);
    }

    public static void bitwiseConversion() {
        int n, b = 0, c = 0, d;
        Scanner input = new Scanner(System.in);
        System.out.printf("Bitwise conversion.\n\tEnter the decimal number: ");
        n = input.nextInt();
        while (n != 0) {
            d = (n & 1);
            b += d * (int) Math.pow(10, c++);
            n >>= 1;
        }
        System.out.println("\tBinary number: " + b);
    }

}
