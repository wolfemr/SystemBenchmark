package com.wolfe.systembenchmark;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * Primary class.
 */
public class SystemBenchmark {
    /**
     *
     * @param args Optional parameters.
     */
    public static void main(String[] args) {

        int size = 1000000;
        double testStartTime = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Press enter to begin the test.");

        try {
            scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        runArrayListBenchmark(size);
        runLinkedListBenchmark(size);
        runHashTableBenchmark(size);
        runQueueBenchmark(size);

        double testEndTime = System.currentTimeMillis();
        double testTime = (testEndTime - testStartTime) / 1000.0;
        System.out.println("Total test time: " + testTime + " seconds.");
    }

    /**
     * Contains logic for running the ArrayList population/depopulation benchmark.
     *
     * @param size Size of data structure to be passed to population method.
     */
    public static void runArrayListBenchmark(int size) {

        System.out.println("Beginning ArrayList test...");

        double testStartTime = System.currentTimeMillis();

        System.out.println("Populating ArrayList...");

        ArrayList<Integer> populatedArrayList = populateArrayList(size);

        System.out.println("ArrayList populated. \nArrayList size: " + populatedArrayList.size());

        System.out.println("Depopulating ArrayList...");
        ArrayList<Integer> depopulatedArrayList = depopulateArrayList(populatedArrayList);

        System.out.println("ArrayList depopulated. Arraylist size: " + depopulatedArrayList.size());

        double testEndTime = System.currentTimeMillis();
        double testTime = testEndTime - testStartTime;

        System.out.println("ArrayList test complete.");
        System.out.println("Total elapsed time: " + testTime + "ms\n");
    }

    /**
     * Contains logic for running the LinkedList population/depopulation benchmark.
     *
     * @param size Size of data structure to be passed to population method.
     */
    public static void runLinkedListBenchmark(int size) {

        System.out.println("Beginning LinkedList test...");

        double testStartTime = System.currentTimeMillis();

        System.out.println("Populating LinkedList...");

        LinkedList<Integer> populatedLinkedList = populateLinkedLIst(size);

        System.out.println("LinkedList populated. \nLinkedList size: " + populatedLinkedList.size());

        System.out.println("Depopulating LinkedList...");
        LinkedList<Integer> depopulatedLinkedList = depopulateLinkedList(populatedLinkedList);

        System.out.println("LinkedList depopulated. \nLinkedList size: " + depopulatedLinkedList.size());

        double testEndTime = System.currentTimeMillis();
        double testTime = testEndTime - testStartTime;

        System.out.println("LinkedList test complete.");
        System.out.println("Total elapsed time: " + testTime + "ms\n");
    }

    /**
     * Contains logic for running the Hashtable population/depopulation benchmark.
     *
     * @param size Size of data structure to be passed to population method.
     */
    public static void runHashTableBenchmark(int size) {

        System.out.println("Beginning Hashtable test...");

        double testStartTime = System.currentTimeMillis();

        System.out.println("Populating Hashtable...");

        Hashtable<Integer, Integer> populatedHashTable = populateHashtable(size);

        System.out.println("Hashtable populated. \nHashtable size: " + populatedHashTable.size());

        System.out.println("Depopulating Hashtable...");

        Hashtable<Integer, Integer> depopulatedHashtable = depopulateHashTable(populatedHashTable);

        System.out.println("Hashtable depopulated. \nHashtable size: " + depopulatedHashtable.size());

        double testEndTime = System.currentTimeMillis();
        double testTime = testEndTime - testStartTime;

        System.out.println("Hashtable run complete.");
        System.out.println("Total elapsed time: " + testTime + "ms\n");
    }

    /**
     * Contains logic for running the Queue population/depopulation benchmark.
     *
     * @param size Size of data structure to be passed to population method.
     */
    public static void runQueueBenchmark(int size) {

        System.out.println("Beginning Queue test...");

        double testStartTime = System.currentTimeMillis();

        System.out.println("Populating Queue...");

        Queue<Integer> populatedQueue = populateQueue(size);

        System.out.println("Queue populated. \nQueue size: " + populatedQueue.size());

        System.out.println("Depopulating Queue...");

        Queue<Integer> depopulatedQueue = depopulateQueue(populatedQueue);

        System.out.println("Queue depopulated. \nQueue size: " + depopulatedQueue.size());

        double testEndTime = System.currentTimeMillis();
        double testTime = testEndTime - testStartTime;

        System.out.println("Queue run complete.");
        System.out.println("Total elapsed time: " + testTime + "ms\n");
    }

    /**
     * Iteratively removes elements of the given ArrayList and returns the emptied ArrayList.
     *
     * @param arrayList ArrayList to be depopulated.
     * @return Return empty ArrayList.
     */
    public static ArrayList<Integer> depopulateArrayList(ArrayList<Integer> arrayList) {

        while(!arrayList.isEmpty()){
            arrayList.remove(0);
        }
        return arrayList;
    }

    /**
     * Creates and populates an ArrayList of given size with randomly generated integers, then returns the
     * filled ArrayList.
     *
     * @param arrayListSize Expected size of populated ArrayList.
     * @return Return populated ArrayList.
     */
    public static ArrayList<Integer> populateArrayList(int arrayListSize) {

        ArrayList<Integer> arrayListOfIntegers = new ArrayList<>();

        for(int i = 0; i < arrayListSize; i++){
            arrayListOfIntegers.add(ThreadLocalRandom.current().nextInt());
        }

        return arrayListOfIntegers;
    }

    /**
     * Iteratively removes elements of the given LinkedList and returns the emptied LinkedList.
     *
     * @param linkedList LinkedList to be depopulated.
     * @return Return empty LinkedList.
     */
    public static LinkedList<Integer> depopulateLinkedList(LinkedList<Integer> linkedList) {

        while(!linkedList.isEmpty()){
            linkedList.remove(0);
        }

        return linkedList;
    }

    /**
     * Creates and populates a LinkedList of given size with randomly generated integers, then returns the
     * filled LinkedList.
     *
     * @param linkedListSize Expected size of populated LinkedList.
     * @return Return populated LinkedList.
     */
    public static LinkedList<Integer> populateLinkedLIst(int linkedListSize) {

        LinkedList<Integer> linkedListOfIntegers = new LinkedList<>();

        for(int i = 0; i < linkedListSize; i++){
            linkedListOfIntegers.add(ThreadLocalRandom.current().nextInt());
        }

        return linkedListOfIntegers;
    }

    /**
     * Iteratively removes elements of the given Hashtable and returns the emptied Hashtable.
     *
     * @param hashTable Hashtable to be depopulated.
     * @return Return empty Hashtable.
     */
    public static Hashtable<Integer, Integer> depopulateHashTable(Hashtable<Integer, Integer> hashTable) {

        Iterator<Map.Entry<Integer, Integer>> iterator = hashTable.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            iterator.remove();
        }

        return hashTable;
    }

    /**
     * Creates and populates a Hashtable of given size with randomly generated integers, then returns the
     * filled Hashtable.
     *
     * @param hashMapSize Expected size of populated Hashtable.
     * @return Return populated Hashtable.
     */
    public static Hashtable<Integer, Integer> populateHashtable(int hashMapSize) {

        Hashtable<Integer, Integer> hashtableOfIntegers = new Hashtable<>();

        for(int i = 0; i < hashMapSize; i++) {
            hashtableOfIntegers.put(i, ThreadLocalRandom.current().nextInt());
        }

        return hashtableOfIntegers;
    }

    /**
     * Iteratively removes elements of the given Queue and returns the emptied Queue.
     *
     * @param queue Queue to be depopulated.
     * @return Return empty Queue.
     */
    public static Queue<Integer> depopulateQueue(Queue<Integer> queue) {

        while(!queue.isEmpty()){
            queue.remove();
        }

        return queue;
    }

    /**
     * Creates and populates a Queue of given size with randomly generated integers, then returns the
     * filled Queue.
     *
     * @param queueSize Expected size of populated Queue.
     * @return Return populated Queue.
     */
    public static Queue<Integer> populateQueue(int queueSize) {

        Queue<Integer> queueOfIntegers = new LinkedList<>();

        for(int i = 0; i < queueSize; i++) {
            queueOfIntegers.add(ThreadLocalRandom.current().nextInt());
        }

        return queueOfIntegers;
    }
}
