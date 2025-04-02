package csc223.lw;

public class ArrayQueue implements Queue{

    int[] data;
    int curr;
    int capacity;

    public ArrayQueue(){
        this.capacity = 10;
        this.data = new int[this.capacity];
        this.curr = 0;
    }

    public void enqueue(int item){
        if (this.curr == this.capacity){
            this.capacity = this.capacity * 2;
            int[] newData = new int[this.capacity];
            for (int i = 0; i < this.capacity/2; i++){
                newData[i] = this.data[i];
            }
            this.data = newData;
        }
        this.data[curr] = item;
        curr += 1;
    }

    public int dequeue(){
        int first = this.data[0];
        int i = 0;
        while (i != this.curr){
            this.data[i] = this.data[i+1];
            i++;
        }
        curr -= 1;
        return first;
    }

    public int peek(){
        return this.data[this.curr-1];
    }

    public boolean isEmpty(){
        return this.curr == 0;
    }

    public int size(){
        return this.curr;
    }

    public static void main(String[] args){

    }
}
