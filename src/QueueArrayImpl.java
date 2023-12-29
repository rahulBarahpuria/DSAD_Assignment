public class QueueArrayImpl extends AbstractQueue{
    private int[] array;
    private int front, rear, size;

    public QueueArrayImpl(int capacity) {
        array = new int[capacity];
        front = rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(int item) {
        if (rear == array.length - 1) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1)
            front = 0;
        array[++rear] = item;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = array[front++];
        size--;
        if (isEmpty()) {
            front = rear = -1;
        }
        return item;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void displayQueueStatus() {
        System.out.println("Queue Array Status: ");
        for(int i = front; i < (front + size()); i++) {
            System.out.print(array[i] + " ");
        }
    }
}
