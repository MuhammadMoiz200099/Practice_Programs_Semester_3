package Palandrom;

import java.util.Scanner;
public class PalindromePrime {

    public static void main(String[] args) { 
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the quantity of First Palindromic Primes you want");
        int n = in.nextInt(); 
        funtioning(n); 
    }

    public static boolean prime(int num) { 
        for (int divisor = 2; divisor <= num / 2; divisor++) {
            if (num % divisor == 0) {
                return false; 
            }
        }
        return true;
    }

    public static int reverse(int n){ 
        int reverse = 0;
        while(n!=0){
            reverse = reverse * 10;
            reverse = reverse + n%10;
            n = n/10;
        }
        return reverse;
    }

    public static void funtioning(int y){
            int count =0;
            int num = 2;
            while(count < y){
                if(prime(num) && num == reverse(num)){
                    count++; 
                    System.out.print(num + "\n");
                }
                num++; 
            }
    }
};
