import java.util.Scanner;

public class EmptyStack {
    private NodeStack top;
    private int capacity;
    private char[] array;

    public EmptyStack(int capacity) {
        this.capacity = capacity;
        this.array = new char[capacity];
    }

    public void push(int item) {
        NodeStack node = new NodeStack(item);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }

        capacity++;
    }

    public int pop() {
        int result = -1;

        if (top != null) {
            result = top.data;
            top = top.next;
            capacity--;
        }

        return result;
    }

    public String reverse(String str) {
        char[] charArr = str.toCharArray();
        int size = charArr.length;
        EmptyStack stack = new EmptyStack(size);

        int i;
        for(i = 0; i < size; ++i) {
            stack.push(charArr[i]);
        }

        for(i = 0; i < size; ++i) {
            charArr[i] = (char) stack.pop();
        }

        return String.valueOf(charArr);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmptyStack stack = new EmptyStack(20);


        System.out.println("How Many Time You Want to Reverse String: ");
        int range = scanner.nextInt();

        for(int i = 1 ; i <= range ; i++) {
            System.out.println("\nEnter a String: ");
            String data = scanner.next();
            System.out.print("Reversed: " + stack.reverse(data) + "\n");
        }

    }
}
