package csc223.lw;

public class TreeQueue {

    TreeNode[] data;
    int curr;
    int capacity;

    public TreeQueue(){
        this.capacity = 10;
        this.data = new TreeNode[this.capacity];
        this.curr = 0;
    }

    public void enqueue(TreeNode item){
        if (this.curr == this.capacity){
            this.capacity = this.capacity * 2;
            TreeNode[] newData = new TreeNode[this.capacity];
            for (int i = 0; i < this.capacity/2; i++){
                newData[i] = this.data[i];
            }
            this.data = newData;
        }
        this.data[curr] = item;
        curr += 1;
    }

    public TreeNode dequeue(){
        TreeNode first = this.data[0];
        int i = 0;
        while (i != this.curr){
            this.data[i] = this.data[i+1];
            i++;
        }
        curr -= 1;
        return first;
    }

    public boolean isEmpty(){
        if (this.data[0] == null){
            return true;
        }
        return false;
    }

}
