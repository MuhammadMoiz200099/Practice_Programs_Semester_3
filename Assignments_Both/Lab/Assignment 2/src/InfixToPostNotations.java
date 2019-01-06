public class InfixToPostNotations {

    public String convertTheEquation(String equation) {

        String answer = "";

        char[] convert = equation.toCharArray();
        int size = convert.length ;
        MyStack<Character> stack = new MyStack<Character>(size);

        for(int i = 0 ; i < size ; i++) {

            if(convert[i] >= '0' && convert[i] <= '9') {
                answer = convert[i] + answer;
            }
            if (convert[i] == '(') {
                stack.push(convert[i]);
            } else if(convert[i] == ')') {
                 while (!stack.isEmpty() && stack.peek() != '(') {
                     answer = answer + stack.pop();
                 }
                 if(!stack.isEmpty() && stack.peek() != '(') {
                     return null;
                 }else if (!stack.isEmpty()) {
                       stack.pop();
                 }
            } else if(convert[i] == '+' || convert[i] == '-' || convert[i] == '*' || convert[i] == '/') {
                  if(!stack.isEmpty() && minortyOfOperator(convert[i]) <= minortyOfOperator(stack.peek())) {
                      answer = answer + stack.pop();
                  }
                stack.push(convert[i]);
            }
        }
        while (!stack.isEmpty()) {
            answer = answer + stack.pop();
        }
        return answer;
    }

    public static int minortyOfOperator(char characters) {
        if(characters == '+' || characters == '-') {
            return 1;
        } else if(characters == '*' || characters == '/') {
            return 2;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        InfixToPostNotations infix = new InfixToPostNotations();

        String eq1 = "(1 + 2) * 3";
        String eq2 = "((7 - 2) - (8 - 1)) + 6";
        String eq3 = "(3 + 2) - (7 + 8) + (9 + 1) / 6";
        String eq4 = "( (2 + 6) - 7 * (9 / 7 ) ) + 3";

        System.out.println("Converting Infix to Postfix (Infix is = (1 + 2) * 3): "
                + infix.convertTheEquation(eq1));
        System.out.println();

        System.out.println("Converting Infix to Postfix (Infix is = ((7 - 2) - (8 - 1)) + 6): "
                + infix.convertTheEquation(eq2));
        System.out.println();

        System.out.println("Converting Infix to Postfix (Infix is = (3 + 2) - (7 + 8) + (9 + 1) / 6): "
                + infix.convertTheEquation(eq3));
        System.out.println();

        System.out.println("Converting Infix to Postfix (Infix is = ( (2 + 6) - 7 * (9 / 7 ) ) + 3): "
                + infix.convertTheEquation(eq4));

    }
}
