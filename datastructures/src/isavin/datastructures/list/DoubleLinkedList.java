package isavin.datastructures.list;

import java.util.NoSuchElementException;

/**
 * Created by isavin on 11.09.2015.
 */
public class DoubleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public DoubleLinkedList(E e) {
        addLast(e);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(E e) {
        Node<E> h = head;
        Node<E> newNode = new Node<>(null, e, h);

        head = newNode;
        if (h == null) {
            tail = newNode;
        } else {
            h.prev = newNode;
        }
    }

    public void addLast(E e) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(t, e, null);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> h = head;
        Node<E> next = h.next;
        E element = h.item;
        h.item = null;
        h.next = null;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
        }
        return element;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> t = tail;
        Node<E> prev = t.prev;
        E element = t.item;
        t.item = null;
        t.next = null;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        return element;
    }

    public boolean remove(E object) {
        if (isEmpty()) {
            return false;
        }
        Node<E> current = head;
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
        Node<E> current = head;
        System.out.print("[" + current.item);
        while (current.next != null) {
            current = current.next;
            System.out.print(" " + current.item );
        }
        System.out.println("]");
    }

    public void printReverseList() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        Node<E> current = tail;
        System.out.print("[" + current.item);
        while (current.prev != null) {
            current = current.prev;
            System.out.print(" " + current.item );
        }
        System.out.println("]");
    }

    private static class Node<E> {
        private Node<E> next;
        private Node<E> prev;
        private E item;

        Node() {}
        Node(Node<E> prev, E e, Node<E> next) {
            this.prev = prev;
            this.item = e;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(5);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.printList();
        list.printReverseList();
        while (!list.isEmpty()) {
            list.removeLast();
            list.printList();
        }
    }
}
