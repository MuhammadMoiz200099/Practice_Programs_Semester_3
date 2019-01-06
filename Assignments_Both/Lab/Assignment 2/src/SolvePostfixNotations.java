import javax.swing.*;

public class SolvePostfixNotations {

    public int SolvingPostfix(String equation) {

        char[] convert = equation.toCharArray();
        int size = convert.length * 2;
        MyStack stack = new MyStack(size);

        for (int i = 0; i < convert.length ; i++) {
            if (convert[i] == ' ') {
            } else {
                if (convert[i] > '0' && convert[i] < '9') {
                    stack.push(convert[i]);
                } else {
                    int solve1 = Integer.parseInt("" + stack.pop());
                    int solve2 = Integer.parseInt("" + stack.pop());

                    if(convert[i] == '+') {
                        stack.push(solve1 + solve2);
                    } else if (convert[i] == '-') {
                        if(solve1 > solve2) {
                            stack.push(solve1 - solve2);
                        }else if(solve2 > solve1) {
                            stack.push(solve2 - solve1);
                        }else {
                            stack.push(0);
                        }
                    } else if(convert[i] == '*') {
                        stack.push(solve1 * solve2);
                    } else if(convert[i] == '/') {
                        stack.push(solve1 / solve2);
                    } else {
                        JOptionPane.showMessageDialog(null , "Unrecongnized Operator");
                    }
                }
            }
        }
        int resultPostfix = Integer.parseInt("" + stack.pop());
        return resultPostfix;
    }

    public static void main(String[] args) {
        SolvePostfixNotations solve = new SolvePostfixNotations();

        System.out.println("Answer for Equation 1 4 +  3 * : "
                + solve.SolvingPostfix("1 4 +  3 *"));
        System.out.println();

        System.out.println("Answer for Equation 2 7 +  25 * : "
                + solve.SolvingPostfix("2 7 +  25 *"));
        System.out.println();

        System.out.println("Answer for Equation 2 4 +  3 * : "
                + solve.SolvingPostfix("2 4 +  3 *"));
        System.out.println();

        System.out.println("Answer for Equation 3 3 +  36 + : "
                + solve.SolvingPostfix("3 3 +  36 +"));
        System.out.println();

    }
}
