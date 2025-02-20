package com.wolfe.systembenchmark;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Unit test class
 */

public class BenchmarkUnitTests {

    /**
     *
     * Population tests validate that the requisite data structures are created and
     * are returned with the right sizes.
     *
     * Depopulation tests validate that the returned data structure's size is 0 as expected.
     */

    @Test
    void testArrayListPopulationSize() {
        ArrayList<Integer> testArrayList = SystemBenchmark.populateArrayList(100);
        assertEquals(100, testArrayList.size());
    }

    @Test
    void testArrayListDepopulationSize() {
        ArrayList<Integer> testArrayList = SystemBenchmark.populateArrayList(100);
        assertEquals(0, SystemBenchmark.depopulateArrayList(testArrayList).size());
    }

    @Test
    void testLinkedListPopulationSize() {
        LinkedList<Integer> testLinkedList = SystemBenchmark.populateLinkedLIst(100);
        assertEquals(100, testLinkedList.size());
    }

    @Test
    void testLinkedListDepopulationSize() {
        LinkedList<Integer> testLinkedList = SystemBenchmark.populateLinkedLIst(100);
        assertEquals(0, SystemBenchmark.depopulateLinkedList(testLinkedList).size());
    }

    @Test
    void testHashTablePopulationSize() {
        Hashtable<Integer, Integer> testHashtable = SystemBenchmark.populateHashtable(100);
        assertEquals(100, testHashtable.size());
    }

    @Test
    void testHashTableDepopulationSize() {
        Hashtable<Integer, Integer> testHashtable = SystemBenchmark.populateHashtable(100);
        assertEquals(0, SystemBenchmark.depopulateHashTable(testHashtable).size());
    }

    @Test
    void testQueuePopulationSize() {
        Queue<Integer> testQueue = SystemBenchmark.populateQueue(100);
        assertEquals(100, testQueue.size());
    }

    @Test
    void testQueueDepopulationSize() {
        Queue<Integer> testQueue = SystemBenchmark.populateQueue(100);
        assertEquals(0, SystemBenchmark.depopulateQueue(testQueue).size());
    }
}
