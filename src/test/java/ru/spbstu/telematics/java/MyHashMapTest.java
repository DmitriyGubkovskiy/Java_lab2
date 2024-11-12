package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class MyHashMapTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MyHashMapTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MyHashMapTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSize() {
        HashMap<Integer, String> example = new HashMap<Integer, String>();
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        assertEquals(myExample.isEmpty(), example.isEmpty());
        example.put(1, "A");
        myExample.put(1, "A");
        assertEquals(myExample.size(), example.size());
        example.remove(1);
        myExample.remove(1);
        assertEquals(myExample.size(), example.size());
    }

    public void testPut() {
        HashMap<Integer, String> example = new HashMap<Integer, String>();
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        example.put(1, "A");
        myExample.put(1, "A");
        assertEquals(example.get(1), myExample.get(1));
        assertEquals(example.size(), myExample.size());

        myExample.put(1, "B");
        example.put(1, "B");
        assertEquals(example.get(1), myExample.get(1));
        assertEquals(example.size(), myExample.size());
    }

    public void testRemove() {
        HashMap<Integer, String> example = new HashMap<Integer, String>();
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        example.put(1, "A");
        myExample.put(1, "A");
        assertEquals(example.remove(1), myExample.remove(1));

    }

    public void testContainsKey() {
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        myExample.put(1, "A");
        assertTrue(myExample.containsKey(1));
        assertFalse(myExample.containsKey(2));
    }

    public void testContainsValue() {
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        myExample.put(1, "A");
        assertTrue(myExample.containsValue("A"));
        assertFalse(myExample.containsValue("B"));
    }

    public void testClear() {
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        myExample.put(1, "A");
        myExample.clear();
        assertTrue(myExample.isEmpty());
    }

    public void testKeySet() {
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        myExample.put(1, "A");
        myExample.put(2, "B");
        myExample.put(3, "C");
        HashSet<Integer> example = new HashSet<Integer>();
        example.add(1);
        example.add(2);
        example.add(3);

        assertEquals(example, myExample.keySet());
        myExample.remove(2);
        example.remove(2);
        assertEquals(example, myExample.keySet());
    }

    public void testValues() {
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        myExample.put(1, "A");
        myExample.put(2, "B");
        myExample.put(3, "C");
        ArrayList<String> example = new ArrayList<String>();
        example.add("A");
        example.add("B");
        example.add("C");

        assertEquals(example, myExample.values());
        myExample.remove(2);
        example.remove(1);
        assertEquals(example, myExample.values());
        myExample.put(4, "C");
        example.add("C");
        assertEquals(example, myExample.values());
    }

    public void testEntrySet() {
        HashMap<Integer, String> example = new HashMap<Integer, String>();
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        example.put(1, "A");
        myExample.put(1, "A");
        example.put(2, "B");
        myExample.put(2, "B");

        assertEquals(example.entrySet(), myExample.entrySet());
    }

    public void testPutAll() {
        HashMap<Integer, String> example = new HashMap<Integer, String>();
        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();

        example.put(1, "A");
        example.put(2, "B");

        myExample.putAll(example);

        assertEquals(example.entrySet(), myExample.entrySet());
        assertEquals(example, myExample);
    }

    public void testIterator() {

        MyHashMap<Integer, String> myExample = new MyHashMap<Integer, String>();
        myExample.put(1, "A");
        myExample.put(2, "B");
        myExample.put(3, "C");
        myExample.put(4, "D");

        HashSet<Integer> keys = new HashSet<Integer>();
        ArrayList<String> values = new ArrayList<String>();
        for (Map.Entry<Integer, String> x : myExample){
            keys.add(x.getKey());
            values.add(x.getValue());
        }
        assertEquals(keys, myExample.keySet());
        assertEquals(values, myExample.values());

        myExample.iterator().remove();
        keys.remove(1);
        values.remove("A");
        assertEquals(keys, myExample.keySet());
        assertEquals(values, myExample.values());

        assertEquals(values.get(0), myExample.iterator().next().getValue());
        assertTrue(myExample.iterator().hasNext());

    }

}
