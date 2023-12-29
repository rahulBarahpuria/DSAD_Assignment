public class QueueArrayImpl extends AbstractQueue{
    private int[] queueArray;
    private int front, rear, size;

    public QueueArrayImpl(int capacity) {
        queueArray = new int[capacity];
        front = rear = -1;
        size = 0;
    }

    /**
     * Insert an integer element into queue using Array implementation. Also checks for if queue size is full or queue is empty.
     * @param item
     */
    @Override
    public void enqueue(int item) {
        if (rear == queueArray.length - 1) {
            System.out.println("Queue is full. ignoring element: " + item);
            return;
        }
        if (front == -1)
            front = 0;
        queueArray[++rear] = item;
        size++;
    }

    /**
     * remove front element from the queue using Array Implementation. Also checks for if queue is empty.
     * @return dequeued integer element
     */
    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queueArray[front++];
        size--;
        if (isEmpty()) {
            front = rear = -1;
        }
        return item;
    }

    /**
     * check if queue is empty using array implementation
     * @return boolean
     */
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
            System.out.print(queueArray[i] + " ");
        }
    }
}
