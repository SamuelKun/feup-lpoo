package com.aor.refactoring.example4;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerTest {

    @Test
    public void testWorker() {
        Person person = new Worker("John Doe", "+1 222-22222", "john", "secret");
        assertEquals("John Doe", person.getName());
        assertEquals("+1 222-22222", person.getPhone());
        assertFalse(person.login("john", "wrong"));
        assertTrue(person.login("john", "secret"));
    }

    @Test
    public void testSupervisor() {
        Supervisor supervisor = new Supervisor("John Doe", "+1 222-22222", "john", "secret");

        Person minion1 = new Client("Minion 1", "+1 123-12345");
        Person minion2 = new Client("Minion 2", "+1 123-12345");
        supervisor.addSupervisee(minion1);

        assertEquals("John Doe", supervisor.getName());
        assertEquals("+1 222-22222", supervisor.getPhone());
        assertFalse(supervisor.login("john", "wrong"));
        assertTrue(supervisor.login("john", "secret"));
        assertTrue(supervisor.isSupervisee(minion1));
        assertFalse(supervisor.isSupervisee(minion2));
    }

    @Test
    public void testClient() {
        Client client = new Client("John Doe", "+1 222-22222");
        assertEquals("John Doe", client.getName());
        assertEquals("+1 222-22222", client.getPhone());
    }
}