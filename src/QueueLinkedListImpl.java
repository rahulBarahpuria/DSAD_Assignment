public class QueueLinkedListImpl extends AbstractQueue{
    private Node front, rear;

    public QueueLinkedListImpl() {
        front = rear = null;
    }

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
