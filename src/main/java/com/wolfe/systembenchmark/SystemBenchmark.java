package com.wolfe.systembenchmark;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * Primary class.
 */
public class SystemBenchmark {

    private static final int workerCount = 5;
    private static final int workerTasks = 5;
    private static final Logger logger = LogManager.getLogger("tasklog");

    /**
     *
     * @param args Optional parameters.
     */
    public static void main(String[] args) throws InterruptedException {

        int size = 1000000;

        ExecutorService executorService = Executors.newFixedThreadPool(workerCount);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Press enter to begin the test.");

        try {
            scanner.nextLine();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        double testStartTime = System.currentTimeMillis();

        // BEGIN ArrayList Test Block
        for (int i = 1; i <= workerCount; i++) {
            int workerNumber = i;
            executorService.submit(() -> runArrayListBenchmark(size, workerNumber));
        }
        //END ArrayList Test Block


        //BEGIN LinkedList Test Block
        for (int i = 1; i <= workerCount; i++) {
            int workerNumber = i;
            executorService.submit(() -> runLinkedListBenchmark(size, workerNumber));
        }
        //END LinkedList Test Block


        //BEGIN HashTable Test Block
        for (int i = 1; i <= workerCount; i++) {
            int workerNumber = i;
            executorService.submit(() -> runHashTableBenchmark(size, workerNumber));
        }
        //END HashTable Test BLock


        //BEGIN Queue Test Block
        for (int i = 1; i <= workerCount; i++) {
            int workerNumber = i;
            executorService.submit(() -> runQueueBenchmark(size, workerNumber));
        }
        //END Queue Test Block

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error(e.getMessage());
        }

        double testEndTime = System.currentTimeMillis();
        double testTime = (testEndTime - testStartTime) / 1000.0;
        logger.info("Total test time: {} seconds.", testTime);

        // Simulate Error message for logging
        simulateError();
    }

    /**
     * Contains logic for running the ArrayList population/depopulation benchmark.
     *
     * @param size Size of data structure to be passed to population method.
     */
    public static void runArrayListBenchmark(int size, int workerNumber) {

        for (int task = 1; task <= workerTasks; task++) {

            logger.info("Worker {} beginning ArrayList test {}", workerNumber, task);

            try {
                if (Math.random() < 0.05) {
                    logger.warn("Worker {} running ArrayList test {} failed!", workerNumber, task);
                } else {

                    double testStartTime = System.currentTimeMillis();

                    ArrayList<Integer> populatedArrayList = populateArrayList(size);
                    ArrayList<Integer> depopulatedArrayList = depopulateArrayList(populatedArrayList);

                    double testEndTime = System.currentTimeMillis();
                    double testTime = testEndTime - testStartTime;

                    logger.info("Worker {} ArrayList test {} complete.", workerNumber, task);
                    logger.info("Total ArrayList test {} time: {} ms.", task, testTime);

                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Contains logic for running the LinkedList population/depopulation benchmark.
     *
     * @param size Size of data structure to be passed to population method.
     */
    public static void runLinkedListBenchmark(int size, int workerNumber) {

        for (int task = 1; task <= workerTasks; task++) {

            logger.info("Worker {} beginning LinkedList test {}", workerNumber, task);

            try {
                if (Math.random() < 0.05) {
                    logger.warn("Worker {} running LinkedList test {} failed!", workerNumber, task);
                } else {
                    double testStartTime = System.currentTimeMillis();

                    LinkedList<Integer> populatedLinkedList = populateLinkedLIst(size);
                    LinkedList<Integer> depopulatedLinkedList = depopulateLinkedList(populatedLinkedList);

                    double testEndTime = System.currentTimeMillis();
                    double testTime = testEndTime - testStartTime;

                    logger.info("Worker {} LinkedList test {} complete.", workerNumber, task);
                    logger.info("Total LinkedList test {} time: {} ms.", task, testTime);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Contains logic for running the Hashtable population/depopulation benchmark.
     *
     * @param size Size of data structure to be passed to population method.
     */
    public static void runHashTableBenchmark(int size, int workerNumber) {

        for (int task = 1; task <= workerTasks; task++) {

            logger.info("Worker {} beginning HashTable test {}", workerNumber, task);

            try {
                if (Math.random() < 0.05) {
                    logger.warn("Worker {} running HashTable test {} failed!", workerNumber, task);
                } else {

                    double testStartTime = System.currentTimeMillis();

                    Hashtable<Integer, Integer> populatedHashTable = populateHashtable(size);
                    Hashtable<Integer, Integer> depopulatedHashtable = depopulateHashTable(populatedHashTable);

                    double testEndTime = System.currentTimeMillis();
                    double testTime = testEndTime - testStartTime;

                    logger.info("Worker {} HashTable test {} complete.", workerNumber, task);
                    logger.info("Total HashTable test {} time: {} ms.", task, testTime);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Contains logic for running the Queue population/depopulation benchmark.
     *
     * @param size Size of data structure to be passed to population method.
     */
    public static void runQueueBenchmark(int size, int workerNumber) {

        for (int task = 1; task <= workerTasks; task++) {

            logger.info("Worker {} beginning Queue test {}", workerNumber, task);

            try {
                if (Math.random() < 0.05) {
                    logger.warn("Worker {} running Queue test {} failed!", workerNumber, task);
                } else {

                    double testStartTime = System.currentTimeMillis();

                    Queue<Integer> populatedQueue = populateQueue(size);
                    Queue<Integer> depopulatedQueue = depopulateQueue(populatedQueue);

                    double testEndTime = System.currentTimeMillis();
                    double testTime = testEndTime - testStartTime;

                    logger.info("Worker {} Queue test {} complete.", workerNumber, task);
                    logger.info("Total Queue test {} time: {} ms.", task, testTime);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Iteratively removes elements of the given ArrayList and returns the emptied ArrayList.
     *
     * @param arrayList ArrayList to be depopulated.
     * @return Return empty ArrayList.
     */
    public static ArrayList<Integer> depopulateArrayList(ArrayList<Integer> arrayList) {

        /* SLOWER METHOD
        while(!arrayList.isEmpty()){
            arrayList.remove(0);
        }*/

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            arrayList.remove(i);
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

    public static void simulateError() {
        try {
            throw new RuntimeException("Simulated error occurred!");
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
