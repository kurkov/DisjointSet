package com.github.kurkov.disjointset;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Aleksey Kurkov. Created on 07.12.2016
 */
public class DisjointSetTest {

    private DisjointSet disjointSet;

    @Before
    public void setUp() throws Exception {
        disjointSet = new DisjointSet();
    }

    @Test
    public void shouldCreateDisjointSet() {
        assertNotNull(disjointSet);
    }

    @Test
    public void shouldMakeSet() {
        disjointSet.MakeSet(1);
        disjointSet.MakeSet(2);
        disjointSet.MakeSet(3);
        disjointSet.MakeSet(4);
        disjointSet.MakeSet(5);
    }

    @Test
    public void shouldFindX_1() {
        shouldMakeSet();
        assertEquals(4, disjointSet.Find(4));
    }

    @Test
    public void shouldUnite_1() {
        shouldMakeSet();
        disjointSet.Unite(1, 4);
        disjointSet.Unite(3, 5);
    }

    @Test
    public void shouldFindX_2() {
        shouldUnite_1();
        //assertEquals(4, disjointSet.Find(4));
        assertEquals(1, disjointSet.Find(1));
        assertEquals(2, disjointSet.Find(2));
    }

    @Test
    public void shouldUnite_2() {
        shouldUnite_1();
        disjointSet.Unite(5,2);
    }

    @Test
    public void shouldFindX_3() {
        shouldUnite_2();
        assertEquals(2, disjointSet.Find(5));
        //assertEquals(2, disjointSet.Find(3));
    }
}