package Conversions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Muhammad Moiz
 *
 */

public class DecimalToAnyBase {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the decimal input below: ");
        int decInput = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.println("Enter the base below: ");
        int base =  Integer.parseInt(br.readLine());
        System.out.println();

        System.out.println("Decimal Input" + " is: " + decInput);
        System.out.println("Value of " + decInput + " in base " + base + " is: " + convertToAnyBase(decInput, base));

        br.close();
    }


    public static String convertToAnyBase(int inp, int base) {
        ArrayList<Character> charArr = new ArrayList<>();

        while (inp > 0) {
            charArr.add(reVal(inp%base));
            inp /= base;
        }

        StringBuilder str = new StringBuilder(charArr.size());

        for(Character ch: charArr)
        {
            str.append(ch);
        }

        return str.reverse().toString();
    }

    public static char reVal(int num) {
        if (num >= 0 && num <= 9)
            return (char)(num + '0');
        else
            return (char)(num - 10 + 'A');
    }
}
