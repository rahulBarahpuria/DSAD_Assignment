public class QueueLinkedListImpl extends AbstractQueue{
    private Node front, rear;

    public QueueLinkedListImpl() {
        front = rear = null;
    }

    /**
     * Insert an integer element into queue using Linked List implementation. Also checks for if queue size is full or queue is empty.
     * @param item
     */
    @Override
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    /**
     * remove front element from the queue using Linked List Implementation. Also checks for if queue is empty.
     * @return dequeued integer element
     */
    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    /**
     * check if queue is empty using array implementation
     * @return boolean
     */
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void displayQueueStatus() {
        Node current = front;
        System.out.println("Queue Linked List Status: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
