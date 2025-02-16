package csc223.lw;

public class SinglyLinkedList implements LinkedList{

    Node curr = null;
    Node head = null;
    Node tail = null;

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
        }
        this.curr = newNode;
        this.tail = newNode;
    }

    public void remove(char item){
        this.curr = this.head;
        if (!isEmpty()){
            if (this.head != null && this.head.data == item){
                this.head = this.head.next;
            }
            while (this.curr != null && this.curr.next != this.tail){
                if  (this.curr.next != null && this.curr.next.data == item){
                    this.curr.next = this.curr.next.next;
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
        if (isEmpty()){
            return '☠';
        }
        return this.head.data;
    }

    public char getLast(){
        if (isEmpty()){
            return '☠';
        }
        return this.tail.data;
    }

    public char get(int index){
        this.curr = this.head;
        int i = 0;
        while (i != index){
            if (this.curr == null){
                return '☠';
            }
            this.curr = this.curr.next;
            i++;
        }
        if (this.curr != null){
            return this.curr.data;
        }
        return '☠';
    }

    public int size(){
        this.curr = this.head;
        int i = 0;
        while (curr != this.tail){
            i++;
            curr= curr.next;
        }
        return i+1;
    }

    public boolean isEmpty(){
        if (this.head == null){
            return true;
        }
        return false;
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.curr = null;
    }

    public boolean contains(char item){
        this.curr = this.head;
        while (this.curr != this.tail){
            if (this.curr.data == item){
                return true;
            }
            this.curr = this.curr.next;
        }
        if (this.tail.data == item){
            return true;
        }
        return false;
    }

    public int indexOf(char item){
        this.curr = this.head;
        int i = 0;
        while (this.curr != this.tail){
            if (this.curr.data == item){
                return i;
            }
            this.curr = this.curr.next;
            i++;
        }
        if (this.tail.data == item){
            return i;
        }
        return -1;
    }

    public int lastIndexOf(char item){
        this.curr = this.head;
        int lastIndex = -1;
        int i = 0;
        while (this.curr != this.tail){
            if (this.curr.data == item){
                lastIndex = i;
            }
            this.curr = this.curr.next;
            i++;
        }
        if (this.tail.data == item){
            lastIndex = i;
        }
        return lastIndex;
    }

    public void reverse(){
        Node prev = null;
        Node next = null;
        this.curr = this.head;
        while (this.curr != null) {
            next = this.curr.next;
            this.curr.next = prev;
            if (prev == null){
                this.tail = this.curr;
            }
            prev = this.curr;
            this.curr = next;
        }
        this.head = prev;
    }

    public String toString(){
        String result = "";
        if (isEmpty()){
            return result;
        }
        this.curr = this.head;
        while (this.curr != null && this.curr != this.tail){
            result = result + this.curr.data;
            this.curr = this.curr.next;
        }
        if (this.curr != null){
            result = result + this.curr.data;
        }
        return result;
    }

    public static void main(String[] args){
        SinglyLinkedList s = new SinglyLinkedList();
        s.insert('e');
        s.insert('w');
        s.insert('w');
        s.insert('f');
        s.insert('w');
        s.insert('w');
        s.insert('w');
        s.insert('p');
        System.out.println(s.toString());
        s.reverse();
        System.out.println(s.toString());
    }
}
