package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class ListSorterTest {
    private List<Integer> list1;
    private List<Integer> expected1;

    private List<Integer> list2;
    private List<Integer> expected2;

    @Before
    public void helper() {
        list1 = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        list1.add(6);
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(7);

        expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(2);
        expected1.add(3);
        expected1.add(4);
        expected1.add(5);
        expected1.add(6);
        expected1.add(7);

        list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        list2.add(2);

        expected2 = new ArrayList<>();
        expected2.add(1);
        expected2.add(2);
        expected2.add(2);
        expected2.add(4);
    }


    @Test
    public void sort() {
        class Stub implements IListSorter {
            private final List<Integer> lista;

            Stub(List<Integer> lista) {
                this.lista = lista;
            }

            public List<Integer> sort() {
                List<Integer> sorted = new ArrayList();
                for (Integer number : lista)
                    sorted.add(number);
                //sorted.sort(Comparator.naturalOrder());
                Collections.sort(sorted);
                return sorted;
            }
        }

        IListSorter sorter1 = new ListSorter(list1);
        List<Integer> sorted1 = sorter1.sort();

        IListSorter sorter2 = new Stub(list2);
        List<Integer> sorted2 = sorter2.sort();

        assertEquals(expected1, sorted1);
        assertEquals(expected2, sorted2);
    }
}