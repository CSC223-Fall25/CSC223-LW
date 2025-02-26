package csc223.lw;

public class DoublyLinkedList extends SinglyLinkedList{

    public void insert(char item){
        Node newNode = new Node(item);
        if (this.head == null){
            this.head = newNode;
        }
        else if (this.head.next == null){
            this.head.next = newNode;
        }
        if (this.curr != null){
            this.curr.next = newNode;
            newNode.previous = this.curr;
        }
        this.curr = newNode;
        this.tail = newNode;
    }

    public void remove(char item){
        this.curr = this.head;
        if (!isEmpty()){
            if (this.head != null && this.head.data == item){
                this.head = this.head.next;
                this.head.previous = null;
            }
            while (this.curr != null && this.curr.next != this.tail){
                if  (this.curr.next != null && this.curr.next.data == item){
                    this.curr.next = this.curr.next.next;
                    this.curr.next.previous = this.curr;
                }
                else{
                    this.curr = this.curr.next;
                }
            }
            if (this.tail != null && this.tail.data == item){
                this.tail = null;
            }
        }
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
