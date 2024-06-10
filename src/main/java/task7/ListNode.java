package task7;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode<T> {
    private T value;
    private ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
        this.next = null;
    }
}
