package csc223.lw;

public class NumericTreeStack {
    
    NumericTreeNode[] data;
    int curr;
    int capacity;

    public NumericTreeStack(){
        this.capacity = 10;
        this.data = new NumericTreeNode[this.capacity];
        this.curr = 0;
    }

    public void enqueue(NumericTreeNode item){
        if (this.curr == this.capacity){
            this.capacity = this.capacity * 2;
            NumericTreeNode[] newData = new NumericTreeNode[this.capacity];
            for (int i = 0; i < this.capacity/2; i++){
                newData[i] = this.data[i];
            }
            this.data = newData;
        }
        this.data[curr] = item;
        curr += 1;
    }

    public NumericTreeNode dequeue(){
        if (curr == 0){
            return null;
        }
        NumericTreeNode last = this.data[curr-1];
        //int i = 0;
        /*while (i != this.curr){
            this.data[i] = this.data[i+1];
            i++;
        }*/
        curr -= 1;
        return last;
    }

    public boolean isEmpty(){
        if (this.data[0] == null){
            return true;
        }
        return false;
    }
}
