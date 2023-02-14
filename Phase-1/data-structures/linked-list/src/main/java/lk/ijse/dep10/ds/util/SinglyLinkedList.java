package lk.ijse.dep10.ds.util;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(String value) {
        Node node = new Node(Integer.parseInt(value),null);
        if (size == 0){
            head = node;
            tail = head;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public String toString() {
        String data = "[";
        Node temp = head;
        while (temp != null){
            data += (temp.data + ", ");
            temp = temp.next;
        }
        if (size != 0) data += "\b\b";
        data += "]";
        return data;
    }

    public void clear() {
        head = null;
        tail = head;
        size = 0;
    }

    public boolean contains(String input) {
        Node temp = head;
        while (temp != null){
            if (temp.data == Integer.parseInt(input)) return true;
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        Node temp = head;
        int i = 0;
        while (temp != null){
            if (index == 0){
                head = temp.next;
                return;
            }
            if (index - i == 1){
                temp.next = temp.next.next;
                return;
            }
            if (index == size -1){
                tail = temp.next;
            }
            temp = temp.next;
            i++;
        }
        size--;

        /* sir */

//        if (size == 0) return;
//        if (index == 0){
//            head = head.next;
//        }
//        else {
//            Node temp = head;
//            for (int j = 0; j < index-1; j++) {
//                temp = temp.next;
//            }
//            temp.next = temp.next.next;
//            if (index == size -1) tail = temp;
//        }

    }

    public String get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data +"";
    }
}
class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
