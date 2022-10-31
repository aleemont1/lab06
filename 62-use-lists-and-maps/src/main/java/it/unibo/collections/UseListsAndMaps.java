package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;
    private static final int LOOPS = 10_000;
    private static final int START = 1000;
    private static final int END = 2000;
    private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final var list = new ArrayList<Integer>();
        for(int i = START; i < END; i++) {
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final var list2 = new LinkedList<Integer>();
        list2.addAll(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final var temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(final var i : list) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time1 = System.nanoTime();
        for(int i = 0; i < ELEMS; i++) {
            list.add(0, i);
        }
        time1 = System.nanoTime() - time1;

        long time2 = System.nanoTime();
        for(int i = 0; i < ELEMS; i++) {
            list2.add(0, i);
        }
        
        time2 = System.nanoTime() - time2;
        System.out.println("Inserting " + ELEMS + " elements in the head of the ArrayList took " + time1 + "ns (" + TimeUnit.NANOSECONDS.toMillis(time1) + "ms)");
        System.out.println("Inserting " + ELEMS + " elements in the head of the LinkedList took " + time2 + "ns (" + TimeUnit.NANOSECONDS.toMillis(time2) + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time1 = System.nanoTime();
        for(int i = 0; i < LOOPS; i++) {
            list.get(list.size() / 2);
        }
        time1 = System.nanoTime() - time1;

        time2 = System.nanoTime();
        for(int i = 0; i < LOOPS; i++) {
            list2.get(list2.size() / 2);
        }
        time2 = System.nanoTime() - time2;

        System.out.println("Reading " + LOOPS + " times an element in the middle of the ArrayList took " + time1 + "ns (" + TimeUnit.NANOSECONDS.toMillis(time1) + "ms)");
        System.out.println("Reading " + LOOPS + " times an element in the middle of the LinkedList took " + time2 + "ns (" + TimeUnit.NANOSECONDS.toMillis(time2) + "ms)");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final var map = Map.of("Africa", AFRICA_POPULATION, "Americas", AMERICAS_POPULATION, "Antarctica", ANTARCTICA_POPULATION, "Asia", ASIA_POPULATION, "Europe", EUROPE_POPULATION, "Oceania", OCEANIA_POPULATION,
                                "Asia", ASIA_POPULATION, "Europe", EUROPE_POPULATION, "Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        Number worldPop = 0L;
        for(final Number pop : map.values()) {
            worldPop = worldPop.longValue() + pop.longValue();
        }
        System.out.println("World population: " + worldPop.longValue());
    }
}
