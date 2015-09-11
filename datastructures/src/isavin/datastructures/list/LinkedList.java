package isavin.datastructures.list;

/**
 * Created by isavin on 10.09.2015.
 */
public class LinkedList<E> {

    private Node head;

    public LinkedList (E item) {
        head = new Node();
        head.item = item;
    }

    public void add(E element) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node next = new Node();
        next.item = element;
        current.next = next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean remove(E object) {
        if (isEmpty()) {
            return false;
        }
        Node current = head;
        if (current.item == object) {
            current.item = null;
            head = current.next;
            return true;
        }
        while (current.next != null) {
            if (current.next.item == object) {
                current.next.item = null;
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        Node current = head;
        System.out.print("[" + current.item);
        while (current.next != null) {
            current = current.next;
            System.out.print(" " + current.item );
        }
        System.out.println("]");
    }

    private static class Node<E> {
        private Node next;
        private E item;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(5);
        list.printList();
        list.add(7);
        list.add(9);
        list.printList();
        System.out.println("Removing 7: " + list.remove(7));
        list.printList();
        list.add(11);
        list.printList();
        System.out.println("Removing 5: " + list.remove(5));
        list.printList();
        System.out.println("Removing 13: " + list.remove(13));
        list.printList();
        System.out.println("Removing 11: " + list.remove(11));
        System.out.println("Removing 9: " + list.remove(9));
        list.printList();
        System.out.println("Removing 90: " + list.remove(90));
    }
}
