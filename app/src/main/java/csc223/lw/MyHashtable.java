package csc223.lw;

import java.util.ArrayList;

public class MyHashtable {
    
    int capacity = 10;
    ArrayList<Object>[] hashtable = new ArrayList[capacity];

    public MyHashtable(){
        for (int i = 0; i < capacity; i++){
            ArrayList<Object> n = new ArrayList<Object>();
            hashtable[i] = n;
        }
    }

    public void put(String key, int value){
        int index = Math.abs(key.hashCode()) % capacity;
        hashtable[index].add(0, value);
        hashtable[index].add(0, key);
    }

    public Integer get(String key){
        int index = Math.abs(key.hashCode()) % capacity;
        for (int i = 0; i < hashtable[index].size(); i += 2){
            if (hashtable[index].get(i).equals(key)){
                return (int)hashtable[index].get(i+1);
            }
        }
        return null;
    }

    public void remove(String key){
        int index = Math.abs(key.hashCode()) % capacity;
        for (int i = 0; i < hashtable[index].size(); i += 2){
            if (hashtable[index].get(i).equals(key)){
                hashtable[index].remove(i);
                hashtable[index].remove(i);
            }
        }
    }

    public boolean containsKey(String key){
        int index = Math.abs(key.hashCode()) % capacity;
        for (int i = 0; i < hashtable[index].size(); i += 2){
            if (hashtable[index].get(i).equals(key)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        int result = 0;
        for (int i = 0; i < capacity; i++){
            result += hashtable[i].size()/2;
        }
        return result;
    }

    public static void main(String[] args){
        MyHashtable h = new MyHashtable();
        h.put("g", 1);
        h.put("a", 5);
        h.put("6", 2);
        h.put("M", 9);
        h.remove("g");
        System.out.println(h.size());

    }

}
