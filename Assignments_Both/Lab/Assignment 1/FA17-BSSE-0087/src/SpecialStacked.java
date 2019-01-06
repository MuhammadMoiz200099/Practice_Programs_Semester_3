public class SpecialStacked {

    private int capacity = 0;
    private SpecialNode top = null;

    public void push(int item) {

        SpecialNode node = new SpecialNode(item);
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

    public void getMin() {
        SpecialNode node = top.next.next;
        SpecialNode tempNode = null;
        int min = node.data;
        min = Math.min(min , node.data);
        System.out.println(min);
        for (tempNode = top; tempNode != null; tempNode = tempNode.next) {
            if(tempNode.data >= min) {
                pop();
            }
        }

    }

    public int peek() {
        return (top == null) ? -1 : top.data;
    }

    public int size() {
        return capacity;
    }

    public boolean isFull() {
        return capacity > capacity + 1;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void print() {
        SpecialNode tempNode = null;

        if (top != null) {
            for (tempNode = top; tempNode != null; tempNode = tempNode.next) {
                System.out.print(tempNode.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        SpecialStacked stack = new SpecialStacked();

        System.out.println("Orignal Stack: ");
        stack.push(76);
        stack.push(86);
        stack.push(96);
        stack.print();
        System.out.println("\nThe minmun is: ");
        stack.getMin();
        System.out.println("\n\nOrignal Stack: ");
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.print();
        System.out.println("\nThe minmun is: ");
        stack.getMin();
        stack.print();

        System.out.println("\n\nIf the getMin Function called it pop the values");
        stack.push(76);
        stack.push(86);
        stack.push(96);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.getMin();
        stack.print();

    }
}
