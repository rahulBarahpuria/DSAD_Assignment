abstract public class AbstractQueue {
    AbstractQueue abstractQueue;

    public static void main(String[] input) {
        System.out.println("Hello World");
        String action = input[0];
        String data = input[1];
    }

    public boolean validateInput(String[] input) {
        // validate input - action and inputData
        return false; // to do
    }

    public Object[] ignoreDuplicate(Object[] inputDataArr) {
        /**
         // iterate inputDataArray and ensure no duplicates are present -> for each i ensure there is no other
         i with brute force algorithm, if it is found just remove the recurrence, shift the array and then
         continue checking till the different element, repeat the steps for every element
         // get the existing data from queueData by traversing and and remove duplicates if present from
         inputDataArray (use queueimpl.searchQueue(elem, queueimpl.queueData))
         // will be checking for other ways to achieve the above
         // return inputDataArray
         **/
        return null; // to do
    }

    Object[] readInputSource(String data) {
        String[] dataElements = data.split(",");
        if (dataElements.length > 1) {
            for (int i = 0; i < dataElements.length; i++) {
                if (dataElements[i].endsWith(QueueConstants.TXT_EXTENSION) || dataElements[i].endsWith(QueueConstants.CSV_EXTENSION)) {
                    // call readInputViaFile (String dataElements[i])
                } else {
                    // call readInputViaCMD (String dataElements)
                }
            }
        }
        return null; // to do
    }

    Object[] readInputViaFile(String fileName) {
        // read file and return its contents in an array
        return null; // to do
    }

    Object[] readInputViaCMD(String fileName) {
        // read single element from cmd and store in an array and return that array
        return null; // to do
    }

    abstract public void enqueue(Object element);

    abstract public void dequeue();

}