import java.util.Arrays;

public class Queue {

    String[] queueArray;
    int back = -1;
    int queueSize;

    public Queue(int size) {
        this.queueSize = size;
        queueArray = new String[size];
        Arrays.fill(queueArray, "-1");
    }

    public void enqueue(String item) throws IndexOutOfBoundsException {
        if (back+1 >= queueSize) {
            throw new IndexOutOfBoundsException("Sorry, Queue is full");
        }
        back++;
        queueArray[back] = item;
        System.out.println(item + " enqueued at index " + back);
    }

    public String dequeue() {
        if (back == -1) {
            return null;
        } else {
            String dequeuedItem = queueArray[0];
            //shift all the elements over
            for (int i = 0; i < back; i++) {
                queueArray[i] = queueArray[i+1];
            }
            back--;
            return dequeuedItem;
        }
    }

    public int getItemCount() {
        return back+1;
    }

    public void displayQueue() {
        if (back == -1) {
            System.out.println("Empty queue");
            return;
        }
        System.out.println("--FRONT--");
        for (int i = 0; i < back+1; i++) {
            System.out.println(queueArray[i]);
        }
        System.out.println("--BACK--");
    }

    public int getQueueCapacity() {
        return queueSize;
    }

    public int getBackIndex() {
        return back;
    }
}
