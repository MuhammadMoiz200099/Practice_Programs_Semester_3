public class myList<M> {

    private static final int capacity = 255;
    private M[] listArray = (M[]) new Object[capacity];
    private int endMark = -1;

    public boolean isEmpty(M item) {
        if(item == this.listArray || this.listArray.length < 0) {
            return true;
        }
        return false;
    }

    public void add(M item) {
        if (this.endMark + 1 < this.listArray.length) {
             endMark++;
             this.listArray[endMark] = item;
        }else {
            M[] newList = (M[]) new Object[this.listArray.length * 2];

            for(int i = 0 ; i < this.listArray.length ; i++) {
                this.listArray[i] = newList[i];
            }
            endMark++;
            this.listArray[endMark] = item;
        }
    }

    public void add(M item , int index) {
        if(this.endMark + 1 < this.listArray.length) {
            this.endMark++;
            for(int i = endMark ; i >= index ; i--) {
                this.listArray[i] = this.listArray[i - 1];
            }
            this.listArray[index] = item;
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
        }
    }

    public void update(M item , int index) {
        this.listArray[index] = item;
    }

    public int search(M item) {
        for (int i = 0 ; i < this.listArray.length ; i++) {
            if(item == this.listArray[i]) {
                return i;
            }
        }
        return -1;
    }

    public void remove(M item) {
        for (int i = 0; i < this.listArray.length ; i++) {
            if(this.listArray[i] == item) {
                for (int j = i ; j < this.listArray.length - 1 ; j++) {
                    this.listArray[j] = this.listArray[j+1];
                    break;
                }
            }
        }
        endMark--;
    }

    public void removeAll(M item) {
        for (int i = 0; i < this.listArray.length ; i++) {
            if(this.listArray[i] == item) {
                for (int j = i ; j < this.listArray.length - 1 ; j++) {
                    this.listArray[j] = this.listArray[j+1];
                }
            }
        }
        endMark--;
    }

    public void print() {
        for (int i =0 ; i < this.endMark + 1 ; i++) {
            System.out.println(this.listArray[i]);
        }
    }


}
