public class SortedLinkedList {
    private Node head;

    public SortedLinkedList() {
        this.head = null;
    }

    public void insert(int item) {
        Node newNode = new Node(item);

        if (head == null || item < head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data < item) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void remove(int item) {
        if (head == null) {
            System.out.println("List is empty. Cannot remove.");
            return;
        }

        if (head.data == item) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != item) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Element not found. Cannot remove.");
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
