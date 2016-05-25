public class CircularQueue {
    private static final int DEFAULT_CAPACITY = 5;
    private String[] queue;
    private final int capacity;
    private int size;
    private int front = 0;
    private int rear = 0;

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        queue = new String[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public void enqueue(String item) {
        if (isFull()) {
            throw new QueueFullException("Sorry, Queue is full");
        }
        queue[rear] = item;
        rear = (rear+1) % capacity;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new QueueEmptyException("Sorry, Queue is empty");
        }
        String dequeuedItem = queue[front];
        front = (front + 1) % capacity;
        size--;
        return dequeuedItem;
    }

    public void displayQueue() {
        if (size == 0) {
            throw new QueueEmptyException("Sorry, Queue is empty");
        }
        int curItem = front;
        int remItems = size;
        System.out.println("--FRONT--");
        while (remItems > 0) {
            System.out.println(queue[curItem]);
            curItem = (curItem+1) % capacity;
            remItems--;
        }
        System.out.println("--BACK--");
    }
}
