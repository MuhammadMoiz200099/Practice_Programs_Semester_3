

public class test {
    public static void main(String[] args) {

        myList<Integer> myListo = new myList<>();

        System.out.println("\n-------------Adding Numbers------------\n");

        myListo.add(1);
        myListo.add(2);
        myListo.add(3);
        myListo.add(4);
        myListo.add(5);
        myListo.add(6);

        myListo.print();

        System.out.println("\n-------------Adding on index Numbers------------\n");

        myListo.add(1,3);
        myListo.print();

        System.out.println("\n-------------removing Numbers 6------------\n");

        myListo.remove(6);
        myListo.print();

        System.out.println("\n-------------searching Numbers 2------------\n");
        System.out.println(myListo.search(2));

        System.out.println("\n-------------list is empty------------\n");
        System.out.println(myListo.isEmpty(2));

        System.out.println("\n-------------updating Numbers 8 on index 1------------\n");
        myListo.update(8,1);
        myListo.print();

        System.out.println("\n-------------removing All Numbers 1------------\n");

        myListo.removeAll(1);
        myListo.print();


    }
}
