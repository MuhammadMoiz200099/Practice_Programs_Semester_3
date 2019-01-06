public class mySortedList<M> {

    private static final int capacity = 20;
    private M[] listArray = (M[]) new Object[capacity];
    private int endMark = -1;


    public void add(M item) {
        if (this.endMark + 1 < this.listArray.length) {
            endMark++;
            this.listArray[endMark] = item;

            sort(this.listArray);

        } else {
            M[] newlist = (M[]) new Object[this.listArray.length * 2];

            for (int i = 0 ; i < newlist.length ; i++) {
                this.listArray[i] = newlist[i];
            }
            endMark++;
            this.listArray[endMark] = item;
            sort(this.listArray );
        }
    }

    public void add(M item , int index) {
        if(this.endMark + 1 < this.listArray.length) {
            this.endMark++;
            for(int i = endMark ; i >= index ; i--) {
                this.listArray[i] = this.listArray[i - 1];
            }
            this.listArray[index] = item;
            sort(this.listArray);
        }else {
            M[] newList = (M[]) new Object[this.listArray.length * 2];
            for (int i = 0 ; i < newList.length ; i++) {
                this.listArray[i] = newList[i];
            }
            this.endMark++;
            for(int i = endMark ; i > index; i --) {
                this.listArray[i] = this.listArray[i - 1];
            }
            this.listArray[index] = item;
            sort(this.listArray);
        }
    }

    public int search(M item) {
        for (int i = 0 ; i < this.listArray.length ; i++) {
            if(this.listArray[i] == item) {
                return i ;
            }
        }
        return -1;
    }

    public void print() {
        for (int i= 0 ; i < endMark + 1 ; i++) {
            System.out.println(this.listArray[i]);
        }
    }


    private void sort(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Integer) {
                int counter = i;
                int tempStore = (Integer) array[i];
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] instanceof Integer && (Integer) array[j] < tempStore) {
                        counter = j;
                        tempStore = (Integer) array[j];
                    }
                }
                if (counter != i) {
                    array[counter] = array[i];
                    array[i] = tempStore;
                }
            }
        }
    }

}
