package task7;

import lombok.Getter;

public class MyList<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    @Getter
    private int size;


    public void add(final T element) {
        final ListNode<T> newNode = new ListNode<>(element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        this.increaseSize();
    }

    public final T get(final int index) {
        this.validateIndex(index);
        ListNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    public final T remove(final int index) {
        this.validateIndex(index);
        ListNode<T> currentNode = this.head;
        ListNode<T> previousNode = null;
        //Navigate to the node to be removed while keeping track of the node before
        for (int i = 0; i < index; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        //If we dont have a previous node, we are removing the head, so we need to update this.head
        if (previousNode == null) {
            this.head = currentNode.getNext();
        } else {
            previousNode.setNext(currentNode.getNext());
        }
        //If we are at the last node, we need to set the tail to the previous node
        if (currentNode.getNext() == null) {
            this.tail = previousNode;
        }
        //Decrease the size of the list to reflect the removal
        this.decreaseSize();
        return currentNode.getValue();
    }


    private void validateIndex(final int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    private void increaseSize() {
        size++;
    }

    private void decreaseSize() {
        size--;
    }


}
