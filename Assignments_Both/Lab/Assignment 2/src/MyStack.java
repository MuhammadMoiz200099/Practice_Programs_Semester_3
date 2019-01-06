import java.util.NoSuchElementException;
public class MyStack<M> {

    private int arrayCapacity;
    private int topMarker;
    private M[] stackArray;

    public MyStack() {
        this.stackArray = (M[]) new Object[arrayCapacity];
        this.topMarker = -1;
    }

    public MyStack(int arrayCapacity) {
        this.arrayCapacity = arrayCapacity;
        this.stackArray = (M[]) new Object[arrayCapacity];
        this.topMarker = -1;
    }

    public boolean isEmpty() {
        return this.topMarker == -1;
    }

    public boolean isFull() {
        return topMarker == arrayCapacity -1 ;
    }

    public void push(M item) {
        if(!isFull()) {
            ++this.topMarker;
            this.stackArray[topMarker] = item;
        }
        else {
            System.out.println("Stack Overflow....");
        }
    }

    public M peek()
    {
        if( isEmpty() ) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return stackArray[topMarker];
    }

    public M pop() {
        if(!isEmpty()) {
            M top = this.stackArray[this.topMarker--];
            return top;
        }
        else {
            System.out.println("Stack UnderFlow....");
            return null;
        }
    }
}
