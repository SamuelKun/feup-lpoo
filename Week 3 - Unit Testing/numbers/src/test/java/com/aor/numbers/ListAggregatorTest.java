package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    private List<Integer> list;
    private List<Integer> list_neg;
    private List<Integer> list_distinct;

    @Before
    public void helper() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        list_neg = new ArrayList<>();
        list_neg.add(-1);
        list_neg.add(-4);
        list_neg.add(-5);

        list_distinct = new ArrayList<>();
        list_distinct.add(1);
        list_distinct.add(2);
        list_distinct.add(4);
        list_distinct.add(2);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(this.list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();

        ListAggregator aggregator_neg = new ListAggregator(list_neg);
        int max_neg = aggregator_neg.max();

        assertEquals(5, max);
        assertEquals(-1, max_neg);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class Stub implements IListDeduplicator {
            private final List<Integer> list_stub;

            Stub(List<Integer> list_stub) {
                this.list_stub = list_stub;
            }

            public List<Integer> deduplicate(IListSorter listSorter) {
                List<Integer> unique = new ArrayList<>();
                unique.add(1);
                unique.add(2);
                unique.add(4);

                return unique;
            }
        }

        ListAggregator aggregator = new ListAggregator(list);
        int distinct = aggregator.distinct(new ListDeduplicator(list));

        ListAggregator aggregator_dis = new ListAggregator(list_distinct);
        int distinct2 = aggregator_dis.distinct(new Stub(list));

        assertEquals(4, distinct);
        assertEquals(3, distinct2);
    }
}