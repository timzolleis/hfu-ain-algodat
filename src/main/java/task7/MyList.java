package task7;

import lombok.Getter;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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
        final ListNode<T> node = this.getNodeAtIndex(index).orElseThrow();
        return node.getValue();
    }

    public final T remove(final int index) {
        this.validateIndex(index);
        final ListNode<T> currentNode = this.getNodeAtIndex(index).orElseThrow();
        final ListNode<T> previousNode = this.getNodeAtIndex(index - 1).orElse(null);
        //Navigate to the node to be removed while keeping track of the node before
        if (previousNode == null) {
            this.updateHead(currentNode.getNext());
        } else {
            previousNode.setNext(currentNode.getNext());
        }
        //If we are at the last node, we need to set the tail to the previous node
        if (currentNode.getNext() == null) {
            this.updateTail(previousNode);
        }
        //Decrease the size of the list to reflect the removal
        this.decreaseSize();
        return currentNode.getValue();
    }


    private void updateHead(final ListNode<T> node) {
        this.head = node;
    }

    private void updateTail(final ListNode<T> node) {
        this.tail = node;
    }

    private Optional<ListNode<T>> getNodeAtIndex(final int index) {
        return Stream.iterate(this.head, Objects::nonNull, ListNode::getNext)
                .skip(index)
                .findFirst();
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
