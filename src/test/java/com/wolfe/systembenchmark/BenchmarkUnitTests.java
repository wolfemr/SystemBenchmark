package com.wolfe.systembenchmark;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


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
        ArrayList<Integer> testArrayList = SystemBenchmark.populateArrayList(10);
        assertEquals(10, testArrayList.size());
    }

    @Test
    void testArrayListDepopulationSize() {
        ArrayList<Integer> testArrayList = SystemBenchmark.populateArrayList(10);
        assertEquals(0, SystemBenchmark.depopulateArrayList(testArrayList).size());
    }

    @Test
    void testLinkedListPopulationSize() {
        LinkedList<Integer> testLinkedList = SystemBenchmark.populateLinkedLIst(10);
        assertEquals(10, testLinkedList.size());
    }

    @Test
    void testLinkedListDepopulationSize() {
        LinkedList<Integer> testLinkedList = SystemBenchmark.populateLinkedLIst(10);
        assertEquals(0, SystemBenchmark.depopulateLinkedList(testLinkedList).size());
    }

    @Test
    void testHashTablePopulationSize() {
        Hashtable<Integer, Integer> testHashtable = SystemBenchmark.populateHashtable(10);
        assertEquals(10, testHashtable.size());
    }

    @Test
    void testHashTableDepopulationSize() {
        Hashtable<Integer, Integer> testHashtable = SystemBenchmark.populateHashtable(10);
        assertEquals(0, SystemBenchmark.depopulateHashTable(testHashtable).size());
    }
}
