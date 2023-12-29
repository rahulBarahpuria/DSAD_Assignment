import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract public class AbstractQueue {
    public static AbstractQueue abstractQueue;

    abstract public void enqueue(int item);

    abstract public void displayQueueStatus();

    abstract public int dequeue();

    abstract public int size();

    public static int indx = 0;
    public static int sz = 0;
    public static int[] queueElements = null;
    public static boolean[] addedElements = new boolean[QueueConstants.CAPACITY];

    public static void takeScannerInput() {
        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        do {
            abstractQueue.displayQueueStatus();
            System.out.println("Size: " + abstractQueue.size());
            System.out.println("\nPress any key (other than 0) to dequeue, or 0 to exit");
            choice = scanner.nextInt();
            if (choice != 0) {
                System.out.println("Dequeue: " + abstractQueue.dequeue());

            }
        } while (choice != 0);
    }

    public static void takeScannerInputSortedList(SortedLinkedList sortedLinkedList) {
        Scanner scanner = new Scanner(System.in);
        int removeElement = -1;
        do {
            System.out.println("Sorted Linked List:");
            sortedLinkedList.display();
            System.out.println("\nEnter element to remove otherwise enter -1 to exit");
            removeElement = scanner.nextInt();
            if (removeElement != -1) {
                sortedLinkedList.remove(removeElement);
            }
        } while (removeElement != -1);
    }

    public static void readInputFile(String filePath) throws FileNotFoundException, Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String elementStr = scanner.nextLine();
            int element = Integer.parseInt(elementStr);
            if (!addedElements[element]) {
                queueElements[indx++] = element;
                addedElements[element] = true;
            }
        }
        scanner.close();
    }

    public static void initializeInputFilesArraySize(String filePath) throws FileNotFoundException, Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String elementStr = scanner.nextLine();
            int element = Integer.parseInt(elementStr);
            if (!addedElements[element]) {
                addedElements[element] = true;
                sz++;
            }
        }
        if (sz > QueueConstants.CAPACITY) {
            throw new Exception("Input size is too large");
        }
    }

    public static void readInputElementsFromCMD(int element) {
        if (!addedElements[element]) {
            queueElements[indx++] = element;
            addedElements[element] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        String inputSource = args[0];
        String[] inputElements = inputSource.split(",");
        for (int i = 0; i < inputElements.length; i++) {
            System.out.print(inputElements[i] + " ");
        }
        if (inputElements[0].endsWith(QueueConstants.TXT_EXTENSION)) {
            for (int x = 0; x < inputElements.length; x++) {
                initializeInputFilesArraySize(inputElements[x]);
            }
            addedElements = new boolean[QueueConstants.CAPACITY];
            queueElements = new int[sz];
            for (int x = 0; x < inputElements.length; x++) {
                readInputFile(inputElements[x]); // read input
            }
        } else {
            queueElements = new int[inputElements.length];
            for (int x = 0; x < inputElements.length; x++) {
                int element = Integer.parseInt(inputElements[x]);
                readInputElementsFromCMD(element);
            }
        }

        // Queue using Array
        abstractQueue = new QueueArrayImpl(QueueConstants.CAPACITY);
        for (int i = 0; i < queueElements.length; i++) {
            abstractQueue.enqueue(queueElements[i]);
        }
        System.out.println("\n************Queue using Array************");
        takeScannerInput(); // util method to ask for option to dequeue

        // Queue using Linked List
        abstractQueue = new QueueLinkedListImpl();
        for (int i = 0; i < queueElements.length; i++) {
            abstractQueue.enqueue(queueElements[i]);
        }
        System.out.println("\n************Queue using Linked List************");
        takeScannerInput();

        // Sorted Linked List
        SortedLinkedList sortedList = new SortedLinkedList();
        for (int i = 0; i < queueElements.length; i++) {
            sortedList.insert(queueElements[i]);
        }
        takeScannerInputSortedList(sortedList);
    }
}