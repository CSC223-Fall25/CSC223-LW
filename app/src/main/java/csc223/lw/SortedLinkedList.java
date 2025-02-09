package csc223.lw;

public class SortedLinkedList extends DoublyLinkedList{

    public void insert(char item){
        Node newNode = new Node(item);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else if (this.head.next == null){
            if (item < this.head.data){
                newNode.next = this.head;
                this.head.previous = newNode;
                this.head = newNode;
                this.tail = newNode.previous;
            }
            else{
                newNode.previous = this.head;
                this.head.next = newNode;
                this.tail = newNode;
            }
        }
        else {
            this.curr = this.head.next;
            while (this.curr != this.tail){
                if (item < this.curr.data){
                    this.curr.previous.next = newNode;
                    newNode.next = this.curr;
                    newNode.previous = this.curr.previous;
                    this.curr.previous = newNode;
                    break;
                }
                this.curr = this.curr.next;
            }
            if (item < this.tail.data){
                this.tail.previous.next = newNode;
                newNode.next = this.tail;
                newNode.previous = this.tail.previous;
                this.tail.previous = newNode;
            }
            else{
                this.tail.next = newNode;
                newNode.previous = this.tail;
                this.tail = newNode;
            }
        }
    }

    public void remove(char item){
        super.remove(item);
    }

    public char getFirst(){
        return super.getFirst();
    }

    public char getLast(){
        return super.getLast();
    }

    public char get(int index){
        return super.get(index);
    }

    public int size(){
        return super.size();
    }

    public boolean isEmpty(){
        return super.isEmpty();
    }

    public void clear(){
        super.clear();
    }

    public boolean contains(char item){
        return super.contains(item);
    }

    public int indexOf(char item){
        return super.indexOf(item);
    }

    public int lastIndexOf(char item){
        return super.lastIndexOf(item);
    }

    public void reverse(){
        super.reverse();
    }

    public String toString(){
        return super.toString();
    }

    public static void main(String[] args){

    }
}
