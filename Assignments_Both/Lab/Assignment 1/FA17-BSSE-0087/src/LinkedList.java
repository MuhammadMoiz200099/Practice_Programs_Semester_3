import java.util.Scanner;

public class LinkedList {

    LinkedNode head;

    public void add(int data) {

        LinkedNode node =  new LinkedNode();

        node.data = data;
        node.next = null;

        if(head == null) {
            head = node;
        } else {

            LinkedNode tempNode;

            tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
                tempNode.next = node;
        }
    }

    public void Assendingsort() {

        LinkedNode i = this.head;
        LinkedNode j;

        for(i = head ; i != null ; i = i.next) {
            for(j = i.next ; j != null ; j = j.next) {

                if(i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    public void Descendingsort() {

        LinkedNode i = this.head;
        LinkedNode j;

        for(i = head ; i != null ; i = i.next) {
            for(j = i.next ; j != null ; j = j.next) {

                if(i.data < j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    public LinkedNode reverse_list() {

        LinkedNode presentNode = this.head;
        LinkedNode nextNode = null;
        LinkedNode prevNode = null;

        while(presentNode != null) {
            nextNode = presentNode.next;
            presentNode.next = prevNode;
            prevNode = presentNode;
            presentNode = nextNode;
        }
        return prevNode;
    }

    public void print() {

        LinkedNode node = head;
        System.out.print("List = {");
        while (node.next != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }
        System.out.print(node.data);
        System.out.print("}");
    }

    public void print(LinkedNode head) {

        LinkedNode node = head;
        System.out.print("Reversed List = {");
        while (node.next != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }
        System.out.print(node.data);
        System.out.print("}");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the range: ");
        int timeInput = scanner.nextInt();

        int i = 1;
        do {
            System.out.print("Enter the Element: ");
            int data = scanner.nextInt();
            list.add(data);
            i++;
        } while(i <= timeInput);

        System.out.println("Orignal List: ");
        list.print();
        System.out.println();
        System.out.println("Sort in Assending Order: ");
        list.Assendingsort();
        list.print();
        System.out.println();
        System.out.println("Sort in Descending Order: ");
        list.Descendingsort();
        list.print();
        System.out.println();
        System.out.println("Reverse Order List: ");
        LinkedNode reverse = list.reverse_list();
        list.print(reverse);

    }
}
