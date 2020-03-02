package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    List<Integer> list1;
    List<Integer> expected1;

    @Before
    public void helper() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        list1.add(5);

        List<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(2);
        expected1.add(4);
        expected1.add(5);
    }

    @Test
    public void deduplicate() {

        IListDeduplicator deduplicator1 = new ListDeduplicator(list1);
        IListSorter sorter1 = new ListSorter(list1);
        List<Integer> distinct1 = deduplicator1.deduplicate(sorter1);

        //assertEquals(expected1, deduplicator1);
    }
}