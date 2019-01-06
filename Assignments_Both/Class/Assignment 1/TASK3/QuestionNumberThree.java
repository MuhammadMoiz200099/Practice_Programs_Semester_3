

public class QuestionNumberThree {
    public static void main(String[] args) {
         System.out.println(addNumbers(11,20));
    }

    public static int addNumbers(int start , int end) {

        int equations;

        equations = (end * (end + start)) / 2;
        // THIS IS MY BEST CASE OR O(1)

        // THE WORST CASE CAN BE USING LOOPS WHICH MAKE THE COMPLEXICITY O(n)
        return equations;

    }
}
