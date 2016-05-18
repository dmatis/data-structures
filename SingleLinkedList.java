public class SingleLinkedList {

    private Node head;
    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Object data) {
        //find the end of the ll then update next
        Node tmpNode = new Node(data);
        Node curr = head;

        if (head == null) {
            head = tmpNode;
        } else {
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(tmpNode);
        }
        this.size++;
    }

    public void delete(Object data) {
        //Head is being deleted
        if (head.getData() == data) {
            head = head.getNext();
            size--;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                if (temp.getNext().getData().equals(data)) {
                    temp.next = temp.next.next;
                    size--;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.getData().toString());
            curr = curr.getNext();
        }
    }

    public static void main(String[] args) {

        SingleLinkedList myLL = new SingleLinkedList();
        myLL.add(1);
        myLL.add(2);
        myLL.add(3);
        System.out.println("Before size is: " + myLL.getSize());

        myLL.delete(4);
        myLL.printList();
        System.out.println("After deletion, size is: " + myLL.getSize());
    }

    private class Node {
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
}
