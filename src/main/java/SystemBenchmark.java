import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SystemBenchmark {
    public static void main(String[] args) {
        int size = 1000000;

        runArrayListBenchmark(size);
        runLinkedListBenchmark(size);
        runHashTableBenchmark(size);
    }

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

    public static ArrayList<Integer> depopulateArrayList(ArrayList<Integer> arrayList) {

        while(!arrayList.isEmpty()){
            arrayList.remove(0);
        }
        return arrayList;
    }

    public static ArrayList<Integer> populateArrayList(int arrayListSize) {

        ArrayList<Integer> arrayListOfIntegers = new ArrayList<>();

        for(int i = 0; i < arrayListSize; i++){
            arrayListOfIntegers.add(ThreadLocalRandom.current().nextInt());
        }

        return arrayListOfIntegers;
    }

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

    public static LinkedList<Integer> depopulateLinkedList(LinkedList<Integer> linkedList) {

        while(!linkedList.isEmpty()){
            linkedList.remove(0);
        }

        return linkedList;
    }

    public static LinkedList<Integer> populateLinkedLIst(int linkedListSize) {

        LinkedList<Integer> linkedListOfIntegers = new LinkedList<>();

        for(int i = 0; i < linkedListSize; i++){
            linkedListOfIntegers.add(ThreadLocalRandom.current().nextInt());
        }

        return linkedListOfIntegers;
    }

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

    public static Hashtable<Integer, Integer> depopulateHashTable(Hashtable<Integer, Integer> hashTable) {

        Iterator<Map.Entry<Integer, Integer>> iterator = hashTable.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            iterator.remove();
        }

        return hashTable;
    }

    public static Hashtable<Integer, Integer> populateHashtable(int hashMapSize) {

        Hashtable<Integer, Integer> hashtableOfIntegers = new Hashtable<>();

        for(int i = 0; i < hashMapSize; i++) {
            hashtableOfIntegers.put(i, ThreadLocalRandom.current().nextInt());
        }

        return hashtableOfIntegers;
    }



}
