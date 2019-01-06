
public class sortedListTest {
    public static void main(String[] args) {

       mySortedList<Integer> list = new mySortedList<>();

        System.out.println("\n-------------Adding Numbers------------\n");

       list.add(1);
       list.add(4);
       list.add(2);
       list.add(3);
       list.add(9);
       list.add(96);
       list.add(17);
       list.add(11);

       list.print();

        System.out.println("\n-------------Adding on index Numbers------------\n");

        list.add(9,3);
        list.print();


    }
}
