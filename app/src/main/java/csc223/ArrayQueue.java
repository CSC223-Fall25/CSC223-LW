package csc223;

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
        if (this.curr == 0){
            return Integer.MAX_VALUE;
        }
        else{
            curr -= 1;
            return this.data[this.curr];
        }
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
