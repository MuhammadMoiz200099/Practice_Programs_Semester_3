public class CheckTheBrackets {

    public boolean balancedBrackets(String equation) {

        char[] convert = equation.toCharArray();
        int size = convert.length * 2;
        MyStack<Character> stack = new MyStack<Character>(size);

        for (char bracket : convert)
            if(bracket == '(') {
                stack.push(')');
            } else if(bracket == '{') {
                stack.push('}');
            } else if (bracket == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || bracket != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        CheckTheBrackets brackets = new CheckTheBrackets();

        String brackets1 = "[()]{}{[()()]()}";
        String brackets2 = "[(])";
        String brackets3 = "{()()()}[]{()[]{}}()()";
        String brackets4 = "({[}{(}))}]";

        System.out.println("Given Brackets [()]{}{[()()]()} are Balanced Or Not " +
                "(ture = yes : false = no): " + brackets.balancedBrackets(brackets1));
        System.out.println();

        System.out.println("Given Brackets [(]) are Balanced Or Not " +
                "(ture = yes : false = no): " + brackets.balancedBrackets(brackets2));
        System.out.println();

        System.out.println("Given Brackets {()()()}[]{()[]{}}()() are Balanced Or Not " +
                "(ture = yes : false = no): " + brackets.balancedBrackets(brackets3));
        System.out.println();

        System.out.println("Given Brackets ({[}{(}))}] are Balanced Or Not " +
                "(ture = yes : false = no): " + brackets.balancedBrackets(brackets4));

    }
}