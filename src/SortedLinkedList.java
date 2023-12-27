public class SortedLinkedList {
    public Node head;
    public Node ptr;

    public static void main(String args[]) {
        /**
         * to do
         */
    }

    boolean validateInput(String input) {
        /**
         // split input string with comma as a delimiter
         // validates input
         // returns Boolean
         **/
        return false; // to do
    }

    public void takeScannerInput () {
        /**
         * present menu items nd ask input from scanner, process the input similarly as like from cmd
         */
    }

    Node insert(String input) {
        /**
         Object[] inputDataArray = readInputSource(input);
         Object[] updatedDataArray = ignoreDuplicates(inputDataArray)
         // if list is empty then we will create a head node and add the data or else
         // or else iterate through the list, check element is greater or lesser and insert at corresponding
         position
         // returns head node
         displayQueue()
         **/
        return null; // to do
    }

    Node remove(Object[] tempArray) {
        /**
         // for each element find position by traversing the linked list, then cut out the element and update
         the link
         // log the removal in a file or cmd and returns the head node
         displayQueue()
         **/
        return null; // to do
    }

    int search(String elem, Node head) {
        /**
         // get the existing data from linked list by traversing with the help of the head node and check if
         element is there and return it's position
         **/
        return 0; // to do
    }

    Object[] readInputSource (String input) {
        /**
         // Split with delimiter and check each element ends with .csv or .txt call
         readInputViaFileSystem(inputArray), otherwise call readInputViaCMD(inputArray)
         // return the array returned by the called methods
         }
         Object[] readInputViaCMD (String input){
         // push to a temporary array and return that array
         }
         Object[] readInputViaFileSystem (String[] files){
         // check count of files and iterate through each of them
         // read file contents
         Object[] tempArray;
         // push to a temporary array and return that array
         **/
        return null; // to do
    }
    Object[] ignoreDuplicates (Object[] inputDataArray) {
        /**
         // iterate inputDataArray and ensure no duplicates are present -> for each i ensure there is no other
         i with brute force algorithm, if it is found just remove the recurrence, shift the array and then
         continue checking till the different element, repeat the steps for every element
         // get the existing data from queueData by traversing and and remove duplicates if present from
         inputDataArray (use search(elem, head))
         // will be checking for other ways to achieve the above
         // return inputDataArray
         }
         void displayList (Node head) {
         // write the current contents of list in a file
         **/
        return null; // to do
    }

}
