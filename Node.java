public class Node {
    Node next;
    Object data;

    public Node(Object data) {
        this(data,null);
    }

    public Node(Object data, Node next) {
        this.next = next;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
