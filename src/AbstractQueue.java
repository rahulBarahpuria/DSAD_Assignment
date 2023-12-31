import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This is the parent abstract class to initiate the Queue using Array and Linked List implementations
 */
abstract public class AbstractQueue {

    /**
     * This is just a reference to the abstract queue.
     * The abstract queue is instantiated based on Array implementation and Linked List Implementation
     */
    public static AbstractQueue abstractQueue;

    /**
     * Adds an element into the queue from the rear side
     *
     * @param item
     */
    abstract public void enqueue(int item);

    /**
     * Display the elements containing in the queue at that moment
     */
    abstract public void displayQueueStatus();

    /**
     * Removes the front element from the queue
     *
     * @return dequeued element as integer
     */
    abstract public int dequeue();

    /**
     * Returns size of the queue
     *
     * @return Queue size as integer
     */
    abstract public int size();

    public static int indx = 0;
    public static int sz = 0;

    /**
     * Array contains integer elements from file content
     */
    public static int[] queueElements = null;

    /**
     * HashSet used to filter out the duplicate input elements
     */
    public static HashSet<Integer> uniqueElements = new HashSet<Integer>();

    /**
     * util method that asks for scanner input during runtime of the program
     */
    public static void takeScannerInput() {
        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        do {
            abstractQueue.displayQueueStatus();
            System.out.println(" | Size: " + abstractQueue.size());
            System.out.println("\nPress any digit (other than 0) to dequeue, or 0 to exit");
            choice = scanner.nextInt();
            if (choice != 0) {
                long start = System.nanoTime();
                System.out.println("Dequeue: " + abstractQueue.dequeue());
                long end = System.nanoTime();
                double diff = (end - start) / 1e6;
                System.out.println("Time taken for dequeue: " + diff);
            }
        } while (choice != 0);
    }

    /**
     * util method that asks for scanner input during runtime of the program for sorted linked list
     */
    public static void takeScannerInputSortedList(SortedLinkedList sortedLinkedList) {
        Scanner scanner = new Scanner(System.in);
        int removeElement = -1;
        do {
            System.out.println("Sorted Linked List:");
            sortedLinkedList.display();
            System.out.println("\nEnter element to remove otherwise enter -1 to exit");
            removeElement = scanner.nextInt();
            if (removeElement != -1) {
                long start = System.currentTimeMillis();
                sortedLinkedList.remove(removeElement);
                long end = System.currentTimeMillis();
                System.out.println("Time Taken to remove an element: " + (end - start));
            }
        } while (removeElement != -1);
    }

    /**
     * util method that reads individual input file contents and store the input unique elements into an array
     *
     * @param filePath
     * @throws FileNotFoundException
     * @throws Exception
     */
    public static void readInputFile(String filePath) throws FileNotFoundException, Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String elementStr = scanner.nextLine();
            int element = Integer.parseInt(elementStr);
            if (uniqueElements.add(element)) {
                queueElements[indx++] = element;
            }
        }
        scanner.close();
    }

    /**
     * computes the total number of unique elements in the input file content, if total elements exceeds the capacity then an Exception is thrown
     *
     * @param filePath
     * @throws FileNotFoundException
     * @throws Exception
     */
    public static void initializeInputFilesArraySize(String filePath) throws FileNotFoundException, Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String elementStr = scanner.nextLine();
            int element = Integer.parseInt(elementStr);
            if (uniqueElements.add(element)) {
                sz++;
            }
        }
    }

    /**
     * reads input elements from command line
     * @param element
     */
    public static void readInputElementsFromCMD(int element) {
        if (uniqueElements.add(element)) {
            queueElements[indx++] = element;
        }
    }

    /**
     * main driver method that executes the whole program. It performs following operations -
     * 1. initialze Queue operations using Array implementation
     * 2. initialize Queue operations using Linked List implementation
     * 3. initialize sorted linked list and its operations
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        writeOutput();
        String inputSource = args[0];
        String[] inputElements = inputSource.split(QueueConstants.DELIMITER);
        for (int i = 0; i < inputElements.length; i++) {
            System.out.print(inputElements[i] + " ");
        }
        if (inputElements[0].endsWith(QueueConstants.TXT_EXTENSION)) {
            for (int x = 0; x < inputElements.length; x++) {
                initializeInputFilesArraySize(inputElements[x]);
            }
            uniqueElements = new HashSet<Integer>();
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
        System.out.println("\n************Queue using Array************");
        abstractQueue = new QueueArrayImpl(QueueConstants.CAPACITY);
        long start = System.nanoTime();
        for (int i = 0; i < queueElements.length; i++) {
            abstractQueue.enqueue(queueElements[i]);
        }
        long end = System.nanoTime();
        double diff = (end - start) / 1e6;
        System.out.println("Time Taken to insert all elements in Array Queue: " + diff + "ms");
        takeScannerInput(); // util method to ask for option to dequeue

        // Queue using Linked List
        System.out.println("\n************Queue using Linked List************");
        abstractQueue = new QueueLinkedListImpl();
        long start1 = System.nanoTime();
        for (int i = 0; i < queueElements.length; i++) {
            abstractQueue.enqueue(queueElements[i]);
        }
        long end1 = System.nanoTime();
        double diff1 = (end1 - start1) / 1e6;
        System.out.println("Time taken to insert all elements in Queue linked list: " + diff1);
        takeScannerInput();

        // Sorted Linked List

        SortedLinkedList sortedList = new SortedLinkedList();
        long startTime = System.nanoTime();
        for (int i = 0; i < queueElements.length; i++) {
            sortedList.insert(queueElements[i]);
        }
        long endTime = System.nanoTime();
        double diffTime = (end - start) / 1e6;
        System.out.println("TimeTaken to insert all elements in sorted linked list: " + diffTime);
        takeScannerInputSortedList(sortedList);
    }

    public static void writeOutput() throws FileNotFoundException {
        String filePath = QueueConstants.OUTPUT_FILE;
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        TeeOutputStream teeOutputStream = new TeeOutputStream(System.out, fileOutputStream);
        System.setOut(new PrintStream(teeOutputStream));
    }
}